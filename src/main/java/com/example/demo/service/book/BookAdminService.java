package com.example.demo.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.book.Books;
import com.example.demo.repository.book.BookInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookAdminService {
	@Autowired
	private final BookInfoRepository repository;
	
	public String insert(String book_id,String title,String auther, String price, String type_id, String publisher, String year, String ex, String other, String insert_id, String insert_day, String Update_day, String delete_id, String delete_day) {
		Books book = new Books();
		book.setBook_id(book_id);
		book.setTitle(title);
		book.setAuther(auther);
		book.setPrice(price);
		book.setType_id(type_id);
		book.setPublisher(publisher);
		book.setYear(year);
		book.setEx(ex);
		book.setOther(other);
		book.setInsert_id(insert_id);
		book.setInsert_day(insert_day);
		book.setUpdate_day(Update_day);
		book.setDelete_id(delete_id);
		book.setDelete_day(delete_day);
		repository.save(book);
		return "sucsess";
	}

}
