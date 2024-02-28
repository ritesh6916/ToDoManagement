<%@ include file="common/header.jspf"%>
<title>All-Todoes</title>
</head>
<body>
	<%@ include file="common/navigation.jspf"%>
	<div class="container">
		<h2>Your to does are:</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>Is Done ?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todoes}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a href="delete-todo?id=${todo.id}"
							class="btn btn-warning">Delete</a></td>
						<td><a href="update-todo?id=${todo.id}"
							class="btn btn-success">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a class="btn btn-success" href="/add-todo">Add-Todo</a>
	</div>
	<%@ include file="common/footer.jspf"%>

</body>
</html>