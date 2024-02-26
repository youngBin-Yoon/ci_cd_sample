package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Exception.NoEmpFoundException;
import com.example.demo.model.Emp;

public interface EmpService {
	
	List<Emp> getAllEmps();
	void addEmp(Emp emp);
	Emp getEmp(Long id);
	void deleteEmp(Long id);
	void updateEmp(Long id, Emp emp);
}
