package model.entity;

import java.io.Serializable;


public class EmployeesBean implements Serializable {

	private String employee_id;
	
	private String password;
	
	private String name;
	
	private int age;
	
	public EmployeesBean() {
	}
	public EmployeesBean(String employee_id, String password, String name, int age) {
		this.employee_id = employee_id;
		this.password = password;
		this.name = name;
		this.age = age;
	}
	
	public String getEmployee_id() {
		return employee_id;
	}
	
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
}
