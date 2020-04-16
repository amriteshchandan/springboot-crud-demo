package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();
	
	public Employee getEmployee(int id);
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployee(int id);
	
}
