package com.example.demo.authentication.secondary;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.repository.secondary.EmpInfoRepository;

import lombok.RequiredArgsConstructor;

@Primary
@Component
@RequiredArgsConstructor
public class EmpDetailServiceImpl implements UserDetailsService {
	
	private final EmpInfoRepository repository;
	
	@Primary
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var userInfo = repository.findById(username)
				.orElseThrow(()->new UsernameNotFoundException(username));
		
		return User.withUsername(userInfo.getLoginid())
				.password(userInfo.getPassword())
				.authorities(userInfo.getAuthority())
				.build();
	}

}
