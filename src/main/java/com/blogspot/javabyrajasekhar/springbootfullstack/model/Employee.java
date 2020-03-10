package com.blogspot.javabyrajasekhar.springbootfullstack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank
	 @Column(name="first_name")
	private String firstName;
	@NotBlank
	 @Column(name="last_name")
	private String lastName;
	@Email
	 @Column(name="email", nullable=false, length=200)
	private String email;

	// Setters and getters

	
}
