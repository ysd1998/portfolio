package com.example.demo.service.clients;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.clients.Clients;
import com.example.demo.repository.clients.UserInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

	private final UserInfoRepository repository;

	public Optional<Clients> searchUserById(String loginId) {
		return repository.findById(loginId);
	}

}
