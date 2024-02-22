package com.example.demo.repository.primary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.primary.Clients;

@EnableJpaRepositories(
		  basePackages = "com.example.demo.repository.primary",
		  entityManagerFactoryRef = "primaryEntityManager",
		  transactionManagerRef = "primaryTransactionManager"
		)
@Repository
public interface UserInfoRepository extends JpaRepository<Clients,String>{
	
	Optional<Clients> findByLoginidLikeOrNameLikeOrPasswordLike(String loginid,String name,String password);


}
