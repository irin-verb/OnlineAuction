<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="users.jsp"%>
<html>
<body>

	<input type="hidden" name="openedUser" value="${openedUser}">

	<form name="goodsForm" method="POST" action="controller">
		<input type="hidden" name="command" value="saveUser"> <input
			type="hidden" name="filter" value="${filter}"><input
			type="hidden" name="userLogin" value="${openedUser.getLogin()}">

		<div class="little-page-container">
			<div class="little-page-top-header">
				<h1>${openedUser.getLogin()}</h1>
			</div>

			<div class="little-page-content">
				<hr>
				<div class="string-container">
					<h2>Password</h2>
				</div>
				<input type="text" name="password" value="${openedUser.getParole()}"
					maxlength="15" />
				<hr>

				<div class="string-container">
					<h2>Blocking status</h2>
				</div>
				<select name="blockingStatus">
					<option value="true"
						<c:if test="${openedUser.isBlockingStatus()}">selected</c:if>>blocked</option>
					<option value="false"
						<c:if test="${!openedUser.isBlockingStatus()}">selected</c:if>>not
						blocked</option>
				</select>
				<hr>

			</div>

			<div class="little-page-bottom-header-spec">
				<button type="submit" id="goodPage">Save changes</button>
			</div>

		</div>
	</form>
</body>
</html>