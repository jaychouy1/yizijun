package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Tool;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class changedish extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField number;
	private JTextField price;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					changedish frame = new changedish();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public changedish(String fname,int fnumber,int fprice) {
		setTitle("\u83DC\u54C1\u4FEE\u6539\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 329);
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		name = new JTextField();
		name.setBounds(66, 42, 173, 24);
		contentPane.add(name);
		name.setColumns(10);

		number = new JTextField();
		number.setBounds(66, 111, 173, 24);
		contentPane.add(number);
		number.setColumns(10);

		price = new JTextField();
		price.setBounds(66, 173, 173, 24);
		contentPane.add(price);
		price.setColumns(10);

		
		name.setText(fname);
		String ffnumber =""+fnumber ;
		number.setText(ffnumber);
		String ffprice =""+fprice ;
		price.setText(ffprice);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String dname = name.getText();
				String dnumber = number.getText();
				String dprice = price.getText();

				Connection conn = null;
				PreparedStatement presta = null;
				ResultSet res = null;
				String sql = "update  [dbo].[dish] set name = ? ,number =?,price = ? where name = ?";
				String sql2 = "select * from [dbo].[dish] where name =?";

				try {
					conn = Tool.getConnection();
					presta = conn.prepareStatement(sql2);
					presta.setString(1, dname);
					// 先查询用户名是否存在

					res = presta.executeQuery();
					if (!dname.equals(fname)&&res.next()) {
						JOptionPane.showMessageDialog(null, "菜名存在，请重新输入！");
					} else {
						presta = conn.prepareStatement(sql);
						presta.setString(1, dname);
						presta.setString(2, dnumber);
						presta.setString(3, dprice);
						presta.setString(4, fname);
						presta.execute();
						JOptionPane.showMessageDialog(null, "修改成功！");
						cl();
						new MangerFrame().setVisible(true);//进入管理员页面
					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(283, 110, 113, 27);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("\u83DC\u540D");
		lblNewLabel.setBounds(14, 45, 58, 18);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\u5E93\u5B58");
		lblNewLabel_1.setBounds(14, 114, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\u4EF7\u683C");
		lblNewLabel_2.setBounds(14, 176, 72, 18);
		contentPane.add(lblNewLabel_2);

	}
	
	public void cl() {
		this.dispose();
	}
}
