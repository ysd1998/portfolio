package com.example.demo.entity.employees;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "departments")
@Data
public class Departments {

	@Id
	@Column(name = "department_id")
	@Getter
	@Setter
	private String did;

	@Column(name = "name")
	@Getter
	@Setter
	private String name;

}
