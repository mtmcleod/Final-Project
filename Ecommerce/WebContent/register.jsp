<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="stylesheet.css"/>
<title>Registration</title>

</head>
<body><div id ="header">
<h2>Create your account</h2></div>
 <p> <% //invalid login msg, not sure how to do yet %></p>

<form name="registerForm" action="register" method="post">
<table>
<tr>
<th>User Name</th>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Password</th>
</tr>
<tr>

<td><input type="text" name="userName" value=""></td>

<td><input type="text" name="firstName" value=""></td>

<td><input type="text" name="lastName" value=""></td>

<td><input type="text" name="email" value=""></td>

<td><input type="password" name="password" value=""></td>
</tr>
</table>
<input type="submit" name="submit" value="Register Account">
</form>

  <form name="login" action="login.jsp" method="post">

     <input type="submit" name="submit" value="Already have an account? Sign in here">
     
  </form>

  <form name="home" action="index.jsp" method="post">

     <input type="submit" name="submit" value="Return to Homepage">
     
  </form>
</body>
<div id="footer">
<p> Copyright MMXVIII, all rights reserved </p>
</div>
</html>
