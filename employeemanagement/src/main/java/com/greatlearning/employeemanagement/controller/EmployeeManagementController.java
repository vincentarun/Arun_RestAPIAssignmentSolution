package com.greatlearning.employeemanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greatlearning.employeemanagement.model.Employee;
import com.greatlearning.employeemanagement.service.EmployeeService;

@Controller
@RequestMapping("/api")
public class EmployeeManagementController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employees")
	@ResponseBody
	public Employee roleAddSave(@Validated @RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);

	}

	@GetMapping("/employees")
	@ResponseBody
	public List<Employee> userRead() {

		return employeeService.fetchEmployeeList();

	}

	@PutMapping("/employees/{id}")
	@ResponseBody
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Integer id) {
		return employeeService.updateEmployee(employee, id);

	}

	@GetMapping("/employees/{id}")
	@ResponseBody
	public Employee getEmployeeById(@PathVariable("id") Integer id) {

		return employeeService.fetchEmployeeById(id);

	}

	@DeleteMapping("/employees/{id}")
	@ResponseBody

	public String deleteEmployeeById(@PathVariable("id") Integer id) {

		employeeService.deleteEmployeeById(id);
		return "Deleted employee id - " + id;

	}

	@GetMapping("/employees/search/{firstName}")
	@ResponseBody
	public List<Employee> searchByFirstName(@PathVariable("firstName") String firstName) {

		return employeeService.fetchEmployeeListByFirstName(firstName);

	}

	@GetMapping("/employees/sort")
	@ResponseBody
	public List<Employee> sortByFirstName(@RequestParam String order) {

		return employeeService.fetchEmployeeListSorted(order);

	}

}
