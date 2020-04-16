package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImp implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> getEmployees() {
		System.out.println("[EmployeeDAOJpaImp] getEmployees");
		Query query = entityManager.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee getEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		Employee dbEmployee = entityManager.merge(employee);
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteEmployee(int id) {
		Query query = entityManager.createQuery("delete from Employee where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
