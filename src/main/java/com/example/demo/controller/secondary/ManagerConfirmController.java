package com.example.demo.controller.secondary;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.book.Books;
import com.example.demo.entity.book.Types;
import com.example.demo.form.book.BookInfo;
import com.example.demo.service.book.BookAdminService;
import com.example.demo.service.book.BookSerchService;
import com.example.demo.service.book.TypeSerchService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ManagerConfirmController {

	@Autowired
	public BookAdminService service;

	@Autowired
	public BookSerchService serch;

	@Autowired
	public TypeSerchService typeservice;

	//確認画面
	@GetMapping("manager/confirm")
	public String confirm(
			Model model, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		BookInfo bookData = (BookInfo) session.getAttribute("bookData");
		String base64;
		if (bookData.getPhoto() != null) {
			base64 = new String(Base64.encodeBase64(bookData.getPhoto(), true), "ASCII");
		} else {
			base64 = "";
		}
		if (bookData.getPhoto() == null || "".equals(base64) || base64 == null) {
			File fileImg = new File("src/main/resources/templates/picture/20200501_noimage.png");
			byte[] byteImg = Files.readAllBytes(fileImg.toPath());
			base64 = new String(Base64.encodeBase64(byteImg, true), "ASCII");
			StringBuffer data = new StringBuffer();
			data.append("data:image/png;base64,");
			data.append(base64);
			model.addAttribute("base64AccountIcon", data.toString());
		} else {

			StringBuffer data = new StringBuffer();
			data.append("data:image/png;base64,");
			data.append(base64);

			model.addAttribute("base64AccountIcon", data.toString());
		}
		Types type = typeservice.serchId(bookData.getTypeid());
		if ("追加".equals(bookData.getWork())) {
			model.addAttribute("mesage", "こちらの内容を追加しますか？");
		} else if ("更新".equals(bookData.getWork())) {
			model.addAttribute("mesage", "こちらの内容を更新しますか？");
		} else if ("削除".equals(bookData.getWork())) {
			model.addAttribute("mesage", "こちらの内容を削除しますか？");
		}
		model.addAttribute("bookData", bookData);
		model.addAttribute("typeData", type);
		return "manager/confirm";
	}

	//作業処理
	@PostMapping("manager/confirm")
	public String confirmOK(@Valid @ModelAttribute("bookData") BookInfo bookData,
			@AuthenticationPrincipal User user,
			Model model, HttpServletRequest request) throws Exception {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(date);
		String base64 = new String(Base64.encodeBase64(bookData.getPhoto(), true), "ASCII");
		if ("".equals(base64)) {
			bookData.setPhoto(null);
		}
		Books list;
		if ("追加".equals(bookData.getWork())) {
			bookData.setInsertday(strDate);
			bookData.setInsertid(user.getUsername());
			bookData.setDeleteflag("0");
		} else if ("更新".equals(bookData.getWork())) {
			list = serch.serchId(bookData.getBookid());
			if ("".equals(base64) && list.getPhoto() != null) {
				bookData.setPhoto(list.getPhoto());
			}
			bookData.setInsertday(list.getInsertday());
			bookData.setInsertid(list.getInsertid());
			bookData.setUpdateday(strDate);
			bookData.setUpdateid(user.getUsername());
			bookData.setDeleteflag("0");
		} else if ("削除".equals(bookData.getWork())) {
			list = serch.serchId(bookData.getBookid());
			bookData.setInsertday(list.getInsertday());
			bookData.setInsertid(list.getInsertid());
			bookData.setUpdateday(list.getUpdateday());
			bookData.setUpdateid(list.getUpdateid());
			bookData.setDeleteday(strDate);
			bookData.setDeleteid(user.getUsername());
			bookData.setDeleteflag("1");
		}
		service.insert(bookData);
		return "redirect:/manager/index";
	}

}
