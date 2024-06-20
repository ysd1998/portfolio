package com.example.demo.controller.secondary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

@Controller
@RequiredArgsConstructor
public class ManagerInsertController {
	@Autowired
	public BookAdminService service;

	@Autowired
	public BookSerchService serch;

	@Autowired
	public TypeSerchService typeservice;

	static final private String DATE_FORMAT = "yyyy-MM-dd";

	@GetMapping("manager/bookinit")
	public String view(@ModelAttribute("bookData") BookInfo bookData, HttpServletRequest request, Model model) {
		Date date = new Date();
		String strDate;
		for (int i = 1;; i++) {
			String num = String.valueOf(i);
			if (num.length() <= 1) {
				num = "0" + num;
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
			strDate = dateFormat.format(date);
			strDate = "BK" + strDate + num;
			Optional<Books> check = serch.check(strDate);
			if (!check.isPresent()) {
				break;
			}
		}
		bookData.setBookid(strDate);
		model.addAttribute("bookData", bookData);
		List<Types> result = typeservice.serchData("%");
		model.addAttribute("Types", result);
		return "manager/bookinit";
	}

	@PostMapping("manager/bookinit")
	public String insertId(@Valid @ModelAttribute("bookData") BookInfo bookData,
			@AuthenticationPrincipal User user,
			@RequestParam("file") MultipartFile file,
			BindingResult bindingResult,
			HttpServletRequest request,
			Model model) throws Exception {
		model.addAttribute("bookData", bookData);
		String extension = "";
		String name = "";
		if (!file.isEmpty()) {
			bookData.setPhoto(file.getBytes());
			name = file.getOriginalFilename();
			extension = name.substring(name.lastIndexOf("."));
		}
		String isCorrectUserAuth = bookData.getBookid();
		String isTitle = bookData.getTitle();
		bookData.setWork("追加");
		HttpSession session = request.getSession();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(date);
		//		String bookDate = dateFormat.format(bookData.getYear());
		bookData.setInsertday(strDate);
		bookData.setInsertid(user.getUsername());
		bookData.setDeleteflag("0");
		session.setAttribute("bookData", bookData);
		boolean isNumeric = bookData.getPrice().matches("[+-]?\\d*(\\.\\d+)?");
		if (isCorrectUserAuth.equals("") || isTitle.equals("") || "".equals(bookData.getPublisher()) ||
				"".equals(bookData.getYear()) || "0".equals(bookData.getTypeid()) || "".equals(bookData.getPrice())
				|| "".equals(bookData.getEx())) {
			// || bookDate.equals(null)
			List<Types> result = typeservice.serchData("%");
			model.addAttribute("Types", result);
			model.addAttribute("errorMsg", "必須項目が空欄です。");
			return "manager/bookinit";
		} else if (isCorrectUserAuth.length() > 10 || isTitle.length() > 10 || bookData.getPublisher().length() > 8 ||
				bookData.getAuther().length() > 10 || bookData.getEx().length() > 1000
				|| bookData.getOther().length() > 1000 || bookData.getPrice().length() > 10) {
			List<Types> result = typeservice.serchData("%");
			model.addAttribute("Types", result);
			model.addAttribute("errorMsg", "文字数オーバーです。");
			return "manager/bookinit";
		} else if (!isNumeric) {
			List<Types> result = typeservice.serchData("%");
			model.addAttribute("Types", result);
			model.addAttribute("errorMsg", "価格項目に数字ではない文字・全角文字が挿入されています。削除してください。");
			return "manager/bookinit";
		} else if (!extension.equals(".png") && !"".equals(extension)) {
			List<Types> result = typeservice.serchData("%");
			model.addAttribute("Types", result);
			model.addAttribute("errorMsg", "フォルダの拡張子がPNGではありません。");
			return "manager/bookinit";
		} else {
			return "redirect:/manager/confirm";

		}

	}

}
