<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.seytonic.utils.User" %>
<nav>
	<% User user = (User) session.getAttribute("user"); %>
	<div class="logo">Java</div>
	<ul class="links">
		<li><a href="<%=request.getContextPath()%>/">Home</a></li>
		<li><a href="<%=request.getContextPath()%>/Controller?page=about">About</a></li>
		<% if (user == null ) { %>
			<li><a href="<%=request.getContextPath()%>/Controller?page=login">Login</a></li>
			<li><a href="<%=request.getContextPath()%>/Controller?page=signup">Signup</a></li>
		<%} else { %>
			<li><a href="<%=request.getContextPath()%>/auth/Logout">Logout</a></li>
		<% } %>
	</ul>
</nav>