package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Dao.Tool;
import service.loginservice;

public class test {
	public static void addSJ() throws SQLException {//���ӳɼ�
        Connection conn = null ;
        PreparedStatement presta  = null;
        //DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
        String sql="insert into dish(name,number,price) values(?,?,?)";//ʹ��ռλ������������
        try {
			conn=Tool.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//��ȡ���ݿ��
             PreparedStatement pstmt =conn.prepareStatement(sql); //ʵ����PreparedStatemen
           //String
                
                   
                    
                    pstmt.setString(1, "");//�����1��ռλ��������
                    pstmt.setString(2, "");
                    pstmt.setString(3, "���һ��");
                   
                    pstmt.addBatch();//����������ȴ�ִ��
                    //ѧ��Ψһ��ѭ����������ִ��
                
            
            pstmt.executeBatch();//����ִ�в������
            JOptionPane.showMessageDialog(null, "sucess");
       } //catch (SQLException e) {
//            e.printStackTrace();
//        }
	
}
