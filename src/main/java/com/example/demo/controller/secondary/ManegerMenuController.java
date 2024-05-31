package com.example.demo.controller.secondary;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.book.Books;
import com.example.demo.entity.book.Types;
import com.example.demo.service.book.BookSerchService;
import com.example.demo.service.book.TypeSerchService;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

@ComponentScan
@Controller
@RequiredArgsConstructor
@RequestMapping("manager/menu")
public class ManegerMenuController {

	private static final String VIEW = "manager/menu";

	@Autowired
	public BookSerchService service;

	@Autowired
	public TypeSerchService typeserch;
	
	private static String serchDataseve;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, Pageable pageable,@RequestParam(name = "serchData", required = false) String serchData) {
//		String serchData = "";
		Page<Books> results;
		if (!StringUtils.isEmpty(serchDataseve)) {
			results = service.search(serchDataseve, serchDataseve, serchDataseve, serchDataseve, pageable);
		} else {
			results = service.search("", "", "", "", pageable);
		}
		model.addAttribute("serchData", serchData);
		List<Books> result = results.getContent().stream()
				.distinct().collect(Collectors.toList());
		model.addAttribute("pages", results);
		model.addAttribute("result", result);
		model.addAttribute("resultSize", result.size());
		return VIEW;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String serch(Model model,Pageable pageable, @RequestParam("serchData") String serchData) {
		Types type = typeserch.serchNames(serchData);
		serchDataseve = "";
		serchDataseve = serchData;
		String typeid;
		if (type == null || "".equals(type)) {
			typeid = serchData;
		} else {
			typeid = type.getTypeid();
		}
		model.addAttribute("serchData", serchData);
		Page<Books> results = service.search(serchData, serchData, serchData, serchData, pageable);
		List<Books> result = results.getContent();
		model.addAttribute("pages", results);
		model.addAttribute("result", result);
		model.addAttribute("resultSize", result.size());
		if (result == null || result.size() == 0) {
			model.addAttribute("errorMsg", "検索結果がありませんでした。");
		} else {
			model.addAttribute("errorMsg", "");
		}
		return VIEW;
	}

}
