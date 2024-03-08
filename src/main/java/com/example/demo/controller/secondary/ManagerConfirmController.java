package com.example.demo.controller.secondary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.book.BookInfo;
import com.example.demo.service.book.BookAdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ManagerConfirmController {
	
	@Autowired
	public BookAdminService service;
	
	@RequestMapping("/manager/confirm")
	public String confirm(
	        Model model, HttpServletRequest request) {

	    HttpSession session = request.getSession();
	    BookInfo bookData = (BookInfo) session.getAttribute("bookData");
	    model.addAttribute("bookData", bookData);
	    service.insert(bookData);
	    return "/manager/confirm";
	}

}
