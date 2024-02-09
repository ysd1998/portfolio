package com.example.demo.repository.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.secondary.EmpInfo;

@Repository
public interface EmpInfoRepository extends JpaRepository<EmpInfo,String>{

}
