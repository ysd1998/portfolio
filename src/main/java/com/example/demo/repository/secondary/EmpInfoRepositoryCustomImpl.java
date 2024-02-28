package com.example.demo.repository.secondary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.secondary.Employees;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Component
public class EmpInfoRepositoryCustomImpl implements EmpInfoRepositoryCustom  {
	

//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondary");
//	
//	EntityManager manager = emf.createEntityManager();
	@Autowired
	@PersistenceContext(unitName="secondary")
	EntityManager manager;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employees> searchEmp(String loginid,String Name,String Password) {
//		manager.getTransaction();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT e From Employees e WHERE ");
		boolean andFlg = false;
		boolean goodsIdFlg = false;
		if (!"".equals(loginid) && loginid != null) {
			sql.append(" e.loginid LIKE :loginid ");
			goodsIdFlg = true;
			andFlg = true;
		}
		boolean goodsNameFlg = false;
		if (!"".equals(Name) && Name != null) {
			if (andFlg) sql.append(" or ");
			sql.append("e.name LIKE :Name ");
			goodsNameFlg = true;
			andFlg = true;
		}
		boolean priceFromFlg = false;
		if (!"".equals(Password) && Password != null) {
			if (andFlg) sql.append(" or ");
			sql.append("e.password LIKE :Password ");
			priceFromFlg = true;
			andFlg = true;
		}
		
		Query query = manager.createQuery(sql.toString());
		if (goodsIdFlg) query.setParameter("loginid", "%" + loginid + "%");
		if (goodsNameFlg) query.setParameter("Name", "%" + Name + "%");
		if (priceFromFlg) query.setParameter("Password", "%" + Password + "%");
		List<Employees> result = query.getResultList();
//		manager.close();
		return result;
	}

}
