package com.example.demo.controller.secondary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.employees.Departments;
import com.example.demo.entity.employees.Employees;
import com.example.demo.form.secondary.LoginForm;
import com.example.demo.service.employees.DepSerchService;
import com.example.demo.service.employees.EmpSerchService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminAuthoritiesController {
	
	@Autowired
	public EmpSerchService service;
	
	@Autowired
	public DepSerchService depservice;
	
	@GetMapping("manager/authority/{loginid}")
	public String view(@PathVariable String loginid,@ModelAttribute("empData")LoginForm empData,
			@ModelAttribute("authData")LoginForm authData,HttpServletRequest request,Model model) {
		if (loginid != null) {
			System.out.println("error");
		}
		Employees emp = service.searchId(loginid);
		model.addAttribute("empData", emp);
		model.addAttribute("authData", emp);
		Departments result = depservice.serchId(emp.getDid());
		model.addAttribute("depData", result);
		if ("".equals(emp.getAuthority())) {
			model.addAttribute("mesage", "web販売担当権限を付与しますか？");
		} else {
			model.addAttribute("mesage", "web販売担当権限を削除しますか？");
		}
		return "manager/authority";
	}
	
	@PostMapping("manager/authority")
	public String confirmOK(@ModelAttribute("authData")LoginForm authData,
			Model model, HttpServletRequest request) {
		Employees emp = service.searchId(authData.getLoginid());
		if ("web販売担当".equals(authData.getAuthority())) {
	    	authData.setAuthority("権限なし");
	    } else if ("権限なし".equals(authData.getAuthority())) {
	    	authData.setAuthority("web販売担当");
	    }
		authData.setPassword(emp.getPassword());
	    service.insert(authData);
	    return "redirect:/manager/admin";
	}

}
