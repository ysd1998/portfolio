package com.example.demo.controller.primary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.book.Books;
import com.example.demo.service.book.BookSerchService;
import com.example.demo.service.book.TypeSerchService;

import io.micrometer.common.util.StringUtils;

//@RequiredArgsConstructor
@ComponentScan
@Controller
@RequestMapping("menu")
public class MenuController {

	private static final String VIEW = "menu";

	@Autowired
	public BookSerchService service;

	@Autowired
	public TypeSerchService typeservice;

	private static String serchDataseve;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, Pageable pageable) throws Exception {
		//		Page<Books> results = bookmapper.getBookList(pageable);
		Page<Books> results;
		if (!StringUtils.isEmpty(serchDataseve)) {
			results = service.searchUser(serchDataseve, serchDataseve, serchDataseve, pageable);
		} else {
			results = service.search("", "", "", "", pageable);
		}
		//				if (results.getPhoto() == null) {
		//					File fileImg = new File("src/main/resources/templates/picture/20200501_noimage.png");
		//					byte[] byteImg = Files.readAllBytes(fileImg.toPath());
		//					StringBuffer data = new StringBuffer();
		//					String base64 = new String(Base64.encodeBase64(byteImg, true), "ASCII");
		//					data.append("data:image/png;base64,");
		//					data.append(base64);
		//					model.addAttribute("base64AccountIcon", data.toString());
		//				} else {
		//		
		//					StringBuffer data = new StringBuffer();
		//		
		//					String base64 = new String(Base64.encodeBase64(result.getPhoto(), true), "ASCII");
		//		
		//					data.append("data:image/png;base64,");
		//					data.append(base64);
		//		
		//					model.addAttribute("base64AccountIcon", data.toString());
		//				}
		List<Books> result = results.getContent();
		model.addAttribute("pages", results);
		model.addAttribute("result", result);
		model.addAttribute("resultSize", result.size());
		return VIEW;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView serch(ModelAndView mav, Pageable pageable, @RequestParam("serchData") String serchData) {
		mav.setViewName(VIEW);
		serchDataseve = "";
		serchDataseve = serchData;
		Page<Books> results = service.searchUser(serchData, serchData, serchData, pageable);
		List<Books> result = results.getContent();
		mav.addObject("pages", results);
		mav.addObject("result", result);
		mav.addObject("resultSize", result.size());
		if (result == null || result.size() == 0) {
			mav.addObject("errorMsg", "検索結果がありませんでした。");
		} else {
			mav.addObject("errorMsg", "");
		}
		return mav;
	}
}
