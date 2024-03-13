package com.example.demo.controller.secondary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.book.Books;
import com.example.demo.service.book.BookSerchService;

import lombok.RequiredArgsConstructor;

@ComponentScan
@Controller
@RequiredArgsConstructor
@RequestMapping("/manager/menu")
public class ManegerMenuController {
	
	private static final String VIEW = "/manager/menu";
	
	private final String limit = "3";
	
	private int showPageSize = 3;
	
	@Autowired
	public BookSerchService service;
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model,Pageable pageable) {
		Page<Books> results = service.search("", "", "", "",pageable);
		List<Books> result = results.getContent();
		model.addAttribute("result",result);
		model.addAttribute("resultSize", result.size());
		return VIEW;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView serch(ModelAndView mav,Pageable pageable, @RequestParam("serchData") String serchData) {
		mav.setViewName(VIEW);
		mav.addObject("title", serchData);
		mav.addObject("auther", serchData);
		mav.addObject("price",serchData);
		Page<Books> results = service.search(serchData, serchData, serchData, serchData,pageable);
		List<Books> result = results.getContent();
		mav.addObject("result", result);
		mav.addObject("resultSize", result.size());
		if (result== null || result.size() == 0) {
			mav.addObject("errorMsg","検索結果がありませんでした。");	
		} else {
			mav.addObject("errorMsg","");
		}
		return mav;
	}

}
