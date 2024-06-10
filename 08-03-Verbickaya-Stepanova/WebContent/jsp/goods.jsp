<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!-- Включаем шапку -->
<html>
<body>

	<input type="hidden" name="goods" value="${goodsList}">
	<input type="hidden" name="categories" value="${categoriesList}">
	<input type="hidden" id="currentFilter" name="currentFilter"
		value="${filter}">

	<div class="sideheader">
		<!-- Вертикальная шапка -->
		<form name="menuForm" method="POST" action="controller">
			<input type="hidden" name="command" value="goods"> <input
				type="hidden" name="filter" value="All goods">
			<button id="All goods" name="filterButton" class="small"
				type="submit">All goods</button>
		</form>
		<form name="menuForm" method="POST" action="controller">
			<input type="hidden" name="command" value="goods"> <input
				type="hidden" name=filter value="Hot goods">
			<button id="Hot goods" name="filterButton" class="small"
				type="submit">Hot goods</button>
		</form>

		<c:forEach items="${categories}" var="category">
			<form name="menuForm" method="POST" action="controller">
				<input type="hidden" name="command" value="goods"> <input
					type="hidden" name="filter" value="${category}">
				<button id="${category}" name="filterButton" class="small"
					type="submit">${category}</button>
			</form>
		</c:forEach>
	</div>

	<div class="table-container">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Selling date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${goods}" var="good">
					<tr>
						<td>
							<form name="goodsForm" method="POST" action="controller">
								<input type="hidden" name="command" value="openGood"> <input
									type="hidden" name="filter" value="${filter}"> <input
									type="hidden" name="goodID" value="${good.getId()}">
								<button type="submit" id="goodPage">${good.getName()}</button>
							</form>
						</td>
						<td>${good.getPrice()}</td>
						<td>${good.getSellingDate()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="info-container">
		<c:choose>
			<c:when test="${userType eq 'user'}">
				<p>On this page, you can browse through a wide array of items
					listed for sale by other users. Explore different categories, click
					on the items that catch your eye, and engage in transactions with
					ease!</p>
			</c:when>
			<c:when test="${userType eq 'moder'}">
				<p>This page empowers you to oversee the diverse array of items
					available on our platform. Review the list of products, exercise
					the authority to remove items from sale, and effortlessly modify
					their details. You have the capability to set sales intervals and
					adjust price increments, ensuring a seamless and controlled auction
					environment. Dive into the role of moderation with ease and
					precision!</p>
				<form name="goodsForm" method="POST" action="controller">
					<input type="hidden" name="command" value="settings"> <input
						type="hidden" name="filter" value="${filter}">
					<button type="submit">General settings</button>
				</form>
			</c:when>
		</c:choose>
	</div>

	<script src="js/headerScript.js"></script>

</body>
</html>