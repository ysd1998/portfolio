package com.example.demo.controller.secondary;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class ManagerConfirmController {
	
	@Autowired
	public BookAdminService service;
	
	@Autowired
	public BookSerchService serch;
	
	@Autowired
	public TypeSerchService typeservice;
	
	@GetMapping("/manager/confirm")
	public String confirm(
	        Model model, HttpServletRequest request) {

	    HttpSession session = request.getSession();
	    BookInfo bookData = (BookInfo) session.getAttribute("bookData");
	    Types type = typeservice.serchId(bookData.getTypeid());
	    if ("追加".equals(bookData.getWork())) {
	    	model.addAttribute("mesage","こちらの内容を追加しますか？");
	    } else if ("更新".equals(bookData.getWork())) {
	    	model.addAttribute("mesage","こちらの内容を更新しますか？");
	    } else if ("削除".equals(bookData.getWork())) {
	    	model.addAttribute("mesage","こちらの内容を削除しますか？");
	    }
	    model.addAttribute("bookData", bookData);
	    model.addAttribute("typeData", type);
//	    service.insert(bookData);
	    return "/manager/confirm";
	}
	
	@PostMapping("/manager/confirm")
	public String confirmOK(@Valid @ModelAttribute("bookData")BookInfo bookData,
			Model model, HttpServletRequest request) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(date);
		Books list;
		if ("追加".equals(bookData.getWork())) {
			bookData.setInsertday(strDate);
			bookData.setInsertid("24020801");
			bookData.setDeleteflag("0");
	    } else if ("更新".equals(bookData.getWork())) {
	    	list = serch.serchId(bookData.getBookid());
	    	bookData.setInsertday(list.getInsertday());
			bookData.setInsertid(list.getInsertid());
	    	bookData.setUpdateday(strDate);
			bookData.setUpdateid("24020801");
			bookData.setDeleteflag("0");
	    } else if ("削除".equals(bookData.getWork())) {
	    	list = serch.serchId(bookData.getBookid());
	    	bookData.setInsertday(list.getInsertday());
			bookData.setInsertid(list.getInsertid());
			bookData.setUpdateday(list.getUpdateday());
			bookData.setUpdateid(list.getUpdateid());
	    	bookData.setDeleteday(strDate);
			bookData.setDeleteid("24020801");
	    	bookData.setDeleteflag("1");
	    }
	    service.insert(bookData);
	    return "redirect:/manager/menu";
	}

}
