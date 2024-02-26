package com.example.demo.entity.policy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
@Table(name="POLICY")
public class PolicyEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TAB_HR_SEQ")
	@SequenceGenerator(name="TAB_HR_SEQ", sequenceName="TAB_HR_SEQ", allocationSize=1)
	@Column( name = "ID")
	private Long id;
	
	@Column( name = "PNAME")	
	private String policyName;
	
	@Column( name = "PDATE")
	private Date policyDate;
	
	@Column( name = "PDESC")
	private String policyDescription;

}
