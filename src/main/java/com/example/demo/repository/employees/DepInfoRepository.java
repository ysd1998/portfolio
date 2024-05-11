package com.example.demo.repository.employees;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.employees.Departments;

//@EnableJpaRepositories(
//		  basePackages = "com.example.demo.repository.secondary",
//		  entityManagerFactoryRef = "secondaryEntityManager",
//		  transactionManagerRef = "secondaryTransactionManager"
//		)
@Repository
public interface DepInfoRepository extends JpaRepository<Departments, String> {
	//	Optional<Employees> findByLoginidLikeOrNameLikeOrPasswordLike(String loginid,String name,String password);

	Page<Departments> findAll(Pageable page);

	@Query("select u from Departments u where u.did like :loginid or u.name like :name")
	List<Departments> findByDidLikeOrNameLike(@Param("loginid") String loginid, @Param("name") String password);

	@Query("select u from Departments u where u.did like :loginid")
	List<Departments> findByDidLike(@Param("loginid") String id);

	@Query("select u from Departments u where u.name like :name")
	Optional<Departments> findByNameLike(@Param("name") String id);
}
