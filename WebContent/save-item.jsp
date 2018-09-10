<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Item</title>
</head>
<body>
<h1>Insert item Details</h1>
<form action="${pageContext.request.contextPath}/process-save-item.jsp" method="post">
<input type="text" name="id" value="${item.id}" hidden /><br />
<input type="text" name="name" value="${item.name}" placeholder="Enter item name" /><br />
<input type="text" name="description" value="${item.description}" placeholder="Enter item description" /><br />
<input type="number" name="quantity" value="${item.quantity}" placeholder="Enter item quantity" /><br />
<input type="number" name="price" value="${item.price}" placeholder="Enter item price" /><br />
<input type="submit" value="Save/Update Item" />
</form>
</body>
</html>