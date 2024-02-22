package com.example.demo.repository.secondary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.secondary.Employees;

@EnableJpaRepositories(
		  basePackages = "com.example.demo.repository.secondary",
		  entityManagerFactoryRef = "secondaryEntityManager",
		  transactionManagerRef = "secondaryTransactionManager"
		)
@Repository
public interface EmpInfoRepository extends JpaRepository<Employees,String>{
	Optional<Employees> findByLoginidLikeOrNameLikeOrPasswordLike(String loginid,String name,String password);

}
