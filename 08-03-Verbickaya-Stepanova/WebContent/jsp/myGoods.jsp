<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!-- Включаем шапку -->
<html>
<body>

	<input type="hidden" name="goods" value="${goodsList}">
	<input type="hidden" id="currentFilter" name="currentFilter"
		value="${filter}">

	<div class="sideheader">

		<!-- Вертикальная шапка -->

		<form name="menuForm" method="POST" action="controller">
			<input type="hidden" name="command" value="myGoods"> <input
				type="hidden" name="filter" value="On sale">
			<button id="On sale" name="filterButton" class="small" type="submit">On
				sale</button>
		</form>

		<form name="menuForm" method="POST" action="controller">
			<input type="hidden" name="command" value="myGoods"><input
				type="hidden" name="filter" value="Sold">
			<button id="Sold" name="filterButton" class="small" type="submit">Sold</button>
		</form>

		<form name="menuForm" method="POST" action="controller">
			<input type="hidden" name="command" value="myGoods"> <input
				type="hidden" name="filter" value="Removed from sale">
			<button id="Removed from sale" name="filterButton" class="small"
				type="submit">Removed from sale</button>
		</form>

	</div>



	<div class="table-container">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Creating date</th>
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
						<td>${good.getCreatingDate()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="info-container">
		<p>Explore the complete history of items you've listed on our
			platform right here. Whether you're looking to reminisce about your
			sold and expired listings or breathe new life into your active ones,
			this is the place to be. With 'My Goods' you have the power to view,
			edit, and list new items for sale. It's your personal inventory of
			online treasures waiting to find their next home!</p>

		<c:choose>
			<c:when test="${filter eq 'On sale'}">
				<form name="goodsForm" method="POST" action="controller">
					<input type="hidden" name="command" value="newGood"> <input
						type="hidden" name="filter" value="${filter}">
					<button type="submit">Create new good</button>
				</form>
			</c:when>
		</c:choose>
	</div>

	<script src="js/headerScript.js"></script>

</body>
</html>