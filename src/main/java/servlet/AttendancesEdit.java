package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.AttendancesDAO;
import model.entity.AttendancesBean;

/**
 * Servlet implementation class AttendancesEdit
 */
@WebServlet("/attendances-edit")
public class AttendancesEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendancesEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String employee_id = request.getParameter("employee_id");
		
		AttendancesBean attendances = null;
		
		AttendancesDAO dao = new AttendancesDAO();
		
		try {
			attendances = dao.getAttendancesOne(employee_id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (attendances != null) {
		} else {
		request.setAttribute("attendances", attendances);
		RequestDispatcher rd = request.getRequestDispatcher("attendances-edit.jsp");
		rd.forward(request, response);
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String employee_id = request.getParameter("employee_id");
		String dateStr = request.getParameter("date");
		
		Date date = null;
		try {
			if (dateStr != null && !dateStr.isEmpty()) {
				date = Date.valueOf(dateStr);
			} else {
				throw new IllegalArgumentException("");
			}
		} catch (IllegalArgumentException e) {
			
		}
		
		Time start_time = parseTime(request.getParameter("start_time"));
		Time end_time = parseTime(request.getParameter("end_time"));
		Time break_time = parseTime(request.getParameter("break_time"));
		Time work_time = parseTime(request.getParameter("work_time"));
		Time over_time = parseTime(request.getParameter("over_time"));
		
		
		AttendancesDAO dao = new AttendancesDAO();
		
		try {
			dao.editAttendances(employee_id, date, start_time, end_time, break_time, work_time, over_time);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("attendances-list.jsp");
		rd.forward(request, response);
	}
	private Time parseTime(String timeStr) {
		if (timeStr != null && !timeStr.isEmpty()) {
			try {
				return Time.valueOf(timeStr);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
