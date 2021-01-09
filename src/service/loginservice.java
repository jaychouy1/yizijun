package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.Tool;

public class loginservice {
	/**
	 *	 接收前端传过来的账号密码
	 *      进入数据库查询结果
	 * 1 普通用户登录，密码正确
	 * 2 管理员登录，密码正确
	 * 0 密码错误
	 * -1 用户不存在
	 * @param id
	 * @param password
	 * @return 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static int verid(String id,String password) throws ClassNotFoundException, SQLException {
		
		int flag = 0;
		System.out.println("id:"+id+"\npassword:"+password);
			
		
		Connection conn = null ;
		PreparedStatement  presta  = null;
		ResultSet  res  = null;
		
		String sql="select * from [dbo].[User] where name = ? " ;
		conn = Tool.getConnection();
		presta= conn.prepareStatement(sql);
		//给？赋值
		presta.setString(1,id);//参数是？的位置+？的内容
		res = presta.executeQuery();
		
		if(!res.next()) {
			flag=-1;
		}else 
		{
			String pwd = res.getString("password");
			System.out.println("pwd:"+pwd);
			
			if(password.equals(pwd)) 
			{
				flag=1;
			}
			else 
			{
				flag=0;
			}
		}
		return flag;
	}


}
