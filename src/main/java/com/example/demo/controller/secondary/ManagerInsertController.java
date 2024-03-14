package com.example.demo.controller.secondary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.book.Types;
import com.example.demo.form.book.BookInfo;
import com.example.demo.service.book.BookAdminService;
import com.example.demo.service.book.TypeSerchService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ManagerInsertController {
	@Autowired
	public BookAdminService service;
	
	@Autowired
	public TypeSerchService typeservice;
	
	@GetMapping("/manager/bookinit")
	public String view(@ModelAttribute("bookData")BookInfo bookData,HttpServletRequest request,Model model) {
		model.addAttribute("bookData", bookData);
		List<Types> result = typeservice.serchData("%");
		model.addAttribute("Types", result);
		return "/manager/bookinit";
	}
	
	@PostMapping("/manager/bookinit")
	public String insertId(@Valid @ModelAttribute("bookData")BookInfo bookData,
						BindingResult bindingResult,
						HttpServletRequest request,
						 Model model) {
		model.addAttribute("bookData", bookData);
		String isCorrectUserAuth = bookData.getBookid();
		bookData.setWork("追加");
		HttpSession session = request.getSession();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(date);
		bookData.setInsertday(strDate);
		bookData.setInsertid("24020801");
		bookData.setDeleteflag("0");
		session.setAttribute("bookData", bookData);
//		service.insert(bookData);
		if (isCorrectUserAuth.equals("")) {
			return "/manager/bookinit";
		} else {
//			model.addAttribute("errorMsg", "ログインIDとパスワードが間違ってます。");
			return "redirect:/manager/confirm";
			
		}
		
	}

}
