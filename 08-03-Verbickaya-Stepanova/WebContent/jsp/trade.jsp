<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="trades.jsp"%>
<html>
<body>

	<input type="hidden" name="currentTrade" value="${trade}">
	<input type="hidden" name="currentTradeType" value="${tradeType}">

	<div class="little-page-container">

		<div class="little-page-top-header">
			<form name="goodsForm" method="POST" action="controller">
				<input type="hidden" name="command" value="openGood"><input
					type="hidden" name="filter" value="${filter}"> <input
					type="hidden" name="goodID" value="${trade.getProductId()}">
				<button type="submit" id="goodPage">${trade.getName()}</button>
			</form>
		</div>

		<div class="little-page-content">

			<h2>Description</h2>
			<p>${trade.getDescription()}</p>
			<hr>

			<c:choose>
				<c:when test="${tradeType.name() != 'notMyTrade'}">
					<div class="string-container">
						<c:choose>
							<c:when test="${tradeType.name() != 'winnedTrade'}">
								<h2>Your price:</h2>
							</c:when>
							<c:otherwise>
								<h2>Final price:</h2>
							</c:otherwise>
						</c:choose>
						<p>${trade.getPrice()}</p>
					</div>
					<c:choose>
						<c:when test="${tradeType.name() eq 'losingTrade'}">
							<div class="string-container">
								<h2>Current price:</h2>
								<p>${trade.getCurrentPrice()}</p>
							</div>
						</c:when>
						<c:when test="${tradeType.name() eq 'losedTrade'}">
							<div class="string-container">
								<h2>Final price:</h2>
								<p>${trade.getCurrentPrice()}</p>
							</div>
						</c:when>
					</c:choose>
					<div class="string-container">
						<h2>Date:</h2>
						<p>${trade.getDate()}</p>
					</div>
				</c:when>
			</c:choose>

			<hr>
			<c:choose>
				<c:when test="${tradeType.name() eq 'winningTrade'}">
					<div class="win">You are winning of the auction for this
						item!</div>
				</c:when>
				<c:when test="${tradeType.name() eq 'winnedTrade'}">
					<div class="win">You won the auction for this good!</div>
				</c:when>
				<c:when test="${tradeType.name() eq 'losingTrade'}">
					<div class="lose">You are losing the auction for this good :(</div>
				</c:when>
				<c:when test="${tradeType.name() eq 'losedTrade'}">
					<div class="lose">You lose the auction for this item :((</div>
				</c:when>
				<c:when test="${tradeType.name() eq 'notMyTrade'}">
					<div class="lose">This is not your deal... how did you get
						here? Maybe you are a moderator?</div>
				</c:when>
			</c:choose>
			<hr>
		</div>
		<c:choose>
			<c:when
				test="${tradeType.name() eq 'winningTrade' || tradeType.name() eq 'losingTrade'}">
				<div class="little-page-bottom-header">
					<form name="goodsForm" method="POST" action="controller">
						<input type="hidden" name="command" value="openGood"> <input
							type="hidden" name="filter" value="${filter}"> <input
							type="hidden" name="goodID" value="${trade.getProductId()}">
						<button type="submit" id="goodPage">Go to product card</button>
					</form>
				</div>
			</c:when>
		</c:choose>

	</div>
</body>
</html>