package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import model.entity.AttendancesBean;

public class AttendancesDAO {

	public List<AttendancesBean> getAttendancesList() throws ClassNotFoundException, SQLException {
		
		List<AttendancesBean> attendancesList = new ArrayList<>();
		
		String sql = "SELECT employee_id, date, start_time, end_time, break_time, work_time, over_time FROM attendances";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			ResultSet res = pstmt.executeQuery();
			
			while (res.next()) {
				String employee_id = res.getString("employee_id");
				Date date = res.getDate("date");
				Time start_time = res.getTime("start_time");
				Time end_time = res.getTime("end_time");
				Time break_time = res.getTime("break_time");
				Time work_time = res.getTime("work_time");
				Time over_time = res.getTime("over_time");
				
				AttendancesBean todo = new AttendancesBean(employee_id, date, start_time, end_time, break_time, work_time, over_time);
				
				attendancesList.add(todo);
			}
			
		}
		return attendancesList;
		
	}
	
	public int registerAttendances(String employee_id, Date date, Time start_time, Time end_time, Time break_time, Time work_time, Time over_time)throws ClassNotFoundException, SQLException {
		int count = 0;
		
		String sql = "INSERT INTO attendances(employee_id, date, start_time, end_time, break_time, work_time, over_time) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setString(1, employee_id);
			
			pstmt.setDate(2, date);
			
			pstmt.setTime(3, start_time);
			
			pstmt.setTime(4, end_time);
			
			pstmt.setTime(5, break_time);
			
			pstmt.setTime(6, work_time);
			
			pstmt.setTime(7, over_time);
			
			count = pstmt.executeUpdate();
		}
		return count;
	}
	
	public AttendancesBean getAttendancesOne(String employee_id) throws ClassNotFoundException, SQLException {
		
		AttendancesBean attendances = null;
		
		String sql = "SELECT employee_id, date, start_time, end_time, break_time, work_time, over_time FROM attendances WHERE employee_id = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setString(1, employee_id);
			
			ResultSet res = pstmt.executeQuery();
			
			if (res.next()) {
				Date date = res.getDate("date");
				Time start_time = res.getTime("start_time");
				Time end_time = res.getTime("end_time");
				Time break_time = res.getTime("break_time");
				Time work_time = res.getTime("work_time");
				Time over_time = res.getTime("over_time");
				
				attendances = new AttendancesBean(employee_id, date, start_time, end_time, break_time, work_time, over_time);
			}
		}
		return attendances;
	}
	
	public int editAttendances(String employee_id, Date date, Time start_time, Time end_time, Time break_time, Time work_time, Time over_time) throws ClassNotFoundException, SQLException {
		
		int count = 0;
		
		String sql = "UPDATE attendances SET start_time = ?, end_time = ?, break_time = ?, work_time = ?, over_time = ? WHERE employee_id = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setTime(1,  start_time);
			
			pstmt.setTime(2,  end_time);
			
			pstmt.setTime(3,  break_time);
			
			pstmt.setTime(4,  work_time);
			
			pstmt.setTime(5,  over_time);
			
			pstmt.setString(6, employee_id);
			
			pstmt.setDate(7,  date);
			
			count = pstmt.executeUpdate();
		}
		return count;
	}
}
