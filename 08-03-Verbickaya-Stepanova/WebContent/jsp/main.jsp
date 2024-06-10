<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!-- Включаем шапку -->
<html>
<body>
	<h3>
		Welcome to our online auction, ${user}!<br>
		<c:choose>
			<c:when test="${userType.name() eq 'user'}">
			Explore, bid, and win. Happy bidding!
			</c:when>
			<c:when test="${userType.name() eq 'moder'}">
			You have the power to block troublesome users<br>and take items off the market if necessary.<br>You also can customize the system settings.<br>Happy moderating!
			</c:when>
			<c:when test="${userType.name() eq 'admin'}">
			Manage users with ease - add, edit,<br>or remove them as needed.<br>Happy administering!
			</c:when>
		</c:choose>
	</h3>
</body>
</html>

