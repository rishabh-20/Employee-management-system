package org.jsp.Employee_Management.controller;

import java.util.List;

import org.jsp.Employee_Management.dto.ResponseStructure;
import org.jsp.Employee_Management.exception.ResourceNotFoundException;
import org.jsp.Employee_Management.model.Employee;
import org.jsp.Employee_Management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@PostMapping
	public Employee createEmployee( @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id: " +id));
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee( @PathVariable long id,@RequestBody Employee employeeDetails) {
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee Does Not Exist with id: "+ id));
		
		employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());
        
        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
		
	}
	
	@DeleteMapping("{id}")
	 public ResponseEntity<ResponseStructure<Void>> deleteEmployee(@PathVariable long id) {
		 Employee employee=employeeRepository.findById(id)
				 .orElseThrow(()-> new ResourceNotFoundException("Emoloyee Does Not Exist With id: "+id));
		 		
		 		employeeRepository.delete(employee);
		 		
		 		ResponseStructure<Void> responseStructure = new ResponseStructure<>();
		        responseStructure.setMessage("Employee deleted successfully");
		        responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
		 		
		 		
		 		return new ResponseEntity<>(responseStructure,HttpStatus.NO_CONTENT);
		}
	 
	 	
	 }


