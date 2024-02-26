package com.example.demo.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "Details about an employee")
@Getter @Setter @NoArgsConstructor @ToString
public class Emp {
	@ApiModelProperty(notes = "the unique id for an employee")
	private Long id;
	private Integer empNo;
	private String empName;
	private	String job;
	private Integer manager;
	private Date hireDate;
	private Long salary;
	private Integer commission;
	private Integer deptNo;
	
}
