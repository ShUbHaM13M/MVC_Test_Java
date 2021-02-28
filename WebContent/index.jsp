<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.seytonic.utils.User" %>
<!DOCTYPE html>
<html>
	<jsp:include page="./partials/header.jsp">
		<jsp:param value="Home" name="title"/>
	</jsp:include>
	<body>
		<%@ include file="./partials/nav.jsp" %>
		<div class="container">
			<% if(user == null) { %>
			
				<h2>Home</h2>
				<p>Dummy account for test: </p>
				<hr>
				<p class="text-large">
					Email:  valerie@mail.com 
					<br>
					Password:  valerie
				</p>
				
			<% } else { %>
			
				<h2> Welcome <%= user.getName() %> </h2>
				<p class="large-text"><%= user.getEmail() %></p>
				
			<% } %>
		</div>
	</body>
	
	<script>
		
		const message = document.querySelector('.message')
		if (message) {
			setTimeout(() => {
				message.style.display = "none";
			}, 3000)
		}
	
	</script>
	
</html>