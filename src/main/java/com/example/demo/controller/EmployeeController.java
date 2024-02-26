package com.example.demo.controller;

import com.example.demo.Exception.NoEmpFoundException;
import com.example.demo.model.Emp;
import com.example.demo.service.EmpService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmployeeController {
	
	@Autowired
	EmpService empService;	
	
	@ApiOperation(value = "Get All employees",notes = "Make a get call", response = Emp.class)
	@GetMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Emp>> getAllEmps () {				
		return new ResponseEntity<>(empService.getAllEmps(), HttpStatus.OK); 
	}
	
	@PostMapping(path="/", consumes = MediaType.APPLICATION_JSON_VALUE,
						   produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addEmp(@RequestBody Emp emp) {
		empService.addEmp(emp);
		return new ResponseEntity<>("Created Successfully.", HttpStatus.CREATED); 
	}
	
	@ApiOperation(value = "Finds Emp by ID", notes = "Provide an ID to retreive an emp", response = Emp.class)
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Emp> getEmpByEmpNo(@ApiParam(value = "ID value for the employee toy want to retreive", required = true) 
											@PathVariable("id") 
											Long id) throws NoEmpFoundException {
		return new ResponseEntity<> (empService.getEmp(id) ,HttpStatus.OK);
	}
	
	@PutMapping(path="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateEmpByEmpNo(@PathVariable("id") Long id, @RequestBody Emp emp) {
		empService.updateEmp(id, emp);
		return new ResponseEntity<> ("Updated Sucessfully." ,HttpStatus.OK);
	}
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<String> deleteEmpByEmpNo(@PathVariable("id") Long id) {
		empService.deleteEmp(id);
		return new ResponseEntity<> ("Deleted Successfully." ,HttpStatus.OK);
	}
	
	
	
}
