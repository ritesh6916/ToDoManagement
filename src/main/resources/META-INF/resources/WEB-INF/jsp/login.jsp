<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css"
	rel="stylesheet">
<title>Login</title>
</head>

<body>
	<div class="container">
		<h2>Please Do Login</h2>
		<div>
			<form action="/todoes" method="get">
				User Name: <input type="text" name="userid">
				Password: <input type="password" name="password"> 
				<button type="submit">Login</button>
			</form>
		</div>
		<script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"
			type="text/javascript"></script>
		<script src="webjars/jquery/3.7.1/jquery.min.js"
			type="text/javascript"></script>
	</div>
</body>
</html>