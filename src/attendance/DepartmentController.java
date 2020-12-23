package attendance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepartmentController
 */
@WebServlet("/DepartmentController")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		//リクエストデータのエンコーディング
		request.setCharacterEncoding("UTF-8");
		//private static Connection con = null;
		System.out.println("Department Servlet Get Method");



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try
        {
             Class.forName("org.postgresql.Driver");
             Connection con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/attendance","postgres","admin");
             String sql = "select * from department";
             PreparedStatement ps = con.prepareStatement(sql);
             System.out.println("connection established successfully...!!");


        }
        catch (Exception e){
            e.printStackTrace();
        }
		System.out.println("Department Servlet Post Method");
	}

}
