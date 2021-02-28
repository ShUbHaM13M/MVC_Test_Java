package com.seytonic.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SignUp", urlPatterns = {"/auth/Signup", "/Signup"})
public class SignupServlet extends HttpServlet{

	private static final long serialVersionUID = -993114029230811649L;
	private static Connection connection = null;
	private static PreparedStatement ps = null;
	private String DB_URL = "jdbc:mysql://freedb.tech:3306/freedbtech_mvctest";
	private String USER = "freedbtech_seytonic";
	private String PASS = "seytonic13";
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		if (connection == null)
			this.getConnection();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String username = req.getParameter("username");
		
		Boolean isRegistered = this.signUpUser(username, email, password);
		
		if (isRegistered) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/login.jsp");
			PrintWriter out= resp.getWriter();
			out.println("<font class=message color=green>Registration successful, please login below.</font>");
			this.closeConnection();
			rd.include(req, resp);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/signup.jsp");
			PrintWriter out= resp.getWriter();
			out.println("<font class=message color=red>Error creating a new Account, Retry in a while</font>");
			this.closeConnection();
			rd.include(req, resp);
		}
		
	}

	@Override
	public void destroy() {
		super.destroy();
		this.closeConnection();
	}
	
	
	private void closeConnection () {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("Connection closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void getConnection () {
		try {
			connection = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private Boolean signUpUser(String username, String email, String pass) {
		
		Boolean isRegistered = false;
		
		if (connection != null) {
			try {
				ps = connection.prepareStatement("insert into Dashboard(username, email, password) values(?, ?, ?)");
				ps.setString(1,  username);
				ps.setString(2, email);
				ps.setString(3, pass);
				
				ps.execute();
				isRegistered = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (ps != null)
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			
		}
		
		return isRegistered;
		
	}
	
}
