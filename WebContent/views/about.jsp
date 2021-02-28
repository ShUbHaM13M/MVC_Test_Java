<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<jsp:include page="../partials/header.jsp">
		<jsp:param value="About" name="title"/>
	</jsp:include>
	<body>
		<%@ include file="../partials/nav.jsp" %>
		<div class="container">
			<h2>About: </h2>
			<p class="text-large">Testing the MVC design pattern in Java Servlet</p>
		</div>
	</body>
</html>