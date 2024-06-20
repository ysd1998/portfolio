package com.example.demo.controller.secondary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ManagerAdminController {
	@Autowired
	public BookAdminService admin;

	@Autowired
	public BookSerchService serch;

	@Autowired
	public TypeSerchService typeservice;

	static final private String DATE_FORMAT = "yyyy-MM-dd";

	@GetMapping("manager/{id}")
	public String view(@PathVariable String id, @ModelAttribute("bookData") BookInfo bookData,
			@ModelAttribute("deleteData") BookInfo DeleteData, HttpServletRequest request, Model model)
			throws Exception {
		Books book = serch.serchId(id);
		log.info(book.toString());
		model.addAttribute("bookData", book);
		model.addAttribute("deleteData", book);
		List<Types> result = typeservice.serchData("%");
		model.addAttribute("Types", result);
		return "manager/bookadmin";
	}

	@PostMapping("manager/{id}")
	public String updateId(@Valid @ModelAttribute("bookData") BookInfo bookData,
			@AuthenticationPrincipal User user,
			@RequestParam("file") MultipartFile file,
			BindingResult bindingResult,
			HttpServletRequest request,
			Model model) throws Exception {
		model.addAttribute("bookData", bookData);
		if (file != null) {
			bookData.setPhoto(file.getBytes());
		}
		String isCorrectUserAuth = bookData.getBookid();
		String isTitle = bookData.getTitle();
		bookData.setWork("更新");
		Date date = new Date();
		//		String access = "manager/" + isCorrectUserAuth;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(date);
		bookData.setUpdateday(strDate);
		bookData.setUpdateid(user.getUsername());
		bookData.setDeleteflag("0");
		Books book = serch.serchId(bookData.getBookid());
		HttpSession session = request.getSession();
		session.setAttribute("bookData", bookData);
		String extension = "";
		String name = "";
		if (!file.isEmpty()) {
			name = file.getOriginalFilename();
			extension = name.substring(name.lastIndexOf("."));
		}
		boolean isNumeric = bookData.getPrice().matches("[+-]?\\d*(\\.\\d+)?");
		if (isCorrectUserAuth.equals("") || isTitle.equals("") || "".equals(bookData.getPublisher()) ||
				"".equals(bookData.getYear()) || "0".equals(bookData.getTypeid()) || "".equals(bookData.getPrice())
				|| "".equals(bookData.getEx())) {
			model.addAttribute("bookData", book);
			model.addAttribute("deleteData", book);
			List<Types> result = typeservice.serchData("%");
			model.addAttribute("Types", result);
			model.addAttribute("errorMsg", "必須項目が空欄です。");
			return "manager/bookadmin";
		} else if (isCorrectUserAuth.length() > 10 || isTitle.length() > 10 || bookData.getPublisher().length() > 8 ||
				bookData.getAuther().length() > 10 || bookData.getEx().length() > 1000
				|| bookData.getOther().length() > 1000 ||
				bookData.getPrice().length() > 10) {
			model.addAttribute("bookData", book);
			model.addAttribute("deleteData", book);
			List<Types> result = typeservice.serchData("%");
			model.addAttribute("Types", result);
			model.addAttribute("errorMsg", "文字数オーバーです。");
			return "manager/bookadmin";
		} else if (!isNumeric) {
			model.addAttribute("bookData", book);
			model.addAttribute("deleteData", book);
			List<Types> result = typeservice.serchData("%");
			model.addAttribute("Types", result);
			model.addAttribute("errorMsg", "価格項目に数字ではない文字・全角文字が挿入されています。削除してください。");
			return "manager/bookadmin";
		} else if (!extension.equals("png") && !"".equals(extension)) {
			List<Types> result = typeservice.serchData("%");
			model.addAttribute("Types", result);
			model.addAttribute("errorMsg", "フォルダの拡張子がPNGではありません。");
			return "manager/bookadmin";
		} else {
			return "redirect:/manager/confirm";

		}

	}

	@PostMapping("manager/delete/{id}")
	public String deleteId(@Valid @ModelAttribute("deleteData") BookInfo DeleteData,
			@AuthenticationPrincipal User user,
			BindingResult bindingResult,
			HttpServletRequest request,
			Model model) {
		model.addAttribute("bookData", DeleteData);
		String isCorrectUserAuth = DeleteData.getBookid();
		String isTitle = DeleteData.getTitle();
		DeleteData.setWork("削除");
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(date);
		DeleteData.setDeleteday(strDate);
		DeleteData.setDeleteid(user.getUsername());
		DeleteData.setDeleteflag("1");
		HttpSession session = request.getSession();
		Books book = serch.serchId(DeleteData.getBookid());
		if (book.getPhoto() != null) {
			DeleteData.setPhoto(book.getPhoto());
		}
		session.setAttribute("bookData", DeleteData);
		if (isCorrectUserAuth.equals("") || isTitle.equals("")) {
			List<Types> result = typeservice.serchData("%");
			model.addAttribute("Types", result);
			return "manager/{id}";
		} else {
			return "redirect:/manager/confirm";

		}

	}

}
