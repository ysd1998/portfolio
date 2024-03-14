package com.example.demo.controller.secondary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.book.Types;
import com.example.demo.form.book.BookInfo;
import com.example.demo.service.book.BookAdminService;
import com.example.demo.service.book.TypeSerchService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ManagerConfirmController {
	
	@Autowired
	public BookAdminService service;
	
	@Autowired
	public TypeSerchService typeservice;
	
	@GetMapping("/manager/confirm")
	public String confirm(
	        Model model, HttpServletRequest request) {

	    HttpSession session = request.getSession();
	    BookInfo bookData = (BookInfo) session.getAttribute("bookData");
	    Types type = typeservice.serchId(bookData.getTypeid());
	    model.addAttribute("bookData", bookData);
	    model.addAttribute("typeData", type);
//	    service.insert(bookData);
	    return "/manager/confirm";
	}

}
