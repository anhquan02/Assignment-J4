<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<form action="/Ass/users/create">
		<button formaction="/Ass/users/create">Create</button>
	</form>
	<table border="1" style="width: 100%">
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.id}</td>
				<td>${user.password }</td>
				<td>${user.fullname}</td>
				<td>${user.email }</td>
				<td>${user.admin ? "Admin": "User"  }</td>
				<td><a href="/Ass/users/edit?id=${ user.id }">Update</a></td>
				<td><a href="/Ass/users/delete?id=${ user.id }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>