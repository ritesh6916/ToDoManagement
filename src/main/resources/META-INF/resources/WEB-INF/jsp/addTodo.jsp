<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css"
	rel="stylesheet">
<link href="webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.standalone.min.css"
	rel="stylesheet">
<title>Add-Todo Page</title>
</head>
<body>
	<div class="container">
		<h2>Enter ToDo Details</h2>
		<form:form method="post" modelAttribute="todo">

			<fieldset class="mb-3">
				<form:label path="description">Description</form:label>
				<form:input type="text" name="description" required="required"
					path="description" />
				<form:errors path="description" cssClass="text-warning"></form:errors>
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" required="required" path="targetDate" />
				<form:errors path="targetDate" cssClass="text-warning"></form:errors>
			</fieldset>

			<input class="btn btn-success" type="submit">
		</form:form>
	</div>
	<script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="webjars/jquery/3.7.1/jquery.min.js" type="text/javascript"></script>
	<script src="webjars/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd',
	    startDate: '-3d'
	});
	</script>
</body>
</html>