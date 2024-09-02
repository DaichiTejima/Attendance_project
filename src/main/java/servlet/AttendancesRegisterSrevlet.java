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
/**
 * Servlet implementation class AttendancesRegisterSrevlet
 */
@WebServlet("/attendances-register")
public class AttendancesRegisterSrevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendancesRegisterSrevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("attendances-register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		String employee_id = request.getParameter("employee_id");
		
		Date date = Date.valueOf(request.getParameter("date"));
		
		String start_timeString = request.getParameter("start_time");
		if (start_timeString.length() == 5) {
		    start_timeString += ":00";
		}
		Time start_time = Time.valueOf(start_timeString);
		
		String end_timeString = request.getParameter("end_time");
		if (end_timeString.length() == 5) {
		    end_timeString += ":00"; 
		}
		Time end_time = Time.valueOf(end_timeString);
		
		String break_timeString = request.getParameter("break_time");
		if (break_timeString.length() == 5) {
		    break_timeString += ":00";
		}
		Time break_time = Time.valueOf(break_timeString);

		String work_timeString = request.getParameter("work_time");
		if (work_timeString.length() == 5) {
		    work_timeString += ":00";
		}
		Time work_time = Time.valueOf(work_timeString);
		
		String over_timeString = request.getParameter("over_time");
		if (over_timeString.length() == 5) {
		    over_timeString += ":00";
		}
		Time over_time = Time.valueOf(over_timeString);
		
		AttendancesDAO dao = new AttendancesDAO();
		
		try {
			dao.registerAttendances(employee_id, date, start_time, end_time, break_time, work_time, over_time);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
		rd.forward(request, response);
	}

}
