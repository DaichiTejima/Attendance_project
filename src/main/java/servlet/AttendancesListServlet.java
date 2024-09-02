package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.AttendancesDAO;
import model.entity.AttendancesBean;

/**
 * Servlet implementation class AttendancesListServlet
 */
@WebServlet("/attendances-list")
public class AttendancesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendancesListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<AttendancesBean> attendancesList = new ArrayList<>();
		
		
		
		AttendancesDAO dao = new AttendancesDAO();
		
		try {
			attendancesList = dao.getAttendancesList();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("attendancesList", attendancesList);
		
		RequestDispatcher rd = request.getRequestDispatcher("attendances-list.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<AttendancesBean> attendancesList = getAttendancesList();
		
		if (attendancesList == null) {
			attendancesList = new ArrayList<>();
		}
		// TODO Auto-generated method stub
		request.setAttribute("attendancesList", attendancesList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("attendances-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private List<AttendancesBean> getAttendancesList() {
		
		AttendancesDAO dao = new AttendancesDAO();
		List<AttendancesBean> attendancesList = new ArrayList<>();
		try {
			attendancesList = dao.getAttendancesList();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return attendancesList;
	}

}
