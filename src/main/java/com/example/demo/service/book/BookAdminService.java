package com.example.demo.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.book.Books;
import com.example.demo.form.book.BookInfo;
import com.example.demo.repository.book.BookInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookAdminService {
	@Autowired
	private final BookInfoRepository repository;
	
//	@Autowired
//	private JdbcTemplate jdbc;

	
	public String insert(BookInfo book) {
		Books books = new Books();
		books.setBookid(book.getBookid());
		books.setTitle(book.getTitle());
		books.setAuther(book.getAuther());
		books.setPrice(book.getPrice());
		books.setTypeid(book.getTypeid());
		books.setPublisher(book.getPublisher());
		books.setYear(book.getYear());
		books.setEx(book.getEx());
		books.setOther(book.getOther());
		books.setInsertid(book.getInsertid());
		books.setInsertday(book.getInsertday());
		books.setUpdateid(book.getUpdateid());
		books.setUpdateday(book.getUpdateday());
		books.setDeleteid(book.getDeleteid());
		books.setDeleteday(book.getDeleteday());
		books.setDeleteflag(book.getDeleteflag());
		repository.save(books);
//		jdbc.update("INSERT INTO `bookdb`.`books`"
//				+ " (`bookid`, `title`, `auther`, `price`, `typeid`, `publisher`, `year`, `ex` ,`other`, `deleteflag`, `insertid`, `insertday`)"
//				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
//				book.getBookid(),
//				book.getTitle(),
//				book.getAuther(),
//				book.getPrice(),
//				book.getTypeid(),
//				book.getPublisher(),
//				book.getYear(),
//				book.getEx(),
//				book.getOther(),
//				book.getDeleteflag(),
//				book.getInsertid(),
//				book.getInsertday());
		return "sucsess";
	}

}
