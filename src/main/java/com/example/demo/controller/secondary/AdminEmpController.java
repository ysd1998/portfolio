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

import com.example.demo.entity.employees.Employees;
import com.example.demo.service.employees.EmpSerchService;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

@ComponentScan
@Controller
@RequiredArgsConstructor
@RequestMapping("manager/admin")
public class AdminEmpController {

	private static final String VIEW = "manager/admin";

	@Autowired
	public EmpSerchService service;

	private static String serchDataseve;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, Pageable pageable) {
		Page<Employees> results;
		if (!StringUtils.isEmpty(serchDataseve)) {
			results = service.searchEmp(serchDataseve, serchDataseve, serchDataseve, pageable);
		} else {
			results = service.searchEmp("web販売担当", "web販売担当", "web販売担当", pageable);
		}
		List<Employees> result = results.getContent();
		model.addAttribute("pages", results);
		model.addAttribute("result", result);
		model.addAttribute("resultSize", result.size());
		return VIEW;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView serch(ModelAndView mav, Pageable pageable, @RequestParam("serchData") String serchData) {
		mav.setViewName(VIEW);
		serchDataseve = "";
		serchDataseve = serchData;
		Page<Employees> results;
		Pageable pagereset = pageable.withPage(0);
		if ("".equals(serchData)) {
			results = service.searchEmp("web販売担当", "web販売担当", "web販売担当", pagereset);
		} else {
			mav.addObject("serchData", serchData);
			results = service.searchEmp(serchData, serchData, serchData, pageable);
		}

		List<Employees> result = results.getContent();
		mav.addObject("pages", results);
		mav.addObject("result", result);
		mav.addObject("resultSize", result.size());
		if (result == null || result.size() == 0) {
			mav.addObject("errorMsg", "検索結果がありませんでした。");
		} else {
			mav.addObject("errorMsg", "");
		}
		return mav;
	}

}
