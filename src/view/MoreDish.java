package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MoreDish extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField price;
	private JTextField sum;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			MoreDish frame = new MoreDish();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public MoreDish() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u83DC\u540D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel.setBounds(38, 13, 72, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4EF7\u683C");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(34, 118, 96, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5E93\u5B58");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(38, 223, 87, 26);
		contentPane.add(lblNewLabel_2);
		
		name = new JTextField();
		name.setBounds(144, 18, 233, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		price = new JTextField();
		price.setBounds(144, 123, 233, 24);
		contentPane.add(price);
		price.setColumns(10);
		
		sum = new JTextField();
		sum.setBounds(144, 228, 233, 24);
		contentPane.add(sum);
		sum.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String fname=name.getText();
				int fprice=Integer.valueOf(price.getText());
				int fsum=Integer.valueOf(sum.getText());
				String sql="insert into dish(name,number,price) values(?,?,?)";
				String sql2="select * from dish where name=?";
				Connection conn=null;
				PreparedStatement  presta  = null;
				ResultSet  res  = null;
				try {
					conn = Tool.getConnection();
					presta= conn.prepareStatement(sql2);
					presta.setString(1, fname);
					//先查询菜名是否存在
				
				res = presta.executeQuery();
				if(res.next()) {
					JOptionPane.showMessageDialog(null, "菜名存在，请重新输入！");
				}else {
				    presta=conn.prepareStatement(sql);
					presta.setString(1, fname);
					presta.setInt(2, fprice);
					presta.setInt(3, fsum);
					presta.execute();
					JOptionPane.showMessageDialog(null, "添加成功");
	                } 
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			}
		});
		btnNewButton.setBounds(320, 318, 113, 27);
		contentPane.add(btnNewButton);
	}

}
