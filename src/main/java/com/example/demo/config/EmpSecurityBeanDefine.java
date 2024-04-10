package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.form.primary.UrlConfig;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity 
@RequiredArgsConstructor
@Order(1)
public class EmpSecurityBeanDefine {
    
	
	
	@Bean
	SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception {
		http.securityMatcher("/manager/**") 
		.authorizeHttpRequests(
				authorize -> authorize.requestMatchers(UrlConfig.MN_NO_AUTHENTICATION).permitAll()
				.requestMatchers(UrlConfig.MN_NO_AUTHENTICATION).permitAll()
				.requestMatchers("/manager/admin").hasAuthority("管理者")
				.anyRequest().authenticated())
		.logout((logout) -> logout
		        .logoutSuccessUrl("/manager/logout")
		        .permitAll()
		    )
		.formLogin(login -> login.loginPage("/manager/login").usernameParameter("loginid").defaultSuccessUrl("/manager/menu"));
//		.logout((logout) -> logout.logoutSuccessUrl("/manager/login"))
		return http.build();
	}
	
	

}
