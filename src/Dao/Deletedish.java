package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Deletedish {

	public static void dele(String name) throws ClassNotFoundException, SQLException {
		Connection conn = null ;
		PreparedStatement  presta  = null;
		ResultSet  res  = null;
		String sql="delete [dbo].[dish] where name = ?" ;
		
		conn = Tool.getConnection();
		presta= conn.prepareStatement(sql);
		presta.setString(1, name);
		presta.execute();
	}
}
