package com.example.demo.repository.employees;

import java.util.List;

import com.example.demo.entity.employees.Employees;

public interface EmpInfoRepositoryCustom {
	public List<Employees> searchEmp(String loginId, String Name, String Password);

}
