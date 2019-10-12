package PhoneBookVer08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class JdbcUtil {
	static {
		// Ŭ������ �ε��ɶ� �� �ѹ� ȣ��
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// mysql ����̹� �ε�..
			// ����̹��� �޸𸮿� �ε��Ǿ��  �ش�  DBMS�� ������ ������
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		// DB�۾��� �ʿ���  Connection ��ü�� ������ �ִ� �޼ҵ�
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
