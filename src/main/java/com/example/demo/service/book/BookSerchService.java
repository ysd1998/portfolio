package com.example.demo.service.book;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.book.Books;
import com.example.demo.repository.book.BookInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookSerchService {

	@Autowired
	private final BookInfoRepository repository;

	public Page<Books> search(String id, String Name, String publisher, Pageable pageable) {
		Page<Books> result;
		if ("".equals(id) && "".equals(Name) && "".equals(publisher)) {
			result = repository.findAll(pageable);
		} else {
			result = repository.findByTitleLikeOrAutherLikeOrPublisherLike("%" + id + "%", "%" + Name + "%",
					"%" + publisher + "%", pageable);
		}
		return result;
	}

	public Books serchId(String id) throws NoSuchElementException {
		Books book = new Books();
		Optional<Books> books = repository.findById(id);
		if (books.isPresent()) {
			book = books.get();
		}
		return book;
	}

	public Optional<Books> check(String id) {
		Optional<Books> book = repository.findById(id);
		return book;
	}

}
