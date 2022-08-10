package com.mindtree.department.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindtree.department.entity.Department;
import com.mindtree.department.exception.EmployeeNotFoundException;
import com.mindtree.department.repository.DepartmentRepository;
import com.mindtree.department.service.DepartmentService;

@Component
public class DepartmentImplement implements DepartmentService{

	@Autowired
	DepartmentRepository deptRepo;
	
	@Override
	public Department add(Department department) {
		return deptRepo.save(department);
	}

	@Override
	public List<Department> list() throws EmployeeNotFoundException {
		List<Department> list = deptRepo.findAll();
		if(list.size()>0)
		{
			return list;
		}
		throw new EmployeeNotFoundException("No Record Present");
	}

	@Override
	public Department update(long id, String name) throws EmployeeNotFoundException {
		Optional<Department> departmentOp = deptRepo.findById(id);
		if(departmentOp.isPresent())
		{
			Department department = departmentOp.get();
			department.setName(name);
			
			return deptRepo.save(department);
		}
		
		throw new EmployeeNotFoundException("No Department Found With Id: "+id);
	}

	@Override
	public Department delete(long id) throws EmployeeNotFoundException {
		Optional<Department> deptOp = deptRepo.findById(id);
		if(deptOp.isPresent())
		{
			Department dept = deptOp.get();
			deptRepo.deleteById(id);
			return dept;
		}
		throw new EmployeeNotFoundException("No Department Found With Id: "+id);
	}

	@Override
	public Department findById(long id) throws EmployeeNotFoundException {
		Optional<Department> deptOp = deptRepo.findById(id);
		if(deptOp.isPresent())
		{
			Department dept = deptOp.get();
			return dept;
		}
		throw new EmployeeNotFoundException("No Department Found With Id: "+id);
	}

}
