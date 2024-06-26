package com.example.demo.controller.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.book.Books;
import com.example.demo.entity.book.Types;
import com.example.demo.service.book.BookSerchService;
import com.example.demo.service.book.TypeSerchService;

@ComponentScan
@Controller
public class DataController {
	@Autowired
	public BookSerchService service;

	@Autowired
	public TypeSerchService typeservice;

	//詳細画面に本の情報を出力
	@GetMapping("data/{id}")
	public String index(Model model, @PathVariable String id) throws Exception {
		Books book = service.serchId(id);
		//		var book = service.check(id);
		Types type = typeservice.serchId(book.getTypeid());
		//		var type = typeservice.check(book.get().getTypeid());
		model.addAttribute("bookData", book);
		model.addAttribute("typeData", type);
		return "bookdata";
	}

}