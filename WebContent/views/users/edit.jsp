<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/Ass/users/update?id=${user.id}" method = "post" >
		<input value="${user.id}" name ="id" disabled="disabled" /><br>
		<input value="${user.password}" name ="password" placeholder="Password" /><br>
		<input value="${user.fullname}" name ="fullname" placeholder="Fullname" /><br>
		<input value="${user.email}" name ="email" placeholder="Email" /><br>
		<select class="form-select" name="admin">
					<option ${ !user.admin ? "selected" : "" } value="false">User</option>
					<option ${ user.admin ? "selected" : "" } value="true">Admin</option>
		</select>
		<br>
		<button type="submit">Submit</button>
	</form>
</body>
</html>