package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class addhistory {

	
	public static void adddish(String name, String username,int price) {
		Connection conn = null;
		PreparedStatement presta = null;
		ResultSet res = null;
		String sql = "insert into [dbo].[history] VALUES(?,?,?)";
		try {
			conn = Tool.getConnection();
			presta = conn.prepareStatement(sql);
			presta.setString(1, name);
			presta.setString(2, username);
			presta.setInt(3, price);
			presta.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
