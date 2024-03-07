package com.example.demo.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.book.Types;
import com.example.demo.repository.book.TypeInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TypeSerchService {
	@Autowired
	private final TypeInfoRepository typerepo;
	
	public Types serchId(String id) {
		return typerepo.findById(id).get();
	}

}
