package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Tool {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// 定义SQLServer的数据库驱动程序
		 String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
		// 定义SQLServer数据库的连接地址
		 String DBURL = "jdbc:sqlserver://localhost:1433;DatabaseName=restaurant" ;
		// SQL数据库的连接用户名
		 String DBUSER = "sa" ;
		// MySQL数据库的连接密码
		 String DBPASS = "123456" ;
		Connection conn = null ;			// 数据库连接
		Class.forName(DBDRIVER) ;			// 加载驱动程序，有异常
		// 连接MySQL数据库时，要写上连接的用户名和密码，有异常
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS); // 有异常
		//System.out.println(conn);
		return conn;
//		public static void main(String[] args) {
//			Connection conn = null ;			// 数据库连接
//			Class.forName(DBDRIVER) ;			// 加载驱动程序，有异常
//			// 连接MySQL数据库时，要写上连接的用户名和密码，有异常
//			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS); // 有异常
//			System.out.println(conn) ;
//			conn.close() ;					// 数据库关闭，有异常
//		}
	}

	


}
