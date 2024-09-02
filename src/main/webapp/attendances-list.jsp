<%@page import="model.entity.AttendancesBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<AttendancesBean> attendancesList = (List<AttendancesBean>) request.getAttribute("attendancesList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠一覧</title>
</head>
<body>
	<h1>勤怠一覧</h1>
	<table>
		<thead>
			<tr>
				<th>従業員ID</th>
				<th>日付</th>
				<th>始業時間</th>
				<th>終業時間</th>
				<th>休憩時間</th>
				<th>就業時間</th>
				<th>残業時間</th>
				<th></th>
				<th></th>
			</tr>
		</thead> 
		<tbody>
			<%
				for (AttendancesBean attendances : attendancesList) {
			%>
				<tr>
					<td><%=attendances.getEmployee_id()%></td>
					<td><%=attendances.getDate()%></td>
					<td><%=attendances.getStart_time()%></td>
					<td><%=attendances.getEnd_time()%></td>
					<td><%=attendances.getBreak_time()%></td>
					<td><%=attendances.getWork_time()%></td>
					<td><%=attendances.getOver_time()%></td>
					<td><a href="attendances-edit?id=<%=attendances.getEmployee_id()%>">編集</a></td>
					<td><a href="attendances-delete?id=<%=attendances.getEmployee_id()%>">削除</a></td>
				</tr>
			<%
				}
			
			%>
			
			
		</tbody>
	</table>
	<div>
		<input type="text" name="attendances-search" id="search">
		<button type="submit">検索</button>
	</div>
	<a href="menu.jsp">戻る</a>
	
</body>
</html>