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
<form action="process-save-item.jsp" method="post">
<input type="text" name="name" placeholder="Enter item name" /><br />
<input type="text" name="description" placeholder="Enter item description" /><br />
<input type="number" name="quantity" placeholder="Enter item quantity" /><br />
<input type="number" name="price" placeholder="Enter item price" /><br />
<input type="submit" value="Save Item" />
</form>
</body>
</html>