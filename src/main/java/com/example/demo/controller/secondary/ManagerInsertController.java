package com.example.demo.controller.secondary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.book.BookInfo;
import com.example.demo.service.book.BookAdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ManagerInsertController {
	@Autowired
	public BookAdminService service;
	
	@GetMapping("/manager/bookinit")
	public String view(@ModelAttribute("bookData") BookInfo bookData,HttpServletRequest request,Model model) {
		model.addAttribute("bookData", bookData);
		return "/manager/bookinit";
	}
	
	@PostMapping("/manager/bookinit")
	public String insert(@Valid @ModelAttribute("bookData") BookInfo bookData,
						BindingResult bindingResult,
						HttpServletRequest request,
						 Model model) {
		String isCorrectUserAuth = bookData.getBook_id();
		if (isCorrectUserAuth.equals("")) {
			bookData.setWork("追加");
			HttpSession session = request.getSession();
			session.setAttribute("bookData", bookData);
			return "redirect:/confirm";
		} else {
//			model.addAttribute("errorMsg", "ログインIDとパスワードが間違ってます。");
			return "/manager/bookinit";
		}
		
	}

}
