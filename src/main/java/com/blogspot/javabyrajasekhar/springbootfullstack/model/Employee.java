package com.blogspot.javabyrajasekhar.springbootfullstack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Employee {

	private Long id;

	// @Column(name="first_name")
	private String firstName;

	// @Column(name="last_name")
	private String lastName;

	// @Column(name="email", nullable=false, length=200)
	private String email;

	// Setters and getters

	
}
