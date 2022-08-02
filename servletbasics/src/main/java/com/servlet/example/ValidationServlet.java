package com.servlet.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ValidationServlet extends GenericServlet{
	static Map<String, String> users = new HashMap<>();
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		System.out.println("\t\t User Validation");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String logout = req.getParameter("logout");
		
		
		users.put("user1", "user@1");
		users.put("user2", "user@2");
		users.put("user3", "user@3");
		users.put("user4", "user@4");
		
		if(users.containsKey(username)) {
			if(check(username, password) == true) {
				pw.println("<h2> Successfully logged in!!!</h2> ");
				 
			}else {
				pw.println("<h2>... Please enter the valid details ...</h2>");
			}
			
		}else if(logout != null) {
			pw.println("<h3> Logout Successful!</h3>");
			
		}  
		
		else {
			pw.println("<h3> Username does not exist! </h3>");
		}
		
		
		
		
	}
	
	private boolean check(String username, String password) {
		return users.get(username).equals(password);
	}

}
	
