package com.store.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.store.data.EmployeeDAOImpl;
import com.store.model.Employee;



/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeDAOImpl employeeUtil = null;
	
	
	
	@Override
	public void init() throws ServletException {
		
		super.init();
		employeeUtil = new EmployeeDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
try {
			
			String command = request.getParameter("command");
			
			switch(command) {
			
			case "ADD":
				addEmployee(request,response);
				break;
				
			case "EMPLOYEE":
				getEmployee(request,response);
				break;
				
			case "SIGN-OUT":
				signOut(request,response);
				break;
			
			}
 		}
		catch (Exception e){
			throw new ServletException(e);
		}
		
	}

	private void signOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		session.invalidate();
		String message = "Sign out Successfully";
		RequestDispatcher rd = request.getRequestDispatcher("Sign-in.jsp");
		request.setAttribute("msg",message);
		rd.forward(request,response);
		
	}

	
	private void getEmployee(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String employeeId = request.getParameter("employeeId");
		String password = request.getParameter("password");
		
		String resource = "Sign-in.jsp";
		String message = null;
		
try {
			
	        Employee employee = employeeUtil.getEmployee(employeeId);
			if(employee.getPassword().equals(password)) {
				resource = "ProductController";
				HttpSession session = request.getSession();
				session.setAttribute("employee",employee);
			}
			else {
				message = "Wrong Password : Try again"; 
			}
			
		}
		catch (Exception e) {
			message = e.getMessage();
			
		}
        
        RequestDispatcher rd = request.getRequestDispatcher(resource);
        request.setAttribute("msg", message);
        rd.forward(request,response);
		
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String employeeId = request.getParameter("employeeId");
		String password = request.getParameter("password");
		String employeeName = request.getParameter("employeeName");
		String city = request.getParameter("city");
		String phoneNumber = request.getParameter("phoneNumber");
		
		String resource = "registration.jsp";
		String message = null;
		
		Employee employee = new Employee(employeeId,password,employeeName,city,phoneNumber);
		
		try {
			
			employeeUtil.addEmployee(employee);
			message = "Registered Successfully : Please Sign-in";
			resource = "Sign-in.jsp";
			
		}
		catch (Exception e) {
			message = e.getMessage();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(resource);
		request.setAttribute("msg", message);
		rd.forward(request, response);
		
	}

}