package com.example.demo.mapper.secondary;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.employees.Employees;

@Mapper
public interface ManagerMapper {
	
	Page<Employees> findAll(Pageable page);

	@Select("select u from Employees u where u.loginid like #{loginid} or u.auther like #{auther} or u.password like #{password}")
	List<Employees> findByLoginidLikeOrPasswordLike(String loginid, String password);

	@Select("select u from Employees u where u.loginid like :loginid or u.name like :name or u.authority like :authority")
	Page<Employees> findByLoginidLikeOrNameLikeOrAuthorityLike(@Param("loginid") String loginid,
			@Param("name") String name, @Param("authority") String authority, Pageable page);

}
