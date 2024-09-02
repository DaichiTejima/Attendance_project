<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
	<div>
		<h1>新規登録</h1>
		<form action="employees-register" method="post">
			<div>
				<label for="id">従業員ID</label><br>
				<input type="text" name="employee_id" id="id">
			</div>
			<div>
				<label for="pass">パスワード</label><br>
				<input type="text" name="password" id="pass">
			</div>
			<div>
				<label for="nam">名前</label><br>
				<input type="text" name="name" id="nam">
			</div>
			<div>
				<label for="age">年齢</label><br>
				<input type="text" name="age" id="age">
			</div>
			<div>
				<button type="submit">登録</button>
				<a href="login.jsp">戻る</a>
			</div>
		</form>
	</div>

</body>
</html>