package com.example.demo.authentication.secondary;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.repository.clients.UserInfoRepository;
import com.example.demo.repository.employees.EmpInfoRepository;

import lombok.RequiredArgsConstructor;

@Primary
@Component
@RequiredArgsConstructor
public class EmpDetailServiceImpl implements UserDetailsService {

	private final EmpInfoRepository emp;
	
	private final UserInfoRepository user;

	@Primary
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
		System.out.println(uri);
		if (uri.contains("/manager")) {
			var userInfo = emp.findById(username)
					.orElseThrow(() -> new UsernameNotFoundException(username));

			return User.withUsername(userInfo.getLoginid())
					.password(userInfo.getPassword())
					.authorities(userInfo.getAuthority())
					.build();
			
		} else {
			var userInfo = user.findById(username)
					.orElseThrow(() -> new UsernameNotFoundException(username));

			return User.withUsername(userInfo.getLoginid())
					.password(userInfo.getPassword())
					.authorities("User")
					.build();
			
		}
		
	}

}
