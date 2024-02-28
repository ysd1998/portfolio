package com.example.demo.repository.book;

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

}
