<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css"
	rel="stylesheet">
<title>Insert title here</title>

</head>
<body>
	<div class="container">
		<h2>Your to does are:</h2>
		<table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>Description</th>
					<th>Is Done ?</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todoes}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a class="btn btn-success" href="/add-todo">Add-Todo</a>

		<script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"
			type="text/javascript"></script>
		<script src="webjars/jquery/3.7.1/jquery.min.js"
			type="text/javascript"></script>
	</div>
</body>
</html>