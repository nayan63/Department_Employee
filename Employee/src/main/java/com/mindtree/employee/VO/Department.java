package com.mindtree.employee.VO;

public class Department {

	private long id;
	private String name;
	private int totalEmp;
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
	public int getTotalEmp() {
		return totalEmp;
	}
	public void setTotalEmp(int totalEmp) {
		this.totalEmp = totalEmp;
	}
	public Department(long id, String name, int totalEmp) {
		super();
		this.id = id;
		this.name = name;
		this.totalEmp = totalEmp;
	}
	public Department() {
		
	}
	
	
}