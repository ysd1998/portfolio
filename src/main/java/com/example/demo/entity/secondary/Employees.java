package com.example.demo.entity.secondary;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Data
public class Employees {

	@Id
	@Column(name = "employee_id")
	@Getter
	@Setter
	private String loginid;

	@Column(name = "name")
	@Getter
	@Setter
	private String name;

	@Column(name = "department_id")
	@Getter
	@Setter
	private String did;

	@Column(name = "authority")
	@Getter
	@Setter
	private String authority;

	@Column(name = "password")
	@Getter
	@Setter
	private String password;

}
