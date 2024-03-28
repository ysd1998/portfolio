package com.example.demo.controller.secondary;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.secondary.LoginForm;
import com.example.demo.service.secondary.EmpLoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ManagerLoginController {
	
	private final EmpLoginService service;
	
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	//ログイン画面（社員側）
	@GetMapping("/manager/login")
	public String view(Model model,LoginForm form) {
		return "manager/login";
	}
	
	//ログイン後の処理
	@PostMapping("/manager/login")
	public String login(Model model,LoginForm form) {
		var userInfo = service.searchUserById(form.getLoginid());
		var isCorrectUserAuth = userInfo.isPresent()
				&& passwordEncoder.matches(form.getPassword(),userInfo.get().getPassword());
		if (isCorrectUserAuth) {
			return "redirect:/manager/menu";
		} else {
			model.addAttribute("errorMsg", "ログインIDとパスワードが間違ってます。");
			return "manager/login";
		}
		
	}

}
