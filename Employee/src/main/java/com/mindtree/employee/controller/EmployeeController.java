package com.mindtree.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.employee.entity.Employee;
import com.mindtree.employee.exception.DetailsNotFoundException;
import com.mindtree.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService empServe;
	
	@PostMapping
	public Employee add(@RequestBody Employee emp)
	{
		return empServe.add(emp);
	}
	
	@GetMapping
	public List<Employee> list()
	{
		return empServe.list();
	}
	
	@PutMapping("/update/{empId}/{salary}")
	public Employee updateSalary(@PathVariable long empId,@PathVariable double salary) throws DetailsNotFoundException
	{
		return empServe.updateSalary(empId, salary);
	}
	
	@PutMapping("/{empId}/{deptId}")
	public Employee assignOrUpdateDept(@PathVariable long empId,@PathVariable long deptId) throws DetailsNotFoundException
	{
		return empServe.assignOrUpdateDept(empId, deptId);
	}
}