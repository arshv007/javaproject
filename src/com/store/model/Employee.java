package com.store.model;

public class Employee {
	
	private String employeeId;
	private String password;
	private String employeeName;
	private String city;
	private String phoneNumber;
	
	public Employee() {
		
	}
	
	public Employee(String employeeId, String password, String employeeName, String city, String phoneNumber) {
		super();
		this.employeeId = employeeId;
		this.password = password;
		this.employeeName = employeeName;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", password=" + password + ", employeeName=" + employeeName
				+ ", city=" + city + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
	
	
	

}
