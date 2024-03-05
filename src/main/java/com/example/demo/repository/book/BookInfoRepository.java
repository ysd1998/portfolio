package com.example.demo.repository.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.book.Books;

//@EnableJpaRepositories(
//		  basePackages = "com.example.demo.repository.secondary",
//		  entityManagerFactoryRef = "secondaryEntityManager",
//		  transactionManagerRef = "secondaryTransactionManager"
//		)
@Repository
public interface BookInfoRepository extends JpaRepository<Books,String>{
	
	Page<Books> findAll(Pageable pageable);
	
	@Query("select u from Books u where u.title like ?1 or u.autherlike ?2")
	Page<Books> findByTitleOrAuther(String title, String auther,Pageable pageable);

}
