<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:import url="${parentPage}" />
<html>
<body>

	<input type="hidden" name="currentGood" value="${good}">

	<form name="goodsForm" method="POST" action="controller">
		<input type="hidden" name="command" value="saveGood"> <input
			type="hidden" name="filter" value="${filter}"><input
			type="hidden" name="goodID" value="${good.getId()}">

		<div class="little-page-container">
			<div class="little-page-top-header">
				<h1>${good.getName()}</h1>
			</div>
			<div class="little-page-content">
				<p>${errorMessage}</p>

				<c:if test="${userType eq 'moder'}">
					<hr>
					<div class="string-container">
						<h2>ID:</h2>
						<p>${good.getId()}</p>
					</div>
				</c:if>

				<c:if test="${userType eq 'moder'}">
					<hr>
					<div class="string-container">
						<h2>Price step</h2>
					</div>
					<input type="text" name="priceStep" value="${good.getPriceStep()}"
						oninput="this.value = this.value.replace(/[^0-9]/g, ''); if (this.value.length > 10) this.value = this.value.slice(0, 10);"
						maxlength="7" />
					<div class="string-container">
						<h2>Selling interval</h2>
					</div>
					<input type="text" name="sellingInterval"
						value="${good.getSellingInterval()}"
						oninput="this.value = this.value.replace(/[^0-9]/g, ''); if (this.value.length > 10) this.value = this.value.slice(0, 10);"
						maxlength="3" />
					<hr>
				</c:if>

				<h2>Description</h2>
				<c:choose>
					<c:when test="${userType eq 'moder'}">
						<p>${good.getDescription()}</p>
						<hr>
					</c:when>
					<c:when test="${userType eq 'user'}">
						<textarea name="description" rows="4" cols="50">${good.getDescription()}</textarea>
						<hr>
					</c:when>
				</c:choose>

				<div class="string-container">
					<h2>Current price:</h2>
					<p>${good.getPrice()}</p>
				</div>

				<div class="string-container">
					<h2>Selling date:</h2>
					<p>${good.getSellingDate()}</p>
				</div>

				<div class="string-container">
					<h2>Seller:</h2>
					<p>${good.getSeller()}</p>
				</div>
				<hr>

				<div class="string-container">
					<h2>Starting price:</h2>
					<p>${good.getStartPrice()}</p>
				</div>

				<div class="string-container">
					<h2>Number of trades:</h2>
					<p>${good.getBetCount()}</p>
				</div>

				<c:if test="${userType != 'moder'}">
					<div class="string-container">
						<h2>Price step:</h2>
						<p>${good.getPriceStep()}</p>
					</div>
				</c:if>

				<div class="string-container">
					<h2>Status:</h2>
					<p>${good.getStatus()}</p>
				</div>
				<hr>

				<div class="string-container">
					<h2>Category:</h2>
					<p>${good.getCategory()}</p>
				</div>

				<div class="string-container">
					<h2>Creating date:</h2>
					<p>${good.getCreatingDate()}</p>
				</div>

				<div class="string-container">
					<h2>Number of trades:</h2>
					<p>${good.getBetCount()}</p>
				</div>

			</div>

			<div class="little-page-bottom-header-spec">
				<button type="submit" id="goodPage">Save changes</button>
			</div>

		</div>
	</form>
</body>
</html>