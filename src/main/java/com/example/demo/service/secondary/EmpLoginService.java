package com.example.demo.service.secondary;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.secondary.EmpInfo;
import com.example.demo.repository.secondary.EmpInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpLoginService {
	
	private final EmpInfoRepository repository;
	
	public Optional<EmpInfo> searchUserById(String loginId){
		return repository.findById(loginId);
	}

}
