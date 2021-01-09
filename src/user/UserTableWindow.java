package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import DBC.TicketInformation;
import carsystem.MainWindow;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserTableWindow {

	private JFrame user_table;

	/**
	 * Launch the application.
	 */
	public void userTableWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserTableWindow window = new UserTableWindow();
					window.user_table.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserTableWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		user_table = new JFrame();
		user_table.getContentPane().setBackground(new Color(255, 255, 224));
		user_table.getContentPane().setForeground(new Color(255, 255, 224));
		user_table.setTitle("\u6B22\u8FCE\u8FDB\u5165\u6C7D\u8F66\u552E\u7968\u7CFB\u7EDF\u7528\u6237\u754C\u9762");
		user_table.setBounds(100, 100, 436, 423);
		user_table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		user_table.getContentPane().setLayout(null);
		user_table.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u552E\u7968\u7CFB\u7EDF");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 26));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(146, 10, 142, 51);
		user_table.getContentPane().add(lblNewLabel);
		
		JButton car_find_Button = new JButton("\u67E5\u8BE2\u8F66\u6B21");
		car_find_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CarFind().find();
				user_table.dispose();
			}
		});
		car_find_Button.setBounds(146, 86, 115, 40);
		user_table.getContentPane().add(car_find_Button);
		
		JButton check_self_Button = new JButton("\u67E5\u770B\u4E2A\u4EBA\u4FE1\u606F");
		check_self_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelfInformation();
				user_table.dispose();
			}
		});
		check_self_Button.setBounds(146, 148, 115, 40);
		user_table.getContentPane().add(check_self_Button);
		
		JButton out_Button = new JButton("\u9000\u51FA");
		out_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TicketInformation().Out();
				user_table.dispose();
				new MainWindow().mainWindow();
			}
		});
		out_Button.setBounds(146, 282, 115, 40);
		user_table.getContentPane().add(out_Button);
		
		JButton buy_tickect_Button = new JButton("\u8D2D\u7968");
		buy_tickect_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CarInformation().carInformation();
				user_table.dispose();
			}
		});
		buy_tickect_Button.setBounds(146, 215, 115, 40);
		user_table.getContentPane().add(buy_tickect_Button);
	}
}
