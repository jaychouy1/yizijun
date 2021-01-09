package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.Tool;
import bean.User;

public class GetUserMessage {

	public  static User  getUser(String uid) throws ClassNotFoundException, SQLException {
		User user = null;
		Connection conn = null ;
		PreparedStatement  presta  = null;
		ResultSet  res  = null;
		
		String sql="select * from [dbo].[User] where id = ? " ;
		conn = Tool.getConnection();
		presta= conn.prepareStatement(sql);
		//给？赋值
		presta.setString(1,uid);//参数是？的位置+？的内容
		res = presta.executeQuery();
		res.next();
		String name = res.getString("name");
		String id = res.getString("id");
//		user.setId(id);
//		user.setName(name);
		return user;
		
	}
}
