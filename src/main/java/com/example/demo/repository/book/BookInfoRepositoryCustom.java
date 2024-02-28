package com.example.demo.repository.book;

import java.util.List;

import com.example.demo.entity.book.Books;

public interface BookInfoRepositoryCustom{
	public List<Books> searchBooks(String loginId,String Name,String Password);

}
