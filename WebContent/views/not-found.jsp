<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<jsp:include page="../partials/header.jsp">
		<jsp:param value="404" name="title"/>
	</jsp:include>
	<body>
		<div class="container">
			<h2>Error 404: Not Found</h2>
			<a href="<%= request.getContextPath() %>">Redirect to Home ?</a>
		</div>
	</body>
</html>