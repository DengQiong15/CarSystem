package carsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame system;

	/**
	 * Launch the application.
	 */
	public void mainWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.system.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		system = new JFrame();
		system.getContentPane().setBackground(new Color(255, 255, 224));
		system.setTitle("\u6B22\u8FCE\u8FDB\u5165\u6C7D\u8F66\u552E\u7968\u7CFB\u7EDF");
		system.setBounds(100, 100, 450, 300);
		system.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		system.getContentPane().setLayout(null);
		system.setLocationRelativeTo(null);
		
		JLabel enter_Label = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u6C7D\u8F66\u552E\u7968\u7CFB\u7EDF");
		enter_Label.setForeground(new Color(0, 0, 0));
		enter_Label.setFont(new Font("ËÎÌו", Font.PLAIN, 30));
		enter_Label.setBounds(53, 36, 314, 46);
		system.getContentPane().add(enter_Label);
		
		JButton enter_Button = new JButton("\u70B9\u51FB\u767B\u5F55");
		enter_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Enter().enter();
				system.dispose();
			}
		});
		enter_Button.setBounds(152, 141, 111, 37);
		system.getContentPane().add(enter_Button);
	}
}
