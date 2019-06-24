package com.store.data;

import com.store.model.Employee;

public interface EmployeeDAO {
	
	public void addEmployee(Employee employee)throws Exception;
	public Employee getEmployee(String employeeId) throws Exception;

}
