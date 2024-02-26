package com.example.demo;

import com.example.demo.controller.EmployeeController;
import com.example.demo.model.Emp;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class MySpringbootApplicationTest {
	
	@Autowired
	EmployeeController controller = new EmployeeController();
	
	
	
	@Test
	@Order(1)
	public void addEmpTest() {
		Emp emp = new Emp();
		emp.setCommission(25);
		emp.setDeptNo(20);
		emp.setEmpName("testname");
		emp.setEmpNo(1124);
		emp.setHireDate(new Date());
		emp.setJob("adsaf");
		emp.setManager(7854);
		emp.setSalary(789465l);
		emp.setId(12l);
		ResponseEntity<String> res =  controller.addEmp(emp);
		assertEquals(res.getBody(), "Created Successfully.");
		assertEquals(res.getStatusCode().value(), 201);
	}
	
	@Test
	@Order(2)
	public void getAllEmpsTest() {
		ResponseEntity<List<Emp>> res = controller.getAllEmps();
		System.out.println();
	}
}
