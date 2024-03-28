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

import com.example.demo.entity.secondary.Employees;
import com.example.demo.service.secondary.EmpSerchService;

import lombok.RequiredArgsConstructor;

@ComponentScan
@Controller
@RequiredArgsConstructor
@RequestMapping("/manager/admin")
public class AdminEmpController {
	
	private static final String VIEW = "/manager/admin";
	
	@Autowired
	public EmpSerchService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model,Pageable pageable) {
		Page<Employees> results = service.searchEmp("", "", "web販売担当", pageable);
		List<Employees> result = results.getContent();
		model.addAttribute("pages", results);
		model.addAttribute("result",result);
		model.addAttribute("resultSize", result.size());
		return VIEW;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView serch(ModelAndView mav,Pageable pageable, @RequestParam("serchData")String serchData) {
		mav.setViewName(VIEW);
		mav.addObject("loginid", serchData);
		mav.addObject("name", serchData);
		mav.addObject("authority",serchData);
		Page<Employees> results = service.searchEmp(serchData, serchData, serchData,pageable);
		List<Employees> result = results.getContent();
		mav.addObject("pages", results);
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
