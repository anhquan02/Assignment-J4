<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/Ass/users/store" method = "post" >
		<input  name ="id" placeholder="Id" /><br>
		<input  name ="password" placeholder="Password" /><br>
		<input  name ="fullname" placeholder="Fullname" /><br>
		<input  name ="email" placeholder="Email" /><br>
		<select class="form-select" name="admin">
					<option  value="false">User</option>
					<option  value="true">Admin</option>
		</select>
		<br>
		<button type="submit">Create</button>
	</form>
</body>
</html>