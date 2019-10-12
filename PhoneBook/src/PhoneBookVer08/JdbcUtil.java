package PhoneBookVer08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class JdbcUtil {
	static {
		// 클래스가 로딩될때 단 한번 호출
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// mysql 드라이버 로딩..
			// 드라이버가 메모리에 로딩되어야  해당  DBMS로 연결이 가능함
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		// DB작업에 필요한  Connection 객체를 생성해 주는 메소드
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java?useUnicode=true&characterEncoding=UTF-8","root","");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
