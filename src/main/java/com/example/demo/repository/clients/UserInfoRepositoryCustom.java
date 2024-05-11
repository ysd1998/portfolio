package com.example.demo.repository.clients;

import java.util.List;

import com.example.demo.entity.clients.Clients;

public interface UserInfoRepositoryCustom {
	public List<Clients> search(String loginId, String Name, String Password);

}
