package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Tool {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// ����SQLServer�����ݿ���������
		 String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
		// ����SQLServer���ݿ�����ӵ�ַ
		 String DBURL = "jdbc:sqlserver://localhost:1433;DatabaseName=restaurant" ;
		// SQL���ݿ�������û���
		 String DBUSER = "sa" ;
		// MySQL���ݿ����������
		 String DBPASS = "123456" ;
		Connection conn = null ;			// ���ݿ�����
		Class.forName(DBDRIVER) ;			// ���������������쳣
		// ����MySQL���ݿ�ʱ��Ҫд�����ӵ��û��������룬���쳣
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS); // ���쳣
		//System.out.println(conn);
		return conn;
//		public static void main(String[] args) {
//			Connection conn = null ;			// ���ݿ�����
//			Class.forName(DBDRIVER) ;			// ���������������쳣
//			// ����MySQL���ݿ�ʱ��Ҫд�����ӵ��û��������룬���쳣
//			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS); // ���쳣
//			System.out.println(conn) ;
//			conn.close() ;					// ���ݿ�رգ����쳣
//		}
	}

	


}
