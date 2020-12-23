/* @author : WintShweSin
 * @version: 1.0
* EmployeeRegisterController
*/
package attendance.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import attendance.dao.EmployeeDao;
import attendance.model.EmployeeBean;

/**
 * Servlet implementation class EmployeeRegisterController
 */
@WebServlet("/EmployeeRegister")
public class EmployeeRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeDao employeeDao;

	public void init() {
		employeeDao = new EmployeeDao();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRegisterController() {
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
		System.out.println(action);
		String emp_code = request.getParameter("emp_code");
		System.out.println(emp_code);
		try {
			Boolean result = employeeDao.deleteEmployee(emp_code);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		response.sendRedirect("emp_code");


		/*try {
			List<DepartmentBean>listDepartment = EmployeeDao.getAllDepartments();
			System.out.println(listDepartment);
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("employee_register.jsp");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request,response);
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try {
			employee_register(request,response);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	private void employee_register(HttpServletRequest request, HttpServletResponse response) throws
	IOException, ServletException, ClassNotFoundException {
		String employee_code = request.getParameter("employee_code");
		String employee_name = request.getParameter("employee_name");
		String password = request.getParameter("password");
		String department_code = request.getParameter("department_code");
		String position_code = request.getParameter("position_code");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		char gender = request.getParameter("gender").charAt(0);
		String salary_grade_id = request.getParameter("salary_grade_id");
		String admin_permission = request.getParameter("admin_permission");

		Timestamp currentTime = new Timestamp(System.currentTimeMillis());

		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_code(employee_code);
		employeeBean.setEmployee_name(employee_name);
		employeeBean.setPassword(password);
		employeeBean.setDepartment_code(department_code);
		employeeBean.setPosition_code(position_code);
		employeeBean.setPassword(password);
		employeeBean.setTelephone(telephone);
		employeeBean.setCreated(currentTime);
		employeeBean.setEmail(email);
		employeeBean.setAddress(address);
		employeeBean.setGender(gender);
		employeeBean.setSalary_grade_id(salary_grade_id);
		employeeBean.setAdmin_permission(admin_permission);

		Validation validation = new Validation();
		List<String> errors = validation.validate(employeeBean);

		if(errors.isEmpty()) {
			try {
				int result = employeeDao.registerEmployee(employeeBean);
				if(result == 1) {
					request.setAttribute("noti", "Employee Registered Successful!");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("employee_register.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("errors", errors);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee_register.jsp");
			dispatcher.forward(request, response);
		}
	}

}
