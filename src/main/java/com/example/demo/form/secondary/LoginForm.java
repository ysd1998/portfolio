package com.example.demo.form.secondary;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class LoginForm {
	
	private String loginId;
	
	private String name;
	
	private String password;
	
	private String authority;
	
	private String did;
	
	

}
