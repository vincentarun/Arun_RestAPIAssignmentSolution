package com.greatlearning.employeemanagement.service;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.model.Employee;
import com.greatlearning.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchEmployeeList() {

		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {

		Employee employeeDB = employeeRepository.findById(id).get();
		if (Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getLastName())) {
			employeeDB.setFirstName(employee.getFirstName());
			employeeDB.setLastName(employee.getLastName());
			employeeDB.setEmail(employee.getEmail());
		}

		return employeeRepository.save(employeeDB);
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		employeeRepository.deleteById(id);

	}

	@Override
	public Employee fetchEmployeeById(Integer id) {

		return employeeRepository.findById(id).get();
	}

	@Override
	public List<Employee> fetchEmployeeListByFirstName(String firstName) {
		
		List<Employee> employees = employeeRepository.findByFirstNameContainsAllIgnoreCase(firstName);
		if (employees.size() > 0)
			return employees;
		else
			throw new RuntimeException("No employee data found!!!");
	}


	@Override
	public List<Employee> fetchEmployeeListSorted(String order) {

		if (order.equals("asc")) {

			return (List<Employee>) employeeRepository.findAll(Sort.by("firstName").ascending());

		}
		if (order.equals("desc")) {

			return (List<Employee>) employeeRepository.findAll(Sort.by("firstName").descending());
		}
		return null;
	}

}
