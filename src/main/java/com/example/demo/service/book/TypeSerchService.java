package com.example.demo.service.book;

import java.util.List;

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
	
	public List<Types> serchData(String id) {
		List<Types> type = typerepo.findByTypeidLike(id);
		return type;
	}
	
	public List<Types> serchName(String id) {
		List<Types> type;
		if ("".equals(id) ) {
			type = null;
		} else {
			type = typerepo.findByNameLike("%"+id+"%");
		}
		
		return type;
	}
	
	public Types serchId(String id) {
		return typerepo.findById(id).get();
	}

}
