package com.example.demo.controller.primary;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.primary.LoginForm;
import com.example.demo.service.primary.LoginService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

	private final LoginService service;

	private final PasswordEncoder passwordEncoder;

	private final HttpSession session;

	//ログイン画面（ユーザー側）
	@GetMapping("login")
	public String view(Model model, LoginForm form) {
		model.addAttribute("errorMsg", "");
		return "login";
	}

	@GetMapping(value = "login", params = "error")
	public String error(Model model, LoginForm form) {
		var errorInfo = (Exception) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		String errormesage = "ログインIDとパスワードが間違ってます。";
		if (!"".equals(errorInfo)) {
			model.addAttribute("errorMsg", errormesage);
		}
		return "login";
	}

	//ログイン後の処理
	@PostMapping("login")
	public String login(Model model, LoginForm form) {
		var userInfo = service.searchUserById(form.getLoginid());
		var errorInfo = (Exception) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		model.addAttribute("errorMsg", errorInfo.getMessage());
		var isCorrectUserAuth = userInfo.isPresent()
				&& passwordEncoder.matches(form.getPassword(), userInfo.get().getPassword());
		if (isCorrectUserAuth) {
			return "redirect:menu";
		} else {
			return "login";
		}

	}

}
