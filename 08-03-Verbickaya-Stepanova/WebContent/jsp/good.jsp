<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:import url="${parentPage}" />
<html>
<body>

	<input type="hidden" name="currentGood" value="${good}">
	<input type="hidden" name="isMyGood" value="${isMyGood}">
	<input type="hidden" name="currentGoodOwner" value="${goodOwner}">

	<div class="little-page-container">

		<div class="little-page-top-header">
			<h1>${good.getName()}</h1>
		</div>

		<div class="little-page-content">
			<h2>Description</h2>
			<p>${good.getDescription()}</p>
			<hr>

			<c:if test="${userType eq 'moder'}">
				<div class="string-container">
					<h2>ID:</h2>
					<p>${good.getId()}</p>
				</div>
				<hr>
			</c:if>

			<div class="string-container">
				<c:choose>
					<c:when test="${good.getStatus() eq 'sold'}">
						<h2>Final price:</h2>
					</c:when>
					<c:otherwise>
						<h2>Current price:</h2>
					</c:otherwise>
				</c:choose>
				<p>${good.getPrice()}</p>
			</div>


			<c:if test="${good.getStatus() eq 'sold'}">
				<div class="string-container">
					<h2>Final owner:</h2>
					<p>${goodOwner}</p>
				</div>
			</c:if>

			<div class="string-container">
				<h2>Selling date:</h2>
				<p>${good.getSellingDate()}</p>
			</div>

			<div class="string-container">
				<h2>Seller:</h2>
				<p>${good.getSeller()}</p>
			</div>
			<hr>

			<c:if test="${isMyGood || userType eq 'moder'}">
				<div class="string-container">
					<h2>Starting price:</h2>
					<p>${good.getStartPrice()}</p>
				</div>
				<div class="string-container">
					<h2>Status:</h2>
					<p>${good.getStatus()}</p>
				</div>
			</c:if>

			<div class="string-container">
				<h2>Category:</h2>
				<p>${good.getCategory()}</p>
			</div>

			<c:if test="${isMyGood || userType eq 'moder'}">
				<div class="string-container">
					<h2>Creating date:</h2>
					<p>${good.getCreatingDate()}</p>
				</div>
			</c:if>
			<hr>

			<c:if test="${good.getStatus() eq 'selling' || userType eq 'moder'}">
				<div class="string-container">
					<h2>Number of trades:</h2>
					<p>${good.getBetCount()}</p>
				</div>
			</c:if>

			<c:if test="${isMyGood || userType eq 'moder'}">
				<div class="string-container">
					<h2>Price step:</h2>
					<p>${good.getPriceStep()}</p>
				</div>
			</c:if>

			<c:if test="${userType eq 'moder'}">
				<div class="string-container">
					<h2>Selling interval:</h2>
					<p>${good.getSellingInterval()}days</p>
				</div>
			</c:if>

		</div>

		<c:choose>
			<c:when
				test="${good.getStatus() eq 'selling' && (isMyGood || userType eq 'moder')}">
				<div class="little-page-bottom-header">
					<form name="goodsForm" method="POST" action="controller">
						<input type="hidden" name="command" value="editGood"><input
							type="hidden" name="filter" value="${filter}"><input
							type="hidden" name="goodID" value="${good.getId()}">
						<button type="submit" id="goodPage">Edit good data</button>
					</form>
					<form name="goodsForm" method="POST" action="controller">
						<input type="hidden" name="command" value="removeGood"><input
							type="hidden" name="filter" value="${filter}"><input
							type="hidden" name="goodID" value="${good.getId()}">
						<button type="submit" id="goodPage">Remove from sale</button>
					</form>
				</div>
			</c:when>
			<c:when
				test="${good.getStatus() eq 'selling' && !isMyGood && userType eq 'user'}">
				<div class="little-page-bottom-header">
					<form name="goodsForm" method="POST" action="controller">
						<input type="hidden" name="command" value="raisePrice"> <input
							type="hidden" name="filter" value="${filter}"><input
							type="hidden" name="goodID" value="${good.getId()}">
						<button type="submit" id="goodPage">Raise price by
							${good.getPriceStep()}$</button>
					</form>
				</div>
			</c:when>
		</c:choose>
	</div>
</body>
</html>