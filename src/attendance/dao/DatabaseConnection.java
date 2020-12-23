/*
 *@author : WintShweSin
 *@version: 1.0
 *データベースに接続
 *@return：コネクション
 */

package attendance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	//PostgreSQL宣言
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://127.0.0.1:5432/attendance";
    private static final String DBUSER = "postgres";
    private static final String DBPASSWORD = "admin";

    private static Connection conn = null;

    public static Connection getConnection() {
		if(conn == null) {
			try {
				//ドライバーロード
				//Class.forName(DRIVER);

				//コネクションクラスを取得
				conn = DriverManager.getConnection(URL, DBUSER, DBPASSWORD);
				if (conn != null) {
	                System.out.println("Connected to the PostgreSQL ********** server successfully.");
	            } else {
	                System.out.println("Failed to make connection!");
	            }
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;

    }


}
