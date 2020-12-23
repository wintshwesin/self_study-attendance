/*
 *@author : WintShweSin
 *@version: 1.0
 *EmployeeDao
 */

package attendance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import attendance.model.DepartmentBean;
import attendance.model.EmployeeBean;

public class EmployeeDao {

	public int registerEmployee(EmployeeBean employeeBean) throws ClassNotFoundException {

		System.out.println("DAO");
		String sql = "INSERT INTO employee"
				+ "  (employee_code,employee_name,department_code,position_code,gender,salary_grade_id,"
				+ "telephone,address,email,password,admin_permission,created,updated)  "
				+ " VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		int result = 0;
		Class.forName("org.postgresql.Driver");
		try {

			Connection conn = DatabaseConnection.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employeeBean.getEmployee_code());
			ps.setString(2, employeeBean.getEmployee_name());
			ps.setString(3, employeeBean.getDepartment_code());
			ps.setString(4, employeeBean.getPosition_code());
			ps.setString(5, String.valueOf(employeeBean.getGender()));
			ps.setString(6, employeeBean.getSalary_grade_id());
			ps.setString(7, employeeBean.getTelephone());
			ps.setString(8, employeeBean.getAddress());
			ps.setString(9, employeeBean.getEmail());
			ps.setString(10, employeeBean.getPassword());
			ps.setString(11, employeeBean.getAdmin_permission());
			ps.setTimestamp(12, employeeBean.getCreated());
			ps.setTimestamp(13, employeeBean.getUpdated());
			result = ps.executeUpdate();

			if (result != 0) {
				System.out.println("新規登録成功しました。");
			} else {
				System.out.println("新規登録失敗しました。");
			}

			//conn.close();

		} catch (SQLException e) {
			System.out.println("Error");
			Message.printSQLException(e);

		}

		return result;
	}

	public static List<DepartmentBean> getAllDepartments() throws SQLException {
		List<DepartmentBean> listDepartment = new ArrayList<DepartmentBean>();
		String sql = "SELECT department_code, department_name FROM department";

		Connection conn = DatabaseConnection.getConnection();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				DepartmentBean departmentBean = new DepartmentBean();
				departmentBean.setDepartment_code(rs.getString(1));
				departmentBean.setDepartment_name(rs.getString(2));
				listDepartment.add(departmentBean);
			}
			/*rs.close();
			s.close();*/

		} catch (SQLException e) {
			System.out.println("Error");
			Message.printSQLException(e);
		}
		return listDepartment;
	}

	/*public static List<Emp> getRecords(int start,int total){
	    List<Emp> list=new ArrayList<Emp>();
	    try{
	        Connection con=getConnection();
	        PreparedStatement ps=con.prepareStatement("select * from emp_management limit "+(start-1)+","+total);
	        ResultSet rs=ps.executeQuery();
	        while(rs.next()){
	            Emp e=new Emp();
	            e.setId(rs.getInt(1));
	            e.setName(rs.getString(2));
	            e.setEmail(rs.getString(4));
	            list.add(e);
	        }
	        con.close();
	    }catch(Exception e){System.out.println(e);}
	    return list;
	}*/

	public List<EmployeeBean> listAllEmployees() throws SQLException {
		List<EmployeeBean> employeeList = new ArrayList<>();

		String sql = "SELECT * FROM employee";

		Connection conn = DatabaseConnection.getConnection();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);

			/*while (rs.next()) {
				EmployeeBean emp_bean= new EmployeeBean();
				emp_bean.setEmployee_code(rs.getString(1));
				emp_bean.setEmployee_name(rs.getString(2));
				employeeList.add(emp_bean);
			}*/
			while (rs.next()) {
				String emp_code = rs.getString("employee_code");
				String emp_name = rs.getString("employee_name");

				EmployeeBean employeeBean = new EmployeeBean(emp_code, emp_name);
				employeeList.add(employeeBean);
			}
			/*rs.close();
			s.close();
			conn.close();*/
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeList;
	}

	public boolean deleteEmployee(String employee_code) throws SQLException {
		boolean isrowDeleted = false;
		System.out.println("DDDDDDDDDDDDD");
		String sql = "DELETE  FROM employee where employee_code = ?";
		Connection conn = DatabaseConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee_code);
			isrowDeleted = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isrowDeleted;
	}

	/*public static EmployeeBean getEmployeeInfo(String employee_code) {
		EmployeeBean employeeBean = new EmployeeBean();
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from employee where employee_code=?");
			ps.setString(1,employee_code);
	        ResultSet rs=ps.executeQuery();
	        if(rs.next()){
	        	employeeBean.setEmployee_code(rs.getString(1));
	            employeeBean.setEmployee_name(rs.getString(2));
	        }

	       // conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return employeeBean;
	}*/

}
