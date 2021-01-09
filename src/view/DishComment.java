package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class DishComment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DishComment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 49, 432, 318);
		contentPane.add(textArea);

		JLabel lblNewLabel = new JLabel("\u8BC4\u8BBA\u533A");
		lblNewLabel.setBounds(151, 13, 150, 34);
		contentPane.add(lblNewLabel);
		File file = new File("D:\\Javaaa\\pinlun.txt");
		setVisible(true);
		FileReader fr = null;// 创建字符输入流
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		int n = 0;
		String input = null;
		String center = null;

		while (true) {
			try {
				if ((center= (br.readLine())) != null) {
					input+=center+"\r\n";
					textArea.setText(input);
					continue;
				}else {
					break;
				}
					

			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
