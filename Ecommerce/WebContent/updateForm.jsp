<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%@ page import="model.Product" %>
    
<% 
Product product = (Product) request.getAttribute("product");
String sku = request.getParameter("sku");


%>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link type="text/css" rel="stylesheet" href="stylesheet.css"/>
<title>Order Form</title>
</head>
<body>

<h2>Order Drinks!</h2>

<form name=updateForm action=updateProduct method=post >
<h2>You Have Selected <%= product.getName() %>! We have <%= product.getQuantity() %> in stock!</h2><br>
<h2> How many would you like to order?</h2>


  
   <input type=hidden name=sku value=<%= product.getSku() %> readonly="readonly" />
   

   <input type=hidden name=productType value=<%= product.getProductType() %> readonly="readonly" />
   
 
   <input type=hidden name=name value=<%= product.getName() %> readonly="readonly" />
 
   <input type=hidden name=cost value=<%= product.getCost() %> readonly="readonly" />
   

   <input type=hidden name=price value=<%= product.getPrice() %> readonly="readonly" />
   
 
   <input type=hidden name=quantity value=<%= product.getQuantity() %> readonly="readonly" />
   
    <label>
      Amount:
   </label>
   <input type=text name=amount value="1" />
   <br />
   
   <input type=submit name=submit value="Add to Cart" />

</form>

</body>
</html>