<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="users.jsp"%>
<html>
<body>

	<input type="hidden" name="openedUser" value="${openedUser}">

	<div class="little-page-container">

		<div class="little-page-top-header">
			<h1>${openedUser.getLogin()}</h1>
		</div>

		<div class="little-page-content">

			<hr>
			<h2>Type</h2>
			<p>${openedUser.getType()}</p>
			<hr>

			<c:if test="${userType eq 'admin'}">
				<div class="string-container">
					<h2>Password:</h2>
					<p>${openedUser.getParole()}</p>
				</div>
				<hr>
			</c:if>

			<div class="string-container">
				<h2>Authorized:</h2>
				<p>${openedUser.isOnlineStatus()}</p>
			</div>

			<div class="string-container">
				<h2>Blocked:</h2>
				<p>${openedUser.isBlockingStatus()}</p>
			</div>
			<hr>

		</div>

		<c:choose>
			<c:when test="${userType eq 'admin'}">
				<div class="little-page-bottom-header">
					<form name="goodsForm" method="POST" action="controller">
						<input type="hidden" name="command" value="editUser"><input
							type="hidden" name="filter" value="${filter}"><input
							type="hidden" name="userLogin" value="${openedUser.getLogin()}">
						<button type="submit" id="goodPage">Edit user data</button>
					</form>
					<c:if test="${!openedUser.getLogin().equals(user)}">
						<form name="goodsForm" method="POST" action="controller">
							<input type="hidden" name="command" value="removeUser"> <input
								type="hidden" name="filter" value="${filter}"><input
								type="hidden" name="userLogin" value="${openedUser.getLogin()}">
							<button type="submit" id="goodPage">Delete user</button>
						</form>
					</c:if>
				</div>
			</c:when>
			<c:when test="${userType eq 'moder'}">
				<div class="little-page-bottom-header">
					<form name="goodsForm" method="POST" action="controller">
						<input type="hidden" name="command" value="reverseBlockingStatus">
						<input type="hidden" name="filter" value="${filter}"><input
							type="hidden" name="userLogin" value="${openedUser.getLogin()}">
						<button type="submit" id="goodPage">
							<c:choose>
								<c:when test="${openedUser.isBlockingStatus()}">
								Unblock user
								</c:when>
								<c:when test="${!openedUser.isBlockingStatus()}">
								Block user
								</c:when>
							</c:choose>
						</button>
					</form>
				</div>
			</c:when>
		</c:choose>
	</div>
</body>
</html>