package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping(path = "/api")
public class EmployeeRESTController {

	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeRESTController(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@RequestMapping(path = "/employees", method = RequestMethod.GET)	
	public List<Employee> getEmployees() {
		return employeeDAO.getEmployees();
	}
	
}
