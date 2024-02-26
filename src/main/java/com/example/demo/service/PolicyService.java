package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Policy;

public interface PolicyService {
	void addPolicy(Policy policy);
	List<Policy> getAllPolicies();
}
