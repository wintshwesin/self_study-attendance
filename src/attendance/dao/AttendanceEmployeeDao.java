package attendance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AttendanceEmployeeDao {
	private static AttendanceEmployeeDao emp_timecard = new AttendanceEmployeeDao();

	DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDateTime now = LocalDateTime.now();
	Timestamp currentTime = new Timestamp(System.currentTimeMillis());

	private AttendanceEmployeeDao() {
	}

	public static AttendanceEmployeeDao getInstance() {
		return emp_timecard;
	}

	public boolean setStartTime(String employee_code) throws SQLException {
		Connection conn = DatabaseConnection.getConnection();



		String sql = "SELECT * from attendance WHERE employee_code = '" + employee_code
				+ "' and working_date = '" + currentTime + "';";
		PreparedStatement ps = conn.prepareStatement(sql);
		Statement s = conn.createStatement();
		System.out.println("AAAAAAAAAAAAAAAAa");
		ResultSet rs = s.executeQuery(sql);
		if(rs.next()) {
			return false;
		} else {
			System.out.println("BBBBBBBBBBBBBBBBBBBB");
			Timestamp created = new Timestamp(System.currentTimeMillis());
			sql = "INSERT INTO attendance (employee_code, working_date, start_time) VALUES ('"
			+ employee_code + "', '" + now.format(dateFormat) + "', '"
			+ now.format(timeFormat) + "' );";

			s.executeUpdate(sql);

			return true;
		}
	}


	public boolean setEndTime(String employee_code) throws SQLException {
		Connection conn = DatabaseConnection.getConnection();

		//出勤が押されていなかったらfalseを返す
		String sql = "SELECT * from t_work_time WHERE employee_code = '" + employee_code
				+ "' and work_date = '" + now.format(dateFormat) + "';";
		PreparedStatement ps = conn.prepareStatement(sql);
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		if(!rs.next()) {
			return false;
		} else {
			sql = "UPDATE attendance SET end_time = '" + now.format(timeFormat)
					+ "' WHERE employee_code = '" + employee_code + "' and working_date = '" + now.format(dateFormat) + "';";
			s.executeUpdate(sql);

			return true;
		}
	}



}
