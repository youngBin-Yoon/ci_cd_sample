package com.example.demo.repository.emp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.emp.EmpEntity;

public interface EmpRepository extends JpaRepository<EmpEntity, Long> {

}
