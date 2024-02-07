package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.LoginForm;
import com.example.demo.service.LoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PublishLoginController {
	
	//private static final String LOGIN_ID ="user";
	
	//private static final String PASSWORD ="pwd";
	
	private final LoginService service;
	
	@GetMapping("/publish/login")
	public String view(Model model,LoginForm form) {
		return "publish/login";
	}
	
	@PostMapping("/publish/login")
	public String login(Model model,LoginForm form) {
		var userInfo = service.searchUserById(form.getLoginId());
		var isCorrectUserAuth = userInfo.isPresent()
				&& form.getPassword().equals(userInfo.get().getPassword());
		if (isCorrectUserAuth) {
			return "redirect:/menu";
		} else {
			model.addAttribute("errorMsg", "ログインIDとパスワードが間違ってます。");
			return "publish/login";
		}
		
	}

}
