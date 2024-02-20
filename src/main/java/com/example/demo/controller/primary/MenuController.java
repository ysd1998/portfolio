package com.example.demo.controller.primary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.primary.Clients;
import com.example.demo.service.primary.SerchService;


@ComponentScan
@Controller
//@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
	
//	private final SerchService service;
//	
	private static final String VIEW = "/menu";
	@Autowired
	public SerchService service;
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model,Pageable pageable) {
		List<Clients> result = service.search("", "", "");
		model.addAttribute("result",result);
		model.addAttribute("resultSize", result.size());
		return VIEW;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView serch(ModelAndView mav,Pageable pageable, @RequestParam("serchData") String serchData) {
		mav.setViewName(VIEW);
		mav.addObject("client_id", serchData);
		mav.addObject("name", serchData);
		mav.addObject("password",serchData);
		List<Clients> result = service.search(serchData, serchData, serchData);
		mav.addObject("result", result);
		mav.addObject("resultSize", result.size());
		if (result== null || result.size() == 0) {
			mav.addObject("errorMsg","検索結果がありませんでした。");	
		} else {
			mav.addObject("errorMsg","");
		}
		return mav;
	}
//	@PostMapping("/menu")
//	public String serchs(Model model,LoginForm form) {
//		return "redirect:/data";
//		
//	}
	
//	
////	@RequestMapping("/menu")
////	public String serch(Model model,SerchForm form) {
////		var userInfo = service.login(form.getSerchData(),form);
////		//UserInfo user = userInfo.get();user.getLoginid()
////		model.addAttribute("result", userInfo);
////		return "/menu";
////		
////	}
//	

}
