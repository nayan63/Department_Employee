package com.mindtree.employee.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.employee.VO.Department;
import com.mindtree.employee.entity.Employee;
import com.mindtree.employee.exception.DetailsNotFoundException;
import com.mindtree.employee.repository.EmployeeRepository;
import com.mindtree.employee.service.EmployeeService;

@Component
public class EmployeeImplement implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	RestTemplate restTemp;
	
	@Override
	public Employee add(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public List<Employee> list() {
		return empRepo.findAll();
	}

	@Override
	public Employee updateSalary(long id, double salary) throws DetailsNotFoundException {
		Optional<Employee> employeeOP = empRepo.findById(id);
		if(employeeOP.isPresent())
		{
			Employee emp = employeeOP.get();
			emp.setSalary(salary);
			return empRepo.save(emp);
		}
		throw new DetailsNotFoundException("Employee Not Found With id: "+id);
	}

	@Override
	public Employee assignOrUpdateDept(long empId, long deptId) throws DetailsNotFoundException {
		
		Department department = restTemp.getForObject("http://DEPARTMENT-SERVICE/department/"+deptId, Department.class);
		
		Optional<Employee>  empOp = empRepo.findById(empId);
		if((department !=null) || (empOp.isPresent()))
		{
			Employee employee = empOp.get();
			employee.setDept_id(deptId);
			empRepo.save(employee);
			return employee;
		}
		
		throw new DetailsNotFoundException("Employee Id or Department Id is not valid");
	}

}
