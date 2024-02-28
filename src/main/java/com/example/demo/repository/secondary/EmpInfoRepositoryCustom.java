package com.example.demo.repository.secondary;

import java.util.List;

import com.example.demo.entity.secondary.Employees;

public interface EmpInfoRepositoryCustom{
	public List<Employees> searchEmp(String loginId,String Name,String Password);

}
