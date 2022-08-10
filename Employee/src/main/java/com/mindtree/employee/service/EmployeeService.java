package com.mindtree.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.employee.entity.Employee;
import com.mindtree.employee.exception.DetailsNotFoundException;

@Service
public interface EmployeeService {

	Employee add(Employee  emp);
	List<Employee> list();
	Employee updateSalary(long id,double salary) throws DetailsNotFoundException;
	Employee assignOrUpdateDept(long empId,long deptId) throws DetailsNotFoundException;
}
