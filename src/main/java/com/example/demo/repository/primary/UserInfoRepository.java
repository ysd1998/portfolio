package com.example.demo.repository.primary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.primary.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,String>{
	
	List<UserInfo> findByLoginidOrNameLike(String loginid,String name);

}
