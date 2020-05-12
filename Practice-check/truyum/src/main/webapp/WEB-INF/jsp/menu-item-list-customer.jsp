<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*" %>
<%@ page import="com.cognizant.truyumm.model.*" %>
<!DOCTYPE html>
<html>
	<head>
		<title>truYum</title>
		<link rel="icon" type="image/ico" href="./images/truyum-logo-dark.png" />
		<link rel="stylesheet" type="text/css" href="./style/style.css">
	</head>
	<body>
		<header>
			<span class="header-title">truYum</span>
			<img class="header-logo" src="./images/truyum-logo-light.png" alt="truYum Logo"></img>
			<nav>
				<a class="nav-link" href="./menu-item-list-customer">Menu</a>
				<a class="nav-link" href="./cart">Cart</a>
			</nav>
		</header>
		<article>
			<h2 class="article-heading">Menu Items</h2>
			<% List<Cart> l=(List<Cart>)request.getAttribute("menulist");%>
			<table>
				<tr>
					<th class="col-left">Name</th>
					<th>Free Delivery</th>
					<th class="col-right">Price</th>
					<th>Category</th>
					<th>Action</th>
				</tr><% for(Cart m:l){ %>
				<tr>
					<td class="col-left"><%=m.getName()%></td>
					<td><%=m.getFreedelivery()%></td>
					<td class="col-right"><%=m.getPrice()%></td>
					<td><%=m.getCategory() %></td>
					<td>
						<a class="action-link" href="./menu-item-list-customer-notification?id=<%=m.getId()%>">Add to Cart</a>
					</td>
				</tr>
				<%} %>
				<!-- <tr>
					<td class="col-left">Burger</td>
					<td>No</td>
					<td class="col-right">Rs. 129.00</td>
					<td>Main Course</td>
					<td>
						<a class="action-link" href="./menu-item-list-customer-notification.html">Add to Cart</a>
					</td>
				</tr>
				<tr>
					<td class="col-left">Pizza</td>
					<td>No</td>
					<td class="col-right">Rs. 149.00</td>
					<td>Main Course</td>
					<td>
						<a class="action-link" href="./menu-item-list-customer-notification.html">Add to Cart</a>
					</td>
				</tr>-->
			</table>
		</article>
		<footer>
			<p>Copyright &copy; 2019</p>
		</footer>
	</body>
</html>