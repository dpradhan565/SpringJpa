<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Movie Cruiser</title>
<link rel="icon" type="image/ico" href="./images/logo.png" />
<link rel="stylesheet" type="text/css" href="./style/style.css">
</head>
<body>
	<header>
		<span class="header-title">Movie Cruiser</span> <img
			class="header-logo" src="./images/logo.png" alt="Movie Cruiser Logo"></img>
		<nav>
			<a class="nav-link" href="./movie-list-admin.html">Movies</a>
		</nav>
	</header>
	<article>
		<h2 class="article-heading">Movies</h2>

		<table>
			<tr>
				<th class="col-left">Title</th>
				<th class="col-right">Box Office</th>
				<th>Active</th>
				<th>Date of Launch</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${movielist}" var="item">
				<tr>
					<td class="col-left">${item.title}</td>
					<td class="col-right">${item.boxOffice}</td>
					<td>${item.active}</td>
					<td>${item.dateOfLaunch}</td>
					<td>${item.genre}</td>
					<td>${item.hasTeaser}</td>
					<td><a class="action-link" href="/edit-movie?id=${item.id}">Edit</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</article>
	<footer>
		<p>Copyright &copy; 2019</p>
	</footer>
</body>
</html>