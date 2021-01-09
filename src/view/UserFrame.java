package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import Dao.Deletedish;
import Dao.Tool;
import Dao.addhistory;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Label;

public class UserFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame("123");
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
	private JLabel lblNewLabel_2;
	String username = null;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	public UserFrame(String username) throws ClassNotFoundException, SQLException {
		this.username = username;
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setTitle("\u70B9\u9910\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 507);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel2 = new JPanel();
		panel2.setVisible(false);
		
		// 首页
		JButton btnNewButton = new JButton("\u9996\u9875");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		btnNewButton.setBounds(0, 430, 144, 27);
		contentPane.add(btnNewButton);

		// 订单
		JButton btnNewButton_2 = new JButton("\u6211\u7684\u8BA2\u5355");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					historyframe his = new historyframe(username);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(288, 430, 144, 27);
		contentPane.add(btnNewButton_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 34, 432, 395);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(50, 1,4,4));
		scrollPane.setViewportView(panel);
		
		lblNewLabel = new JLabel("\u83DC\u540D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(14, 0, 72, 31);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\u4EF7\u683C");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(163, 0, 92, 31);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\u5E93\u5B58");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(337, 1, 81, 28);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton_3 = new JButton("\u83DC\u54C1\u8BC4\u8BBA\u533A");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DishComment();
			}
		});
		btnNewButton_3.setBounds(142, 430, 144, 27);
		contentPane.add(btnNewButton_3);
		
		
		
		toadd();
	}
	
	public void toadd() throws ClassNotFoundException, SQLException {
		
		
		Connection conn = null ;
		PreparedStatement  presta  = null;
		ResultSet  res  = null;
		panel.removeAll();
		String sql="select * from [dbo].[dish]" ;
		conn = Tool.getConnection();
		presta= conn.prepareStatement(sql);
		res = presta.executeQuery();
		while(res.next()){
			String name = res.getString("name");
			int price = res.getInt("price");
			int number = res.getInt("number");
			adddish(name,price,number);
		}
	}
	public void adddish(String name,int price,int number) {
		JLabel jlabel11 = new JLabel(" "+name+"              "+price+"              "+number);
		jlabel11.setFont(new Font("宋体", Font.PLAIN, 20));
		JPopupMenu popuMenu = new JPopupMenu();
		
		JMenuItem ac = new JMenuItem("购买");
		ac.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				System.out.println("购买");
				System.out.println(username+"88888");
				addhistory.adddish(name, username,price);
				JOptionPane.showMessageDialog(null, "购买成功");
		
			}
		});
		popuMenu.add(ac);
		
		jlabel11.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				popuMenu.show(jlabel11,e.getX(),e.getY());
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
				
			}

			@Override//鼠标碰到变蓝
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				JLabel jl=(JLabel)e.getSource();
				jl.setForeground(Color.blue);
			}

			@Override//鼠标离开变黑
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				JLabel jl=(JLabel)e.getSource();
				jl.setForeground(Color.black);
			}
		});
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
