package com.example.demo.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.book.Types;

@Repository
public interface TypeInfoRepository extends JpaRepository<Types,String>{

}
