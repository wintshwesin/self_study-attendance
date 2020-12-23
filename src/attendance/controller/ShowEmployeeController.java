package attendance.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import attendance.dao.EmployeeDao;

/**
 * Servlet implementation class ShowEmployeeController
 */
@WebServlet("/ShowEmployee")
public class ShowEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeDao employeeDao;

	public void init() {
		employeeDao = new EmployeeDao();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		/*System.out.println("Show Employee");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String employee_code = (String) session.getAttribute("employee_code");
		System.out.println("AAa" + employee_code);

		EmployeeBean employeeBean = EmployeeDao.getEmployeeInfo(employee_code);
		System.out.println(employeeBean);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee_info.jsp");
		dispatcher.forward(request, response);*/
	}

}
