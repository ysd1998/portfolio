package com.example.demo.controller.primary;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.form.primary.SerchForm;
import com.example.demo.service.primary.SerchService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MenuController {
	
	private final SerchService service;
	
	@GetMapping("/menu")
	public String view(Model model,SerchForm form) {
		
		return "menu";
	}
	
	@PostMapping("/menu")
	public String serch(Model model,SerchForm form) {
		var userInfo = service.searchData(form.getSerchData());
		model.addAttribute("result", userInfo.get());
		return "/menu";
		
	}
	
	@RequestMapping("/getImg")
	@ResponseBody
	public HttpEntity<byte[]> getImg(@RequestParam("name") String fileName){
		File fileImg = new File("../picture/"+ fileName +".png");
		
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
