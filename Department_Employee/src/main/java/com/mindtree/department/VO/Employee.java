package com.mindtree.department.VO;

public class Employee {

	private long id;
	private String name;
	private double salary;
	private long dept_id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public long getDept_id() {
		return dept_id;
	}
	public void setDept_id(long dept_id) {
		this.dept_id = dept_id;
	}
	public Employee(long id, String name, double salary, long dept_id) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept_id = dept_id;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
