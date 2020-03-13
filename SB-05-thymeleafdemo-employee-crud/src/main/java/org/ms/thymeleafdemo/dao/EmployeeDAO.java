package org.ms.thymeleafdemo.dao;

import java.util.List;

import org.ms.thymeleafdemo.entity.Employee;



public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findEmployeeById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
