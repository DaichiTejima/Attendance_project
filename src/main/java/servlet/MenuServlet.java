package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmployeesDAO;
import model.entity.EmployeesBean;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		EmployeesDAO dao = new EmployeesDAO();
		List<EmployeesBean>  employeesList = null;
		
		try {
			String employee_id = request.getParameter("employee_id");
			String password = request.getParameter("password");
			if (employee_id != null && password != null) {
				employeesList = dao.getEmployees(employee_id, password);
			} else {
				employeesList = new ArrayList<>();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new ServletException(e);
		}
		
		request.setAttribute("menu", employeesList);
		
		RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
		rd.forward(request,  response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
