package com.example.demo.repository.primary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.primary.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,String>{
	
	Optional<UserInfo> findByLoginidLikeOrNameLikeOrPasswordLike(String loginid,String name,String password);

}
