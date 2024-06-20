package org.jsp.Employee_Management.repository;

import org.jsp.Employee_Management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	//all crud database method
	
}
