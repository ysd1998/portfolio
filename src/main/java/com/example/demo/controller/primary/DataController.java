package com.example.demo.controller.primary;

import java.io.File;
import java.nio.file.Files;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.book.Books;
import com.example.demo.entity.book.Types;
import com.example.demo.service.book.BookSerchService;
import com.example.demo.service.book.TypeSerchService;

@ComponentScan
@Controller
public class DataController {
	@Autowired
	public BookSerchService service;

	@Autowired
	public TypeSerchService typeservice;

	//詳細画面に本の情報を出力
	@GetMapping("{id}")
	public String index(Model model, @PathVariable String id) throws Exception {
		Books book = service.serchId(id);
		//		var book = service.check(id);
		if (book.getPhoto() == null) {
			File fileImg = new File("src/main/resources/templates/picture/20200501_noimage.png");
			byte[] byteImg = Files.readAllBytes(fileImg.toPath());
			StringBuffer data = new StringBuffer();
			String base64 = new String(Base64.encodeBase64(byteImg, true), "ASCII");
			data.append("data:image/png;base64,");
			data.append(base64);
			model.addAttribute("base64AccountIcon", data.toString());
		} else {

			StringBuffer data = new StringBuffer();

			String base64 = new String(Base64.encodeBase64(book.getPhoto(), true), "ASCII");

			data.append("data:image/png;base64,");
			data.append(base64);

			model.addAttribute("base64AccountIcon", data.toString());
		}
		Types type = typeservice.serchId(book.getTypeid());
		//		var type = typeservice.check(book.get().getTypeid());
		model.addAttribute("bookData", book);
		model.addAttribute("typeData", type);
		return "bookdata";
	}

}