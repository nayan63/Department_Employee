package com.mindtree.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.department.entity.Department;
import com.mindtree.department.exception.EmployeeNotFoundException;
import com.mindtree.department.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService deptServe;
	
	@PostMapping
	public Department add(@RequestBody Department department)
	{
		return deptServe.add(department);
	}
	
	@GetMapping
	public List<Department> list() throws EmployeeNotFoundException
	{
		return deptServe.list();
	}
	
	@PutMapping("/{id}/{name}")
	public Department update(@PathVariable long id,@PathVariable String name) throws EmployeeNotFoundException
	{
		return deptServe.update(id, name);
	}
	
	@DeleteMapping("/{id}")
	public Department delete(@PathVariable long id) throws EmployeeNotFoundException
	{
		return deptServe.delete(id);
	}
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable long id) throws EmployeeNotFoundException
	{
		return deptServe.findById(id);
	}
}
