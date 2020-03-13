package org.ms.thymeleafdemo.service;

import java.util.List;

import org.ms.thymeleafdemo.entity.Employee;



public interface EmployeeService {
public List<Employee> findAll();
	
	public Employee findEmployeeById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	

}
