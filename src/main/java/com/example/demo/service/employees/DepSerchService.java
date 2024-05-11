package com.example.demo.service.employees;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.employees.Departments;
import com.example.demo.repository.employees.DepInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepSerchService {

	@Autowired
	private final DepInfoRepository repository;

	public List<Departments> serchData(String id) {
		List<Departments> type = repository.findByDidLike(id);
		return type;
	}

	//	public List<Types> serchName(String id) {
	//		List<Types> type;
	//		if ("".equals(id) ) {
	//			type = null;
	//		} else {
	//			type = repository.findByNameLike("%"+id+"%");
	//		}
	//		
	//		return type;
	//	}

	public Departments serchNames(String id) {
		Departments type = new Departments();
		Optional<Departments> types = repository.findByNameLike(id);
		if (types.isPresent()) {
			type = types.get();
		} else {
			type = null;
		}
		return type;
	}

	public Departments serchId(String id) throws NoSuchElementException {
		return repository.findById(id).get();
	}

}
