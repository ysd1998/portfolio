package com.example.demo.controller.secondary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.book.Books;
import com.example.demo.entity.book.Types;
import com.example.demo.form.book.BookInfo;
import com.example.demo.service.book.BookAdminService;
import com.example.demo.service.book.BookSerchService;
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
	public BookSerchService serch;
	
	@Autowired
	public TypeSerchService typeservice;
	
	@GetMapping("manager/bookinit")
	public String view(@ModelAttribute("bookData")BookInfo bookData,HttpServletRequest request,Model model) {
		Date date = new Date();
		String strDate;
		for (int i=1;;i++) {
			String num = String.valueOf(i);
			if (num.length() <=1) {
				num = "0"+num;
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
			strDate = dateFormat.format(date);
			strDate = "BK"+strDate+num;
			Optional<Books> check = serch.check(strDate);
			if (! check.isPresent()) {
				break;
			}
		}
		bookData.setBookid(strDate);
		model.addAttribute("bookData", bookData);
		List<Types> result = typeservice.serchData("%");
		model.addAttribute("Types", result);
		
		return "manager/bookinit";
	}
	
	@PostMapping("manager/bookinit")
	public String insertId(@Valid @ModelAttribute("bookData")BookInfo bookData,
						@AuthenticationPrincipal User user,
						BindingResult bindingResult,
						HttpServletRequest request,
						 Model model) {
		model.addAttribute("bookData", bookData);
		
		String isCorrectUserAuth = bookData.getBookid();
		String isTitle = bookData.getTitle();
		bookData.setWork("追加");
		HttpSession session = request.getSession();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(date);
		bookData.setInsertday(strDate);
		bookData.setInsertid(user.getUsername());
		bookData.setDeleteflag("0");
		session.setAttribute("bookData", bookData);
		if (isCorrectUserAuth.equals("") || isTitle.equals("") || "".equals(bookData.getPublisher()) ||
				"".equals(bookData.getYear()) || "0".equals(bookData.getTypeid()) || "".equals(bookData.getPrice())) {
			List<Types> result = typeservice.serchData("%");
			model.addAttribute("Types", result);
			model.addAttribute("errorMsg","必須項目が空欄です。");
			return "manager/bookinit";
		} else if (isCorrectUserAuth.length() > 10 || isTitle.length() > 10 || bookData.getPublisher().length() > 10 ||
				bookData.getAuther().length() > 10 || bookData.getEx().length() > 1000 || bookData.getOther().length() > 1000||
				bookData.getPrice().length() > 10) {
			List<Types> result = typeservice.serchData("%");
			model.addAttribute("Types", result);
			model.addAttribute("errorMsg","文字数オーバーです。");
			return "manager/bookinit";
		} else {
			return "redirect:manager/confirm";
			
		}
		
	}

}
