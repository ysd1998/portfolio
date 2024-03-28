package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.form.primary.UrlConfig;

/**
 * 
 * @author ys-sj
 *
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity 
@Order(2)
public class SecurityBeanDefine {
	
	private final String USERNAME_PARAMETER = "loginId";
	

	/**
	 * 
	 * @param http
	 * @return
	 * @throws Exception
	 */
//	
//	@Autowired
//	private EmpLoginService empLoginService;
//	
//	@Autowired
//	private LoginService loginService;
//	
	
//	@Bean
//	public PasswordEncoder userpasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User
//                .withUsername("user")
//                .password("123456")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//	
	@Bean
	SecurityFilterChain secondfilterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests(
				authorize -> authorize.requestMatchers(UrlConfig.NO_AUTHENTICATION).permitAll()
				.anyRequest().authenticated())
		.formLogin(
					login -> login.loginPage(UrlConfig.login)
					.usernameParameter(USERNAME_PARAMETER)
					.defaultSuccessUrl(UrlConfig.menu));
		return http.build();
	}
	
	
	
	

//	.authorizeHttpRequests(
//			authorize -> authorize.requestMatchers("").permitAll()
//			.anyRequest().authenticated())
	
//	@Bean
//	@Order(2)
//	SecurityFilterChain secondfilterChain(HttpSecurity http) throws Exception {
//		http.formLogin(login -> login.loginPage("/manager/login").usernameParameter("loginId").defaultSuccessUrl("/manager/menu"));
//		return http.build();
//	}


}
