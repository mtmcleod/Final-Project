<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%
    String table = (String) request.getAttribute("table");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link type="text/css" rel="stylesheet" href="stylesheet.css"/>
<title>Product Listing</title>
</head>
<body>
<h2> You are now logged in</h2>
<h2>Product Listing</h2>

<%= table %>
<br />



</body>
</html>