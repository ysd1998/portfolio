package com.example.demo.repository.primary.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.primary.Clients;
import com.example.demo.repository.primary.UserInfoRepositoryCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Component
public class UserInfoRepositoryCustomImpl implements UserInfoRepositoryCustom  {
	
	@Autowired
	EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Clients> search(String loginId,String Name,String Password) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT c From Clients c WHERE ");
		boolean andFlg = false;
		boolean goodsIdFlg = false;
		if (!"".equals(loginId) && loginId != null) {
			sql.append(" c.loginid LIKE :loginId ");
			goodsIdFlg = true;
			andFlg = true;
		}
		boolean goodsNameFlg = false;
		if (!"".equals(Name) && Name != null) {
			if (andFlg) sql.append(" or ");
			sql.append("c.name LIKE :Name ");
			goodsNameFlg = true;
			andFlg = true;
		}
		boolean priceFromFlg = false;
		if (!"".equals(Password) && Password != null) {
			if (andFlg) sql.append(" or ");
			sql.append("c.password LIKE :Password ");
			priceFromFlg = true;
			andFlg = true;
		}
		
		Query query = manager.createQuery(sql.toString());
		if (goodsIdFlg) query.setParameter("loginId", "%" + loginId + "%");
		if (goodsNameFlg) query.setParameter("Name", "%" + Name + "%");
		if (priceFromFlg) query.setParameter("Password", "%" + Password + "%");
		return query.getResultList();
	}

}
