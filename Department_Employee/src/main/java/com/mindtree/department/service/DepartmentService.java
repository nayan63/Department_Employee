package com.mindtree.department.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.department.entity.Department;
import com.mindtree.department.exception.EmployeeNotFoundException;

@Service
public interface DepartmentService {

	Department add(Department department);
	List<Department> list() throws EmployeeNotFoundException;
	Department update(long id,String name) throws EmployeeNotFoundException;
	Department delete(long id) throws EmployeeNotFoundException;
	Department findById(long id) throws EmployeeNotFoundException;
}
