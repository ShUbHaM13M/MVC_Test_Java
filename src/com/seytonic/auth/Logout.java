package com.seytonic.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Logout", urlPatterns = {"/auth/Logout", "/Logout"})
public class Logout extends HttpServlet{
	
	private static final long serialVersionUID = 7285422474199329768L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		session.setAttribute("user", null);
		out.println("<font class=message color=green>Logged out sucessfully</font>");
		rd.include(req, resp);
	}
	
}
