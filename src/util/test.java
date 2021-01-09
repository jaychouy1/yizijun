package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Dao.Tool;
import service.loginservice;

public class test {
	public static void addSJ() throws SQLException {//增加成绩
        Connection conn = null ;
        PreparedStatement presta  = null;
        //DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
        String sql="insert into dish(name,number,price) values(?,?,?)";//使用占位符定义插入语句
        try {
			conn=Tool.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//获取数据库接
             PreparedStatement pstmt =conn.prepareStatement(sql); //实例化PreparedStatemen
           //String
                
                   
                    
                    pstmt.setString(1, "");//定义第1个占位符的内容
                    pstmt.setString(2, "");
                    pstmt.setString(3, "软件一班");
                   
                    pstmt.addBatch();//加入批处理等待执行
                    //学号唯一，循环继续往下执行
                
            
            pstmt.executeBatch();//批量执行插入操作
            JOptionPane.showMessageDialog(null, "sucess");
       } //catch (SQLException e) {
//            e.printStackTrace();
//        }
	
}
