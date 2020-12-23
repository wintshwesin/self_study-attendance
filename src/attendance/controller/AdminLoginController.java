/*
 *@author : WintShweSin
 *@version: 1.0
 *AdminLoginController
 */

package attendance.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import attendance.dao.EmployeeDao;
import attendance.dao.LoginDao;
import attendance.model.EmployeeBean;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLogin")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;
	private EmployeeDao employeeDao;



	public void init() {
		loginDao = new LoginDao();
		employeeDao = new EmployeeDao();
	}

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();

		try {
			switch (action) {
			/*case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertTodo(request, response);
				break;*/
			case "/delete":
				deleteEmployee(request, response);
				break;
			/*case "/edit":
				showEmployee(request, response);
				break;*/
			/*case "/update":
				updateTodo(request, response);
				break;
			case "/list":
				listTodo(request, response);
				break;*/
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin_login.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		adminauthenticate(request, response);
	}

	private void adminauthenticate(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		String employee_code = request.getParameter("employee_code");
		String password = request.getParameter("password");
		//char permission = request.getParameter("permission").charAt(0);
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_code(employee_code);
		employeeBean.setPassword(password);
		//employeeBean.setAdmin_permission(permission);

			try {
				if (loginDao.admin_validate(employeeBean)) {
					HttpSession session = request.getSession();
					session.setAttribute("employee_code", employee_code);

					List<EmployeeBean> listemployees = employeeDao.listAllEmployees();
					request.setAttribute("listemployees", listemployees);

					RequestDispatcher dispatcher = request.getRequestDispatcher("admin_management.jsp");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("error", "入力した管理者番号とパスワードが一致していません!");
					RequestDispatcher dispatcher = request.getRequestDispatcher("admin_login.jsp");
					dispatcher.include(request, response);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String employee_code = request.getParameter("employee_code");
		employeeDao.deleteEmployee(employee_code);
		response.sendRedirect("list");
	}

	}



