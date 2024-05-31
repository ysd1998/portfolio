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

/**
 * 
 * @author ys-sj
 *
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
@Order(2)
public class UserSecurityBeanDefine {

	private final String USERNAME_PARAMETER = "loginid";

	/**
	 * 
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@Bean
	SecurityFilterChain secondfilterChain(HttpSecurity http) throws Exception {
		http.securityMatcher("/**")
				.authorizeHttpRequests(
						authorize -> authorize.requestMatchers(UrlConfig.NO_AUTHENTICATION).permitAll()
								.requestMatchers(UrlConfig.USER_AUTHENTICATION).hasAuthority("User")
								.requestMatchers("/manager/**").hasAnyAuthority("web販売担当", "管理者")
								.anyRequest().authenticated())
				.formLogin(
						login -> login.loginPage(UrlConfig.login)
								.usernameParameter(USERNAME_PARAMETER)
								.defaultSuccessUrl(UrlConfig.menu));
		return http.build();
	}

}
