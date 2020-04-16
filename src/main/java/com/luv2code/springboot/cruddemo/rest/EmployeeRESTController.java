package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(path = "/employees/{id}", method = RequestMethod.GET)	
	public Employee getEmployees(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}
	
	@RequestMapping(path = "/employees/", method = RequestMethod.POST)	
	public Employee saveEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.saveEmployee(employee);
		return employee;
	}
	
	@RequestMapping(path = "/employees/", method = RequestMethod.PUT)	
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return employee;
	}
	
	@RequestMapping(path = "/employees/{id}", method = RequestMethod.DELETE)	
	public String deleteEmployee(@PathVariable int id) {
		Employee employee = employeeService.getEmployee(id);
		if (employee == null)
			throw new RuntimeException("Employee with id " + id + " not found.");
		
		employeeService.deleteEmployee(id);
		return "Deleted Employee With ID - " + id;
	}
	
	
}
