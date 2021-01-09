package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import Dao.Deletedish;
import Dao.Tool;

import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;

public class MangerFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MangerFrame frame = new MangerFrame();
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
	private JButton btnNewButton;
	public MangerFrame() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 40, 432, 523);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(50, 1,4,4));
		scrollPane.setViewportView(panel);
		
		JLabel lblNewLabel = new JLabel(" \u83DC\u540D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 0, 89, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4EF7\u683C");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(158, 4, 75, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5E93\u5B58");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(316, 5, 81, 33);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton = new JButton("\u6DFB\u52A0\u83DC\u54C1");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MoreDish mds =new MoreDish();
				mds.run();
			}
		});
		btnNewButton.setBounds(154, 578, 113, 27);
		contentPane.add(btnNewButton);
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
		
		JMenuItem ac = new JMenuItem("修改");
		ac.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				System.out.println("修改");
				changedish chdish = new changedish(name,number,price);
				
				cl();				
			}
		});
		popuMenu.add(ac);
		
	
		
		JMenuItem de = new JMenuItem("删除");
		de.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				System.out.println("删除");
				
				try {
					Deletedish.dele(name);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					toadd();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		popuMenu.add(de);
		
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
