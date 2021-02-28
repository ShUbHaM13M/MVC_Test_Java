<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<jsp:include page="../partials/header.jsp">
		<jsp:param value="Signup" name="title"/>
	</jsp:include>
	<body>
		<%@ include file="../partials/nav.jsp" %>
		<div class="container">
		
			<form action="<%=request.getContextPath() %>/auth/Signup" method="post">
				<h2>Sign up</h2>
				<div class="field">
					<Label for="username">Username: </Label>
					<input type="text" placeholder="Username" name="username"  id="username" required/>
 				</div>
 				<div class="field">
					<Label for="email">Email: </Label>
					<input type="email" placeholder="Email" name="email"  id="email" required/>
 				</div>
 				<div class="field">
					<Label for="password">Password: </Label>
					<input type="password" placeholder="Password" name="password"  id="password" required/>
 				</div>
 				<button type="submit">Sign Up</button>
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