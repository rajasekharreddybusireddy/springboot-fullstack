package com.blogspot.javabyrajasekhar.springbootfullstack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
	@NotBlank(message = "First Name must be supplied")
	@Size(min = 2,max = 30)
	private String firstName;
	@NotBlank(message = "Last Name must be supplied")
	@Size(min = 2,max = 30)
	private String lastName;
	@Email
	@NotEmpty(message = "please provide Email")
	private String email;
}
