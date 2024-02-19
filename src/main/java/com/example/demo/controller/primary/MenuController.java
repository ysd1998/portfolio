package com.example.demo.controller.primary;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.primary.Clients;
import com.example.demo.form.primary.LoginForm;
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
	public String index() {
		return VIEW;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView serch(ModelAndView mav, @RequestParam("serchData") String serchData) {
		mav.setViewName(VIEW);
		mav.addObject("client_id", serchData);
		mav.addObject("name", serchData);
		mav.addObject("password",serchData);
		List<Clients> result = service.search(serchData, serchData, serchData);
		mav.addObject("result", result);
		mav.addObject("resultSize", result.size());
		return mav;
	}
	@PostMapping("/menu")
	public String serchs(Model model,LoginForm form) {
		return "redirect:/data";
		
	}
	
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
	@RequestMapping("/getImg")
	@ResponseBody
	public HttpEntity<byte[]> getImg(@RequestParam("imgname") String fileName){
		File fileImg = new File("picture"+fileName +".png");
		
		byte[] byteImg = null;
		HttpHeaders headers = null;
		try {
			//バイト列に変換
			byteImg = Files.readAllBytes(fileImg.toPath());
			headers = new HttpHeaders();
			
			//Responseのヘッダーを作成
			headers.setContentType(MediaType.IMAGE_PNG);
			headers.setContentLength(byteImg.length);
		}catch(IOException e) {
			return null;
		}
		return new HttpEntity<byte[]>(byteImg,headers);
	}

}
