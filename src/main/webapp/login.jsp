<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
	<h1>ログイン</h1>
	<form action="menu" method="post">
		従業員ID：<input type="text" name="employee_id"><br>
		<br>
		パスワード：<input type="text" name="password" required><br>
		<br>
		<input type="submit" value="ログイン"><br>
	</form>
	<br>
	<a href="employees-register.jsp"><button>新規登録</button></a>
</body>
</html>
