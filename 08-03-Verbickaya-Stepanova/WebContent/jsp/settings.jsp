<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="goods.jsp"%>
<html>
<body>
	<input type="hidden" name="goodCategories" value="${categoriesList}">

	<form name="goodsForm" method="POST" action="controller">
		<input type="hidden" name="command" value="saveSettings"><input
			type="hidden" name="filter" value="${filter}">
		<div class="little-page-container">

			<div class="little-page-top-header">
				<h1>Setting new constants</h1>
			</div>

			<div class="little-page-content">
				<p>${errorMessage}</p>
				<hr>
				<div class="string-container">
					<h2>General default price step</h2>
				</div>
				<input type="text" name="priceStep" value="${priceStepSetting}"
					oninput="this.value = this.value.replace(/[^0-9]/g, ''); if (this.value.length > 10) this.value = this.value.slice(0, 10);"
					maxlength="7" />
				<hr>

				<div class="string-container">
					<h2>General default selling interval (days)</h2>
				</div>
				<input type="text" name="sellingInterval"
					value="${sellingIntervalSetting}"
					oninput="this.value = this.value.replace(/[^0-9]/g, ''); if (this.value.length > 10) this.value = this.value.slice(0, 10);"
					maxlength="3" />
				<hr>
			</div>

			<div class="little-page-bottom-header-spec">
				<button type="submit" id="goodPage">Save settings</button>
			</div>

		</div>
	</form>
</body>
</html>