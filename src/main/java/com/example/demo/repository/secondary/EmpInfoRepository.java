package com.example.demo.repository.secondary;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.secondary.Employees;

//@EnableJpaRepositories(
//		  basePackages = "com.example.demo.repository.secondary",
//		  entityManagerFactoryRef = "secondaryEntityManager",
//		  transactionManagerRef = "secondaryTransactionManager"
//		)
@Repository
public interface EmpInfoRepository extends JpaRepository<Employees,String>{
//	Optional<Employees> findByLoginidLikeOrNameLikeOrPasswordLike(String loginid,String name,String password);
	
	@Query("select u from Employees u where u.loginid like :loginid or u.auther like :auther or u.password like :password")
	List<Employees> findByLoginidLikeOrPasswordLike(String loginid,String password);

}
