<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
</head>
<body>
	<header class="header">
		<h1>メニュー</h1>
	</header>
	<main>
		<div class="main">
			<a href="login.jsp" class="logout">ログアウト</a><br>
			<form action="attendances-register" method="get">
				<button type="submit">登録</button>
			</form>
			<form action="attendances-list" method="get">
				<button type="submit">一覧</button>
			</form>
			<form action="attendances-over_time" method="get">
				<button type="submit">残業管理</button>
			</form>
		</div>
	</main>
</body>
</html>