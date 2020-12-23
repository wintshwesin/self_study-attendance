/*
 *@author : WintShweSin
 *@version: 1.0
 *LoginDao
 */
package attendance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import attendance.model.EmployeeBean;

public class LoginDao {

	public boolean validate(EmployeeBean employeeBean) throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		Connection conn = DatabaseConnection.getConnection();
		boolean status = false;
		String sql = "SELECT * FROM employee where employee_code = ? and password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employeeBean.getEmployee_code());
			ps.setString(2, employeeBean.getPassword());
			ResultSet rs = ps.executeQuery();
			status = rs.next();

		}catch(SQLException e) {
			System.out.println("Error");
			Message.printSQLException(e);
		}
		return status;

	}

	public boolean admin_validate(EmployeeBean employeeBean) throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		Connection conn = DatabaseConnection.getConnection();
		boolean status = false;
		//String sql = "SELECT * FROM employee where employee_code = ? and password = ? and admin_permission = ?";
		String sql = "SELECT * FROM employee where employee_code = ? and password = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employeeBean.getEmployee_code());
			ps.setString(2, employeeBean.getPassword());
			//ps.setString(3, String.valueOf(employeeBean.getAdmin_permission()));
			ResultSet rs = ps.executeQuery();
			status = rs.next();

		}catch(SQLException e) {
			System.out.println("Error");
			Message.printSQLException(e);
		}
		return status;

	}
}


