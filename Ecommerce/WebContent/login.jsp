<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="stylesheet.css"/>
<title>Login</title>
</head>
<body>
<form name="loginForm" action="login" method="post">
<table>
<tr>
<th>User Name</th>
<th>Password</th>
</tr>
<tr>

<td><input type="text" name="userName"></td>
<td><input type="password" name="password"></td>
</tr>
</table>
<input type="submit" name="submit" value="Login">
</form>
 <form name="register" action="register.jsp" method="post">

     <input type="submit" name="submit" value="New User? Register Here">
     
  </form>
  
  <form name="home" action="index.jsp" method="post">

     <input type="submit" name="submit" value="Return to Homepage">
     
  </form>
  
</body>
</html>