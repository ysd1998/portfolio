package com.example.demo.service.book;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

	public Types serchNames(String id) {
		Types type = new Types();
		Optional<Types> types = typerepo.findByNameLike(id);
		if (types.isPresent()) {
			type = types.get();
		}
		return type;
	}

	public Types serchId(String id) throws NoSuchElementException {
		return typerepo.findById(id).get();
	}

	public Optional<Types> check(String id) throws NoSuchElementException {
		Optional<Types> types = typerepo.findById(id);
		return types;
	}

}
