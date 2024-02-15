package com.example.demo.service.primary;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.primary.UserInfo;
import com.example.demo.repository.primary.UserInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SerchService {
	
	private final UserInfoRepository repository;
	
	public Optional<UserInfo> searchData(String loginId){
		return repository.findByLoginidLikeOrNameLikeOrPasswordLike("%"+loginId+"%","%"+loginId+"%","%"+loginId+"%");
	}

}
