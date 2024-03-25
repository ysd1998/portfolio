package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.form.primary.UrlConfig;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity 
@RequiredArgsConstructor
@Order(1)
public class SecondSecurityBeanDefine {
	
	 private final UserDetailsService userDetailsService;
	
//	@Bean
//	public PasswordEncoder emppasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public InMemoryUserDetailsManager empDetailsService() {
//        UserDetails admin = User
//                .withUsername("admin")
//                .password("123456")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(admin);
//    }
    
	@Bean
	SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception {
		http.securityMatcher("/manager/**") 
		.authorizeHttpRequests(
				authorize -> authorize.requestMatchers(UrlConfig.MN_NO_AUTHENTICATION).permitAll()
				.anyRequest().authenticated())
		.formLogin(login -> login.loginPage("/manager/login").usernameParameter("loginId").defaultSuccessUrl("/manager/menu"));
		return http.build();
	}
	
	

}
