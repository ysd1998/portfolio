package com.example.demo.repository.primary;

import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.entity.primary.Clients;
@EnableJpaRepositories(
		  basePackages = {
		    "com.example.demo.repository.primary",
		    "com.example.demo.repository.secondary"
		  },
		  entityManagerFactoryRef = "primaryEntityManager",
		  transactionManagerRef = "primaryTransactionManager"
		)
public interface UserInfoRepositoryCustom{
	public List<Clients> search(String loginId,String Name,String Password);

}
