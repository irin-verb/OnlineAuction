<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Auction - Login</title>
<link rel="stylesheet" type="text/css" href="/08-03-Verbickaya-Stepanova/styles/HeaderStyles.css">
<link rel="stylesheet" type="text/css" href="/08-03-Verbickaya-Stepanova/styles/BodyStyles.css">
<link rel="stylesheet" type="text/css" href="/08-03-Verbickaya-Stepanova/styles/ButtonStyles.css">
<link rel="stylesheet" type="text/css" href="/08-03-Verbickaya-Stepanova/styles/FieldStyles.css">
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><form name="menuForm" method="POST" action="">
						<button class="title" type="submit">ONLINE-AUCTION</button>
					</form></li>
			</ul>
		</nav>
	</header>
	<form name="loginForm" method="POST" action="/08-03-Verbickaya-Stepanova/controller">
		<input type="hidden" name="command" value="login" />
		<p>Login:</p>
		<input type="text" name="login" value="" />
		<p>Password:</p>
		<input type="password" name="password" value="" />
		<p>${errorLoginPassMessage}</p>
		<p>${wrongAction}</p>
		<p>${nullPage}</p>
		<p>${sessionEndMessage}</p>
		<p>${smthgWentWrongMessage}</p>
		<input type="submit" value="Log in" />
	</form>
	<hr />
</body>
</html>
