package com.example.demo.repository.policy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.policy.PolicyEntity;

public interface PolicyRepository extends JpaRepository<PolicyEntity, Long> {

}
