package com.example.demo.controller.primary;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.primary.LoginForm;
import com.example.demo.service.primary.LoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	
	//private static final String LOGIN_ID ="user";
	
	//private static final String PASSWORD ="pwd";
	
	private final LoginService service;
	
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@GetMapping("/login")
	public String view(Model model,LoginForm form) {
		model.addAttribute("errorMsg", "");
		return "/login";
	}
	
	@PostMapping("/login")
	public String login(Model model,LoginForm form) {
		
		var userInfo = service.searchUserById(form.getLoginId());
		var isCorrectUserAuth = userInfo.isPresent()
				&& passwordEncoder.matches(form.getPassword(),userInfo.get().getPassword());
//		String digest = passwordEncoder.encode(userInfo.get().getPassword());
//        System.out.println("ハッシュ値 = " + digest);
		if (isCorrectUserAuth) {
			return "redirect:/menu";
		} else {
			model.addAttribute("errorMsg", "ログインIDとパスワードが間違ってます。");
			return "login";
		}
		
	}

}
