<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cognizant.truyumm.model.*" %>
<!DOCTYPE html>
<html>
	<head>
		<title>truYum</title>
		<link rel="icon" type="image/ico" href="./images/truyum-logo-dark.png" />
		<link rel="stylesheet" type="text/css" href="./style/style.css">
		<script src="./js/script.js"></script>
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
			<h2 class="article-heading">Edit Menu Item</h2>
			<% Menu m=(Menu)request.getAttribute("menu"); %>
			<form name="editMenuItemForm" onsubmit="return validateForm();" action="edit-menu-item-status?id=<%=m.getId()%>">
				<input type="text" name="id" style="visibility:hidden" value="<%=m.getId()%>">
				<table class="form-table">
					<tr>
						<td colspan="4">
							<label class="form-item" for="field-title">Title</label>
							<input class="form-input" type="text" name="title" id="field-title" value="<%=m.getName()%>"></input>
						</td>
					</tr>
					<tr>
						<td>
							<label class="form-item" for="field-price">Price (Rs.)</label>
							<input class="form-input form-input-right" type="text" name="price" id="field-price" value="<%=m.getPrice()%>"></input>
						</td>
						<th>
							<label class="form-item" for="field-yes">Active</label><br>
							<% if(m.getActive().equals("Yes")){ %>
							<input type="radio" name="inStock" id="field-yes" value="Yes" checked><label class="form-item" for="field-yes">Yes</label></input>
							<input type="radio" name="inStock" id="field-no" value="No"><label class="form-item" for="field-no">No</label></input>
						<%}else{ %>
						
						<input type="radio" name="inStock" id="field-yes" value="Yes"><label class="form-item" for="field-yes">Yes</label></input>
							<input type="radio" name="inStock" id="field-no" value="No" checked><label class="form-item" for="field-no">No</label></input>
						<%}%>
						</th>
						<td>
							<label class="form-item" for="field-dateOfLaunch">Date of Launch</label>
							<input class="form-input" type="text" name="dateOfLaunch" id="field-dateOfLaunch" placeholder="dd/mm/yyyy" value="<%=m.getDateoflaunch()%>"></input>
						</td>
						<td><%String cat=m.getCategory();%> 
							<label class="form-item" for="field-category">Category</label>
							<select class="form-input" name="category" id="field-category">
							
							<%if(cat.equals("Starters")){ %>
  <option value="Starters" selected>Starters</option>
    <option value="Main Course">Main Course</option>
  <option value="Desert">Desert</option>
  <%} else if(cat.equals("Main Course")){ %>
  <option value="Main Course">Main Course</option>
   <option value="Starters">Starters</option>
    <option value="Desert">Desert</option>
    <%} else if(cat.equals("Desert")){ %>
  <option value="Desert" selected>Desert</option>
     <option value="Starters">Starters</option>
      <option value="Main Course">Main Course</option>
  <%} %> 
							
							</select>
						</td>
					</tr>
					<tr colspan=4>
						<td>
							<label class="form-item" for="field-freeDelivery">
							<% if(m.getFreedelivery().equals("Yes")){ %>
								<input type="checkbox" name="freeDelivery" id="field-freeDelivery" checked>Free Delivery
								<%}else{ %>
								<input type="checkbox" name="freeDelivery" id="field-freeDelivery">Free Delivery
							<%}%>
								<span class="form-checkbox"></span>
							</label>
						</td>
					</tr>
					<tr colspan=4>
						<td>
							<input class="form-button" type="submit" name="submit" value="Save"></input>
						</td>
					</tr>
				</table>
			</form>
		</article>
		<footer>
			<p>Copyright &copy; 2019</p>
		</footer>
	</body>
</html>