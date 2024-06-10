<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!-- Включаем шапку -->
<html>
<body>

	<input type="hidden" name="goods" value="${goodsList}">
	<!-- <input type="hidden" name="categories" value="${categoriesList}"> -->
	<input type="hidden" id="currentFilter" name="currentFilter"
		value="${filter}">

	<div class="sideheader">
		<!-- Вертикальная шапка -->

		<c:choose>
			<c:when test="${userType eq 'admin'}">
				<form name="menuForm" method="POST" action="controller">
					<input type="hidden" name="command" value="users"><input
						type="hidden" name="filter" value="All users">
					<button id="All users" name="filterButton" class="small"
						type="submit">All users</button>
				</form>
				<form name="menuForm" method="POST" action="controller">
					<input type="hidden" name="command" value="users"> <input
						type="hidden" name="filter" value="Admins">
					<button id="Admins" name="filterButton" class="small" type="submit">Admins</button>
				</form>
				<form name="menuForm" method="POST" action="controller">
					<input type="hidden" name="command" value="users"> <input
						type="hidden" name="filter" value="Moders">
					<button id="Moders" name="filterButton" class="small" type="submit">Moders</button>
				</form>
				<form name="menuForm" method="POST" action="controller">
					<input type="hidden" name="command" value="users"> <input
						type="hidden" name="filter" value="Normal users">
					<button id="Normal users" name="filterButton" class="small"
						type="submit">Normal users</button>
				</form>
				<form name="menuForm" method="POST" action="controller">
					<input type="hidden" name="command" value="users"> <input
						type="hidden" name="filter" value="Authorized">
					<button id="Authorized" name="filterButton" class="small"
						type="submit">Authorized</button>
				</form>
				<form name="menuForm" method="POST" action="controller">
					<input type="hidden" name="command" value="users"> <input
						type="hidden" name="filter" value="Unauthorized">
					<button id="Unauthorized" name="filterButton" class="small"
						type="submit">Unauthorized</button>
				</form>
			</c:when>
			<c:when test="${userType eq 'moder'}">
				<form name="menuForm" method="POST" action="controller">
					<input type="hidden" name="command" value="users"> <input
						type="hidden" name="filter" value="Normal users">
					<button id="Normal users" name="filterButton" class="small"
						type="submit">All users</button>
				</form>
				<form name="menuForm" method="POST" action="controller">
					<input type="hidden" name="command" value="users"> <input
						type="hidden" name="filter" value="Blocked">
					<button id="Blocked" name="filterButton" class="small"
						type="submit">Blocked</button>
				</form>
				<form name="menuForm" method="POST" action="controller">
					<input type="hidden" name="command" value="users"> <input
						type="hidden" name="filter" value="Not blocked">
					<button id="Not blocked" name="filterButton" class="small"
						type="submit">Not blocked</button>
				</form>
			</c:when>
		</c:choose>

	</div>

	<div class="table-container">
		<table>
			<thead>
				<tr>
					<th>Login</th>
					<th>Type</th>
					<th>Authorized</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="oneUser">
					<tr>
						<td>
							<form name="goodsForm" method="POST" action="controller">
								<input type="hidden" name="command" value="openUser"> <input
									type="hidden" name="filter" value="${filter}"> <input
									type="hidden" name="userLogin" value="${oneUser.getLogin()}">
								<button type="submit" id="goodPage">${oneUser.getLogin()}</button>
							</form>
						</td>
						<td>${oneUser.getType()}</td>
						<c:choose>
							<c:when test="${oneUser.isOnlineStatus()}">
								<td>+</td>
							</c:when>
							<c:otherwise>
								<td></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="info-container">
		<c:choose>
			<c:when test="${userType eq 'admin'}">
				<p>This page provides you with comprehensive control over our
					user base. Explore the list of users, add new members, remove
					users, and seamlessly edit all their information. Empower yourself
					with the tools to manage the community effectively, ensuring a
					secure and dynamic user environment.</p>
			</c:when>
			<c:when test="${userType eq 'moder'}">
				<p>Dive into this page to oversee our community of users. Browse
					through the user list, and exercise the authority to block or
					unblock users as needed. Your role involves maintaining a safe and
					welcoming environment, and this page equips you with the tools to
					achieve just that. Together, let's foster a positive and inclusive
					online space.</p>
			</c:when>
		</c:choose>
		<c:if test="${filter eq 'All users' && userType eq 'admin'}">
			<form name="goodsForm" method="POST" action="controller">
				<input type="hidden" name="command" value="newUser"> <input
					type="hidden" name="filter" value="${filter}">
				<button type="submit">Add new user</button>
			</form>
		</c:if>
	</div>

	<script src="js/headerScript.js"></script>

</body>
</html>