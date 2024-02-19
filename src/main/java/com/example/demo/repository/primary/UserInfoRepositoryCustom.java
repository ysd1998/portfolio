package com.example.demo.repository.primary;

import java.util.List;

import com.example.demo.entity.primary.Clients;

public interface UserInfoRepositoryCustom{
	public List<Clients> search(String loginId,String Name,String Password);

}
