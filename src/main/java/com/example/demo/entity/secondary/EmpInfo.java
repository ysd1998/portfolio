package com.example.demo.entity.secondary;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class EmpInfo {
	
	@Id
	@Column(name = "employee_id")
	private String loginId;
	
	private String password;

}
