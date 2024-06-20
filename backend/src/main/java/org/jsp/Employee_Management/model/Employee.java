package org.jsp.Employee_Management.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "first_name",nullable = false)
	private String firstName;
	@Column(name="last_name",nullable = false)
	private String lastName;
	@Column(name="email_id",unique = true)
	private String emailId;

}
