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
				<a class="nav-link" href="./menu-item-list-admin">Menu</a>
			</nav>
		</header>
		<article>
			<h2 class="article-heading">Menu Items</h2>
			<% List<Menu> l=(List<Menu>)request.getAttribute("menulist");%>
			
			<table>
				<tr>
					<th class="col-left">Name</th>
					<th class="col-right">Price</th>
					<th>Active</th>
					<th>Date of Launch</th>
					<th>Category</th>
					<th>Free Delivery</th>
					<th>Action</th>
				</tr>
				<% for(Menu m:l){ %>
				<tr>
					<td class="col-left"><%=m.getName()%></td>
					<td class="col-right"><%=m.getPrice()%></td>
					<td><%=m.getActive()%></td>
                    <td><%=m.getDateoflaunch() %></td>
                    <td><%=m.getCategory() %></td>
                    <td><%=m.getFreedelivery()%></td>
					<td>
						<a class="action-link" href="./edit-menu-item?id=<%=m.getId()%>">Edit</a>
					</td>
				</tr>
				<%}%>
				<!-- <tr>
					<td class="col-left">Burger</td>
					<td class="col-right">Rs. 129.00</td>
					<td>Yes</td>
					<td>23/12/2017</td>
					<td>Main Course</td>
					<td>No</td>
					<td>
						<a class="action-link" href="./edit-menu-item.html">Edit</a>
					</td>
				</tr>
				<tr>
					<td class="col-left">Pizza</td>
					<td class="col-right">Rs. 149.00</td>
					<td>Yes</td>
					<td>21/08/2017</td>
					<td>Main Course</td>
					<td>No</td>
					<td>
						<a class="action-link" href="./edit-menu-item.html">Edit</a>
					</td>
				</tr>
				<tr>
					<td class="col-left">French Fries</td>
					<td class="col-right">Rs. 57.00</td>
					<td>No</td>
					<td>02/07/2017</td>
					<td>Starters</td>
					<td>Yes</td>
					<td>
						<a class="action-link" href="./edit-menu-item.html">Edit</a>
					</td>
				</tr>
				<tr>
					<td class="col-left">Chocolate Brownie</td>
					<td class="col-right">Rs. 32.00</td>
					<td>Yes</td>
					<td>02/11/2022</td>
					<td>Desert</td>
					<td>Yes</td>
					<td>
						<a class="action-link" href="./edit-menu-item.html">Edit</a>
					</td>
				</tr>-->
			</table>
		</article>
		<footer>
			<p>Copyright &copy; 2019</p>
		</footer>
	</body>
</html>