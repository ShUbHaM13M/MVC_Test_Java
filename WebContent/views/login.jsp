<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<jsp:include page="../partials/header.jsp">
		<jsp:param value="Login" name="title"/>
	</jsp:include>
	<body>
		<%@ include file="../partials/nav.jsp" %>
		<div class="container">
		
			<form action="<%=request.getContextPath() %>/auth/Login" method="post">
				<h2>Login</h2>
				<div class="field">
					<Label for="email">Email: </Label>
					<input type="email" placeholder="Email" name="email"  id="email" required/>
 				</div>
 				<div class="field">
					<Label for="password">Password: </Label>
					<input type="password" placeholder="Password" name="password"  id="password"/>
 				</div>
 				<button type="submit">Login</button>
			</form>
			
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