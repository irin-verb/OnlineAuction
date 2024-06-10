<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="myGoods.jsp"%>
<html>
<body>
	<input type="hidden" name="goodCategories" value="${categoriesList}">
	<form name="goodsForm" method="POST" action="controller">
		<input type="hidden" name="command" value="saveNewGood"><input
			type="hidden" name="filter" value="${filter}">
		<div class="little-page-container">
			<div class="little-page-top-header">
				<h1>Creating new good</h1>
			</div>
			<div class="little-page-content">
				<p>${errorMessage}</p>
				<hr>
				<div class="string-container">
					<h2>Name</h2>
				</div>
				<input type="text" name="goodName" value="" maxlength="40" />
				<hr>

				<div class="string-container">
					<h2>Description</h2>
				</div>
				<textarea name="goodDescription" rows="2" cols="50" maxlength="200">${good.getDescription()}</textarea>
				<hr>

				<div class="string-container">
					<h2>Category</h2>
				</div>
				<select name="goodCategory">
					<c:forEach items="${goodCategories}" var="category">
						<option value="${category}" selected>${category}</option>
					</c:forEach>
				</select>
				<hr>

				<div class="string-container">
					<h2>Price</h2>
				</div>
				<input type="text" name="goodPrice" value=""
					oninput="this.value = this.value.replace(/[^0-9]/g, ''); if (this.value.length > 10) this.value = this.value.slice(0, 10);"
					maxlength="10" />
				<hr>

			</div>

			<div class="little-page-bottom-header-spec">
				<button type="submit" id="goodPage">Save new good</button>
			</div>

		</div>
	</form>
</body>
</html>