package com.example.demo.repository.book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.book.Types;

@Repository
public interface TypeInfoRepository extends JpaRepository<Types, String> {

	@Query("select u from Types u where u.typeid like :typeid")
	List<Types> findByTypeidLike(@Param("typeid") String id);

	//	@Query("select u from Types u where u.name like :name")
	//	Optional<Types> findByName(@Param("name")String id);

	@Query("select u from Types u where u.name like :name")
	Optional<Types> findByNameLike(@Param("name") String id);

}
