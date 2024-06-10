<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Auction - Error</title>
<link rel="stylesheet" type="text/css" href="/08-03-Verbickaya-Stepanova/styles/HeaderStyles.css">
<link rel="stylesheet" type="text/css" href="/08-03-Verbickaya-Stepanova/styles/BodyStyles.css">
<link rel="stylesheet" type="text/css" href="/08-03-Verbickaya-Stepanova/styles/ButtonStyles.css">
<link rel="stylesheet" type="text/css" href="/08-03-Verbickaya-Stepanova/styles/FieldStyles.css">
<style>
/* Стилизация ссылок */
a {
	text-decoration: none;
	text-align: center;
	background-color: #333; /* Темно-серый цвет фона */
	color: white; /* Белый цвет текста */
	padding: 10px 20px; /* Отступы вокруг текста */
	border: none; /* Убрать границу */
	cursor: pointer; /* Изменить курсор при наведении */
	display: block; /* Расположить кнопку как блочный элемент */
	margin: 0 auto; /* Центрировать кнопку по горизонтали */
	font-size: 18px;
	font-family: 'Arial', sans-serif; /* Установить шрифт */
	border-radius: 5px;
	transition: background-color 0.2s, color 0.2s;
}

a:hover {
	background-color: #7a6761;
}
</style>
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
	<h1>Ouch!</h1>
	<p>What are you doing?</p>
	<p>Ah ah ah, wicked user!</p>
	<hr>
	<a href="/08-03-Verbickaya-Stepanova/index.jsp">To the login page</a>
	<hr />
</body>
</html>