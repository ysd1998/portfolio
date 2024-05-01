package com.example.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.form.primary.UrlConfig;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
@Order(1)
public class EmpSecurityBeanDefine {

	/** パスワードエンコーダー */
	private final PasswordEncoder passwordEncoder;

	/** ユーザー情報取得Service */
	private final UserDetailsService userDetailsService;

	/** メッセージ取得 */
	private final MessageSource messageSource;

	@Bean
	SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception {
		http.securityMatcher("/manager/**")
				.authorizeHttpRequests(
						authorize -> authorize.requestMatchers(UrlConfig.MN_NO_AUTHENTICATION).permitAll()
								.requestMatchers(UrlConfig.MN_NO_AUTHENTICATION).permitAll()
								.requestMatchers("/manager/admin").hasAuthority("管理者")
								.anyRequest().authenticated())
				.logout((logout) -> logout
						.logoutUrl("/manager/logout"))
				.formLogin(login -> login.loginPage("/manager/login").usernameParameter("loginid")
						.defaultSuccessUrl("/manager/menu"));
		//		.logout((logout) -> logout.logoutSuccessUrl("/manager/login"))
		return http.build();
	}

	@Bean
	AuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		provider.setMessageSource(messageSource);

		return provider;
	}

}
