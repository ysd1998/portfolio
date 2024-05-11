package com.example.demo.service.employees;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.employees.Employees;
import com.example.demo.repository.employees.EmpInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpLoginService {

	private final EmpInfoRepository repository;

	public Optional<Employees> searchUserById(String loginId) {
		return repository.findById(loginId);
	}

	public boolean login(String loginId, String password) {
		return repository.findByLoginidLikeOrPasswordLike(loginId, password).size() == 1;
	}

}
