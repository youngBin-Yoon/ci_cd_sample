package com.example.demo.model;

import java.util.Date;

import lombok.Setter;
import lombok.ToString;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @Setter @NoArgsConstructor @ToString
public class Policy {
	private Long id;
	private String policyName;
	private Date policyDate;
	private String policyDescription;
}
