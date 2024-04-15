package com.example.demo.service.secondary;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.secondary.Employees;
import com.example.demo.form.secondary.LoginForm;
import com.example.demo.repository.secondary.EmpInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpSerchService {
	
	@Autowired
	private final EmpInfoRepository repository;
//	@Autowired
//	private final EmpInfoRepositoryCustom repositoryCustom;
	
	public Page<Employees> searchEmp(String loginId,String Name,String authority,Pageable page) {
		Page<Employees> result;
		if ("".equals(loginId) && "".equals(Name) && "".equals(authority)) {
			result = repository.findAll(page);
		} else {
			result = repository.findByLoginidLikeOrNameLikeOrAuthorityLike("%"+loginId +"%", "%"+Name+"%","%"+ authority +"%" , page);
		}
		return result;
	}
	
	public Employees searchId(String loginId) {
		Employees emp = new Employees();
		Optional<Employees> emps = repository.findById(loginId);
		if (emps.isPresent()) {
			emp = emps.get();
		}
		return emp;
	}
	
	public String insert(LoginForm emp) {
		Employees employees = new Employees();
		Optional<Employees> emps = repository.findById(emp.getLoginid());
		if (emps.isPresent()) {
			employees = emps.get();
		}
		employees.setAuthority(emp.getAuthority());
		repository.save(employees);
		return "auth change sucsess";
	}

}
