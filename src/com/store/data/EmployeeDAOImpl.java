package com.store.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.store.data.ConnectionFactory;
import com.store.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void addEmployee(Employee employee) throws Exception {
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("insert employees values(?,?,?,?,?)");
			ps.setString(1, employee.getEmployeeId());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getEmployeeName());
			ps.setString(4, employee.getCity());
			ps.setString(5, employee.getPhoneNumber());
					
			ps.executeUpdate();
			
		}
		finally {
			close(null, ps, con);
		}
		
	}

	@Override
	public Employee getEmployee(String employeeId) throws Exception {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee employee = null;
		
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("select * from employees where employee_id =?");
			ps.setString(1, employeeId);
			rs = ps.executeQuery();
			if(rs.next()) {
				employee = new Employee();
				employee.setEmployeeId(rs.getString(1));
				employee.setPassword(rs.getString(2));
				employee.setEmployeeName(rs.getString(3));
				employee.setCity(rs.getString(4));
				employee.setPhoneNumber(rs.getString(5));
				
			}
			else {
				throw new Exception("Invalid employee id");
			}
		}
		finally {
			close(rs, ps, con);
		}
		
		return employee;
		
	}

	private void close(ResultSet rs, PreparedStatement ps, Connection con) {
		
		try {
			if(rs != null) {
				rs.close();
			}
			if( ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	}


