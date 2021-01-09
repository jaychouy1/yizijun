package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class shopcar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shopcar frame = new shopcar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	JPanel panel;
	JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	public shopcar() {
		setTitle("\u8D2D\u7269\u8F66");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 44, 432, 394);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(50, 1,4,4));
		scrollPane.setViewportView(panel);
		
		lblNewLabel = new JLabel("\u5408\u8BA1\u91D1\u989D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 442, 120, 40);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("12");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(121, 451, 85, 24);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.setBounds(305, 474, 113, 27);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("\u83DC\u540D");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(32, 7, 58, 24);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\u4EF7\u683C");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(176, 7, 65, 24);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("\u6570\u91CF");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_4.setBounds(315, 7, 79, 24);
		contentPane.add(lblNewLabel_4);
		
	}

	
}
