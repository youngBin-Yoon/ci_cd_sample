package com.example.demo.service;

import com.example.demo.entity.policy.PolicyEntity;
import com.example.demo.model.Policy;
import com.example.demo.repository.policy.PolicyRepository;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {
	
	@Autowired
	PolicyRepository repo;
	
	MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	
	public void addPolicy(Policy policy) {
		PolicyEntity entity = new PolicyEntity();
		entity.setPolicyDate(policy.getPolicyDate());
		entity.setPolicyDescription(policy.getPolicyDescription());
		entity.setPolicyName(policy.getPolicyName());
		repo.save(entity);
	}
	
//	@Transactional
	public List<Policy> getAllPolicies() {
		List<PolicyEntity> entities = repo.findAll();
		List<Policy> policies = mapperFactory.getMapperFacade().mapAsList(entities, Policy.class);
		return policies;
	}
}
