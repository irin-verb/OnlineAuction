<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!-- Включаем шапку -->
<html>
<body>

	<input type="hidden" name="trades" value="${tradesList}">
	<input type="hidden" id="currentFilter" name="currentFilter"
		value="${filter}">

	<div class="sideheader">
		<!-- Вертикальная шапка -->
		<form name="menuForm" method="POST" action="controller">
			<input type="hidden" name="command" value="trades"> <input
				type="hidden" name="filter" value="All trades">
			<button id="All trades" name="filterButton" class="small"
				type="submit">All trades</button>
		</form>
		<form name="menuForm" method="POST" action="controller">
			<input type="hidden" name="command" value="trades"> <input
				type="hidden" name=filter value="Successful">
			<button id="Successful" name="filterButton" class="small"
				type="submit">Successful</button>
		</form>
		<form name="menuForm" method="POST" action="controller">
			<input type="hidden" name="command" value="trades"> <input
				type="hidden" name=filter value="Unsuccessful">
			<button id="Unsuccessful" name="filterButton" class="small"
				type="submit">Unsuccessful</button>
		</form>
	</div>

	<div class="table-container">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Your price</th>
					<th>Trade date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${trades}" var="trade">
					<tr>
						<td>
							<form name="goodsForm" method="POST" action="controller">
								<input type="hidden" name="command" value="openTrade"> <input
									type="hidden" name="filter" value="${filter}"> <input
									type="hidden" name="tradeID" value="${trade.getId()}">
								<button type="submit" id="goodPage">${trade.getName()}</button>
							</form>
						</td>
						<td>${trade.getPrice()}</td>
						<td>${trade.getDate()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="info-container">
		<p>On this web page, you can track your online auction activity
			with ease. Here, you have the ability to review both your successful
			and unsuccessful bids, allowing you to assess your bidding
			strategies. Additionally, you can swiftly navigate to product
			listings that pique your interest, enabling you to place higher bids
			and potentially win the items you desire.</p>
	</div>

	<script src="js/headerScript.js"></script>

</body>
</html>