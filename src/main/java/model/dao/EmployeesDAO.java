package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.EmployeesBean;

public class EmployeesDAO {
	
	public List<EmployeesBean> getEmployees(String employee_id, String password) throws ClassNotFoundException, SQLException {
		
		List<EmployeesBean> employeesList = new ArrayList<>();
		
		String sql = "SELECT employee_id, password, name, age FROM employees WHERE employee_id = ? AND password = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setString(1, employee_id);
			pstmt.setString(2, password);
			
			ResultSet res = pstmt.executeQuery();
			
			if (res.next()) {
				String employeeId = res.getString("employee_id");
				String passWord = res.getString("password");
				String name = res.getString("name");
				int age = res.getInt("age");
				
				EmployeesBean employees = new EmployeesBean(employeeId, passWord, name, age);
				
				employeesList.add(employees);
			}
		}
		return employeesList;
	}
	
	public int registerEmployees(String employee_id, String password, String name, int age) throws ClassNotFoundException, SQLException {
		int count = 0;
		
		String sql = "INSERT INTO employees(employee_id, password, name, age) VALUES(?, ?, ?, ?)";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setString(1, employee_id);
			
			pstmt.setString(2, password);
			
			pstmt.setString(3, name);
			
			pstmt.setInt(4, age);
			
			count = pstmt.executeUpdate();
		}
		return count;
	}

}
 