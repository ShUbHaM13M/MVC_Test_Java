package com.seytonic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", urlPatterns = "/Controller")
public class Controller extends HttpServlet{

	private static final long serialVersionUID = -4378521096787399302L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String rootURL = req.getContextPath();
		
		switch (req.getParameter("page")) {
		case "about":
			resp.sendRedirect(rootURL + "/views/about.jsp");
			break;
		case "login":
			resp.sendRedirect(rootURL + "/views/login.jsp");
			break;
		case "signup":
			resp.sendRedirect(rootURL+ "/views/signup.jsp");
			break;
		default:
			resp.sendRedirect(rootURL + "/views/not-found.jsp");
		}
	}
	
	
}
