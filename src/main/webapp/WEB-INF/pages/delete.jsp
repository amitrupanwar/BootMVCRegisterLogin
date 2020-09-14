<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>

	<form method="POST" action="delete">
		Enter Credentials <br> 
		User name : <input name="user" type="text"><br> 
		Password : <input name="pass" type="password"><br> 
		<button type="submit">Login</button><br> 
		
		Not a user, <a href="register">Register Here</a><br>
		Want to Delete a user, <a href="delete">Delete Here</a><br>
	</form>
</body>
</html>