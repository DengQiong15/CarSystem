package carsystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;


import DBC.TicketInformation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


//用户注册页面

public class Login {
	private JFrame login;
	private JTextField loginusername_Field;
	private JTextField longinpassword_Field;

	/**
	 * Launch the application.
	 */
	public void login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		login = new JFrame();
		login.setResizable(false);
		login.setTitle("\u6B22\u8FCE\u4F7F\u7528\u8F66\u7968\u67E5\u8BE2\u9884\u8BA2\u7BA1\u7406\u7CFB\u7EDF");
		login.setSize(450, 300);
		login.setLocationRelativeTo(null);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.getContentPane().setLayout(null);
		
		JLabel loginLabel = new JLabel("\u7528\u6237\u6CE8\u518C");
		loginLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		loginLabel.setBounds(168, 34, 123, 44);
		login.getContentPane().add(loginLabel);
		
		JLabel username_Label = new JLabel("\u8F93\u5165\u7528\u6237\u540D\uFF1A");
		username_Label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		username_Label.setBounds(56, 98, 96, 29);
		login.getContentPane().add(username_Label);
		
		JLabel password_Label = new JLabel("\u8F93\u5165\u5BC6\u7801\uFF1A");
		password_Label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		password_Label.setBounds(56, 146, 96, 29);
		login.getContentPane().add(password_Label);
		
		loginusername_Field = new JTextField();
		loginusername_Field.setBounds(178, 104, 153, 21);
		login.getContentPane().add(loginusername_Field);
		loginusername_Field.setColumns(10);
		
		
		longinpassword_Field = new JTextField();
		longinpassword_Field.setBounds(179, 152, 152, 21);
		login.getContentPane().add(longinpassword_Field);
		longinpassword_Field.setColumns(10);
		
		
		//“注册”按钮
		JButton login_Button = new JButton("\u6CE8\u518C");
		login_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = loginusername_Field.getText();
				String password = String.valueOf(longinpassword_Field.getText());
				
				new TicketInformation().Login_Insert(user,password);//将用户注册的用户名及密码存入用户数据库
				
				login.dispose();
			}
		});
		login_Button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		login_Button.setBounds(168, 202, 97, 23);
		login.getContentPane().add(login_Button);
	}

}
