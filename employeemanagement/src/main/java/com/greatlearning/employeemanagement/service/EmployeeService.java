package com.greatlearning.employeemanagement.service;

import java.util.List;

import com.greatlearning.employeemanagement.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	

	List<Employee> fetchEmployeeList();

	
	Employee updateEmployee(Employee employee, Integer id);

	
	void deleteEmployeeById(Integer id);

	
	Employee fetchEmployeeById(Integer id);

	
	List<Employee> fetchEmployeeListByFirstName(String firstName);

	
	List<Employee> fetchEmployeeListSorted(String order);
}
