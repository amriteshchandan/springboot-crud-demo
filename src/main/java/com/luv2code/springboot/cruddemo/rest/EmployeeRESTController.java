package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping(path = "/api")
public class EmployeeRESTController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRESTController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@RequestMapping(path = "/employees", method = RequestMethod.GET)	
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
}
