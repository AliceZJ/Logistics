package unit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
	private static Connection conn = null;

	private db() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/juanjuan", "root", "mysql");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		if (null == conn) {
			new db();
		}
		return conn;
	}

}
