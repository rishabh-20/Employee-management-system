package org.jsp.Employee_Management;

import org.jsp.Employee_Management.model.Employee;
import org.jsp.Employee_Management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
	

	@Autowired
	private EmployeeRepository employeeRepository;
  
	
	public void run(String...args)throws Exception {
//		Employee employee = new Employee();
//		employee.setFirstName("Ramesh");
//		employee.setLastName("Fadatare");
//		employee.setEmailId("ramesh@gmail.com");
//		employeeRepository.save(employee);
//
//		Employee employee1 = new Employee();
//		employee1.setFirstName("John");
//		employee1.setLastName("Cena");
//		employee1.setEmailId("cena@gmail.com");
//		employeeRepository.save(employee1);
	}

}
