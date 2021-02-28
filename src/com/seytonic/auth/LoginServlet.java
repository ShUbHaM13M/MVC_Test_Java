package com.seytonic.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seytonic.utils.User;

@WebServlet(name = "Login", urlPatterns = {"/auth/Login", "/Login"})
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 7677961031850985817L;
	private static Connection connection = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
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

		User user = this.loginUser(email, password);
		PrintWriter out= resp.getWriter();
		
		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			this.closeConnection();
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/login.jsp");
			out.println("<font class=message color=red>No user found with given email id, please register first.</font>");
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
	
	private User loginUser(String email, String pass) {
		
		User user = null;
		
		if (connection != null) {
			try {
				ps = connection.prepareStatement("select * from Dashboard where email=? and password=?");
				
				ps.setString(1, email);
				ps.setString(2, pass);
				
				rs = ps.executeQuery();
				
				if (rs.next()) {
					user = new User(rs.getString("username"),rs.getString("email"));
				} else {
					System.out.println("Not Found");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (ps != null)
					try {
						ps.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		} 
		return user;
		
	}
	
}
