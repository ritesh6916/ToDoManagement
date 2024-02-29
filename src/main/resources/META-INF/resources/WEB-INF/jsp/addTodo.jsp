<%@ include file="common/header.jspf"%>
<link
	href="webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.standalone.min.css"
	rel="stylesheet">
<title>Add-Todo Page</title>
</head>
<body>
	<%@ include file="common/navigation.jspf"%>
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

			<form:input type="hidden" path="id" />

			<form:input type="hidden" path="done" />

			<input class="btn btn-success" type="submit">
		</form:form>
	</div>
	<%@ include file="common/footer.jspf"%>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'yyyy-mm-dd',
			startDate : '-3d'
		});
	</script>
</body>
</html>