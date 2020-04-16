package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	@Qualifier(value = "employeeDAOJpaImp")
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDAO.getEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		return employeeDAO.getEmployee(id);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		employeeDAO.deleteEmployee(id);
	}

}
