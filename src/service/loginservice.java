package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.Tool;

public class loginservice {
	/**
	 *	 ����ǰ�˴��������˺�����
	 *      �������ݿ��ѯ���
	 * 1 ��ͨ�û���¼��������ȷ
	 * 2 ����Ա��¼��������ȷ
	 * 0 �������
	 * -1 �û�������
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
		//������ֵ
		presta.setString(1,id);//�����ǣ���λ��+��������
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
