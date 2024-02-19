package com.example.demo.controller.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.primary.SerchService;

@ComponentScan
@Controller
//@RequiredArgsConstructor
@RequestMapping("/data")
public class DataController {
	private static final String VIEW = "/data";
	@Autowired
	public SerchService service;
	@RequestMapping(method = RequestMethod.POST)
	public String index() {
		return VIEW;
	}

}
