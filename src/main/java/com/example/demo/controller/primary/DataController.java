package com.example.demo.controller.primary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.book.Books;
import com.example.demo.service.book.BookSerchService;

@ComponentScan
@Controller
//@RequiredArgsConstructor
//@RequestMapping("/bookdata")
public class DataController {
//	private static final String VIEW = "/bookdata/{id}";
	@Autowired
	public BookSerchService service;
	@GetMapping("{id}")
	public String index(Model model,@PathVariable String id) {
		Books book = service.findById(id);
		model.addAttribute("bookData", book);
		return "/bookdata";
	}

}