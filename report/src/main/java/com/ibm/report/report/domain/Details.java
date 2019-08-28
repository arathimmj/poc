package com.ibm.report.report.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Details {
	
	@Id
	private String firstName;
	private String lastName;
	private String city;
	private String phoneNo;

}