package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImp implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> getEmployees() {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee getEmployee(int id) {
		Session session = entityManager.unwrap(Session.class);
		Employee employee = session.get(Employee.class, id);
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("delete from Employee where id:=id", Employee.class);
		query.setParameter("id", id);
		query.executeUpdate();
	}



}
