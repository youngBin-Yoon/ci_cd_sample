package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Policy;
import com.example.demo.service.PolicyService;

@RestController
@RequestMapping("/policy")
public class PolicyController {
	
	@Autowired
	PolicyService service;
	
	@PostMapping(path="/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addPolicy (@RequestBody Policy policy) {
		service.addPolicy(policy);
		return new ResponseEntity<> ("Created Successfully", HttpStatus.CREATED);
	}
	
	@GetMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Policy>> getAllPolicies () {
		return new ResponseEntity<> (service.getAllPolicies(), HttpStatus.OK);
	}

}
