<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css"
	rel="stylesheet">
<title>Add-Todo Page</title>
</head>
<body>
	<div class="container">
		<h2>Enter ToDo Details</h2>
		<form method="post">
			Description: <input type="text" name="description" required="required"/> <input
				class="btn btn-success" type="submit">
		</form>
	</div>
	<script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="webjars/jquery/3.7.1/jquery.min.js" type="text/javascript"></script>
</body>
</html>