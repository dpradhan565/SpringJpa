<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="com.cognizant.truyumm.model.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
table,tr,td{
border:2px solid black;
}
</style>
</head>
<body>
<h1>Cart</h1>

<table>
<tr>
<td>Name</td>
<td>Free Delivery</td>
<td>Price</td>
<td>Category</td>
<td>Action</td>

</tr>

<% List<Cart> l=(List<Cart>)request.getAttribute("cartlist");%>

<% for(Cart m:l){ %>
<tr>
<td><%=m.getName()%></td>
<td><%=m.getFreedelivery()%></td>
<td><%=m.getPrice()%></td>
<td><%=m.getCategory() %></td>
<td><a href="/deletefromcart?id=<%=m.getId()%>">Delete</a></td>
</tr>
<%} %>

</table>

</body>
</html>