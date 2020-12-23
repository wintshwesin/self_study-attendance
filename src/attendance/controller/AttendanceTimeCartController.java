package attendance.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import attendance.dao.AttendanceEmployeeDao;

/**
 * Servlet implementation class AttendanceTimeCartController
 */
@WebServlet("/AttendanceTimeCart")
public class AttendanceTimeCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendanceTimeCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("employee_code") == null) {
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("timecard.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String employee_code = (String) session.getAttribute("employee_code");
		//どのボタンが押されたかをチェック
		String attendance = request.getParameter("attendance");
		System.out.println(attendance);
		AttendanceEmployeeDao attendEmpDao = AttendanceEmployeeDao.getInstance();

		boolean Flag = false;
		try {
			if (attendance.equals("出勤処理")) {
				Flag = attendEmpDao.setStartTime(employee_code);
				} else if (attendance.equals("退勤処理")) {
					Flag = attendEmpDao.setEndTime(employee_code);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (Flag) {
			session.setAttribute("attendance", attendance);
			response.sendRedirect("time_card.jsp");
		} else {
			response.sendRedirect("time_card.jsp");
		}
	}

}
