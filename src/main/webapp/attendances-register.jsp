<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠登録</title>
</head>
<body>
	<div>
 		<h1>勤怠登録</h1>
 		<form action="attendances-register" method="post">
 			<div>
 				<label for="id">従業員ID：</label>
 				<input type="text" name="employee_id" id="employee_id">
 			</div>
 			<div>
 				<label for="date">日付：</label>
 				<input type="date" name="date" id="date">
 			</div>
 			<div>
 				<label for="time">始業時間</label><br>
 				<input type="time" name="start_time" id="start_time">
 			</div>
 			<div>
 				<label for="time">終業時間</label><br>
 				<input type="time" name="end_time" id="end_time">
 			</div>
 			<div>
 				<label for="time">休憩時間</label><br>
 				<input type="time" name="break_time" id="break_time">
 			</div>
 			<div>
 				<label for="time">就業時間</label><br>
 				<input type="time" name="work_time" id="work_time">
 			</div>
 			<div>
 				<label for="time">残業時間</label><br>
 				<input type="time" name="over_time" id="over_time">
 			</div>
 			
			<button type="submit">登録</button>
			<a href="menu">戻る</a>
 		</form>
	</div>
</body>
</html>