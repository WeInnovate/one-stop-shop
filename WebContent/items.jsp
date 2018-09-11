<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Items</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<div class="container">
		<h1>All Items</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Item Name</th>
					<th scope="col">Item Description</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price/Unit</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${requestScope.items}">
					<tr>
						<th scope="row">${item.id}</th>
						<td>${item.name}</td>
						<td>${item.description}</td>
						<td>${item.quantity}</td>
						<td>${item.price}</td>
						<td>
						<a href="${pageContext.request.contextPath}/items/view/?id=${item.id}" type="button" class="btn btn-info">View</a> |
						<a href="${pageContext.request.contextPath}/items/delete/?id=${item.id}" type="button" class="btn btn-danger">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="container">
		<c:forEach var="item" items="${requestScope.items}">
<img src='${pageContext.request.contextPath}/assets/images/${item.id}.jpg' width="200px" height="300px" alt="Image" class="img-thumbnail">
		</c:forEach>
		</div>


</body>
</html>