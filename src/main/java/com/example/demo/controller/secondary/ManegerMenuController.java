package com.example.demo.controller.secondary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManegerMenuController {
	
	@GetMapping("manager/menu")
	public String view() {
		
		return "manager/menu";
	}

}
