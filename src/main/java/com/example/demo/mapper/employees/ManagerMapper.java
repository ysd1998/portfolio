package com.example.demo.mapper.employees;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.book.Books;

@Mapper
//@Qualifier
//@Transactional(transactionManager = "employeesTransactionManager")
public interface ManagerMapper { //extends EmpInfoRepository {
	@Select("SELECT * FROM employees")
	Page<Books> getEmpList(Pageable pageable);

}
