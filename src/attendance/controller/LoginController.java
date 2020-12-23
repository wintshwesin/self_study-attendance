/*
 *@author : WintShweSin
 *@version: 1.0
 *LoginController
 */
package attendance.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import attendance.dao.LoginDao;
import attendance.model.EmployeeBean;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		loginDao = new LoginDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");

		authenticate(request, response);

	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		String employee_code = request.getParameter("employee_code");
		String password = request.getParameter("password");
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_code(employee_code);
		employeeBean.setPassword(password);

		try {
			if (loginDao.validate(employeeBean)) {
				System.out.println("Show Time Cart");
				HttpSession session = request.getSession();
				session.setAttribute("employee_code", employee_code);
				RequestDispatcher dispatcher = request.getRequestDispatcher("timecard.jsp");
				dispatcher.forward(request, response);
			} else {
				//HttpSession session = request.getSession();
				request.setAttribute("error", "入力した従業員番号とパスワードが一致していません!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
