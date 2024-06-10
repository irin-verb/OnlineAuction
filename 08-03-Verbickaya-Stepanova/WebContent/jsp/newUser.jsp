<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="users.jsp"%>
<html>
<body>

	<input type="hidden" name="openedUser" value="${openedUser}">

	<form name="goodsForm" method="POST" action="controller">
		<input type="hidden" name="command" value="saveNewUser"> <input
			type="hidden" name="filter" value="${filter}"><input
			type="hidden" name="userLogin" value="${openedUser.getLogin()}">

		<div class="little-page-container">
			<div class="little-page-top-header">
				<h1>Creating new user</h1>
			</div>

			<div class="little-page-content">
				<p>${errorMessage}</p>
				<hr>
				<div class="string-container">
					<h2>Login</h2>
				</div>
				<input type="text" name="newUserLogin" value="" maxlength="15" />
				<hr>

				<div class="string-container">
					<h2>Password</h2>
				</div>
				<input type="text" name="password" value="1" maxlength="15" />
				<hr>

				<div class="string-container">
					<h2>Type</h2>
				</div>
				<select name="type">
					<option value="admin">admin</option>
					<option value="moder">moder</option>
					<option value="user" selected>user</option>
				</select>
				<hr>

			</div>

			<div class="little-page-bottom-header-spec">
				<button type="submit" id="goodPage">Save new user</button>
			</div>

		</div>
	</form>
</body>
</html>