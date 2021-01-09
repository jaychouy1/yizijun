package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Dao.Tool;
import Dao.addhistory;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;

public class historyframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					historyframe frame = new historyframe("123");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	JPanel panel;
	JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	String username = null;
	public historyframe(String username) throws ClassNotFoundException, SQLException {
		this.username = username;
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  
		setTitle("\u5386\u53F2\u8BA2\u5355");
		setBounds(100, 100, 450, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 46, 432, 502);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(50, 1,4,4));
		scrollPane.setViewportView(panel);
		
		lblNewLabel = new JLabel("\u83DC\u540D");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 25));
		lblNewLabel.setBounds(56, 0, 72, 43);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\u8D39\u7528");
		lblNewLabel_1.setFont(new Font("ËÎÌו", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(291, 0, 84, 43);
		contentPane.add(lblNewLabel_1);
		toadd();
	}
	public void toadd() throws ClassNotFoundException, SQLException {
		
		
		Connection conn = null ;
		PreparedStatement  presta  = null;
		ResultSet  res  = null;
		panel.removeAll();
		String sql="select * from [dbo].[history] where username = ?" ;
		
		conn = Tool.getConnection();
		presta= conn.prepareStatement(sql);presta.setString(1, username);
		res = presta.executeQuery();
		while(res.next()){
			String name = res.getString("name");
			int price = res.getInt("price");
			adddish(name,price);
		}
	}
	public void adddish(String name,int price) {
		JLabel jlabel11 = new JLabel(" "+name+"                         "+price);
		jlabel11.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		panel.add(jlabel11);
		
		panel.setVisible(false);
		scrollPane.setVisible(false);
		panel.repaint();
		panel.setVisible(true);
		scrollPane.setVisible(true);
	}
	public void cl() {
		this.dispose();
	}

}
