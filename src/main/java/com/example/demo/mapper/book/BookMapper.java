package com.example.demo.mapper.book;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.book.Books;

//@Mapper
@Transactional(transactionManager = "bookTransactionManager")
@Qualifier("bookEntityManager")
//@Qualifier
public interface BookMapper { //extends BookInfoRepository {
	@Select("SELECT * FROM books")
	Page<Books> getBookList(Pageable pageable);

}
