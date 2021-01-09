package carsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import DBC.ConnectionMySQL;
import DBC.TicketInformation;
import manager.TableWindow;
import user.UserTableWindow;
import worker.StationInformation;


public class Enter {

	private JFrame enter;
	private JTextField username_Field;
	private JPasswordField password_Field;

	/**
	 * Launch the application.
	 */
	public void enter() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enter window = new Enter();
					window.enter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Enter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//用户登录页面
		enter = new JFrame();
		enter.setResizable(false);
		enter.setTitle("\u6B22\u8FCE\u4F7F\u7528\u8F66\u7968\u67E5\u8BE2\u7CFB\u7EDF");
		enter.setSize(469, 362);
		enter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		enter.getContentPane().setLayout(null);
		enter.setLocationRelativeTo(null);

		//提示信息：“新用户注册”
		JLabel tip_Label = new JLabel("\u65B0\u7528\u6237\u9700\u8981\u6CE8\u518C!");
		tip_Label.setFont(new Font("宋体", Font.PLAIN, 13));
		tip_Label.setBounds(10, 309, 97, 15);
		enter.getContentPane().add(tip_Label);
		
		// “用户登录”
		JLabel enter_Label = new JLabel("\u767B\u5F55");
		enter_Label.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		enter_Label.setBounds(191, 24, 85, 42);
		enter.getContentPane().add(enter_Label);
		
		// “用户名：”
		JLabel username_Label = new JLabel("\u7528\u6237\u540D\uFF1A");
		username_Label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		username_Label.setBounds(85, 68, 85, 31);
		enter.getContentPane().add(username_Label);
		
		// “密码：”
		JLabel password_Label = new JLabel("\u5BC6\u7801\uFF1A");
		password_Label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		password_Label.setBounds(85, 116, 85, 31);
		enter.getContentPane().add(password_Label);
		
		// 用户名信息填写区域
		username_Field = new JTextField();
		username_Field.setBounds(180, 76, 135, 21);
		enter.getContentPane().add(username_Field);
		username_Field.setColumns(10);
		
		// 密码填写区域
		password_Field = new JPasswordField();
		password_Field.setColumns(10);
		password_Field.setBounds(180, 124, 135, 21);
		enter.getContentPane().add(password_Field);
		
		
		// “注册”按钮
		JButton login_Button = new JButton("\u6CE8\u518C");
		login_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login newuser = new Login();
				newuser.login();
			}
		});
		login_Button.setBounds(40, 170, 100, 25);
		enter.getContentPane().add(login_Button);
		
		
		// 一般用户登录按钮
		JButton enter_Button = new JButton("\u767B\u5F55");
		enter_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = username_Field.getText();
				String password = String.valueOf(password_Field.getPassword());
				try {
					if("".trim().equals(user)||"".trim().equals(password)) {
						JOptionPane.showMessageDialog(null, "用户名或密码未填写，请填写信息！");
					}
					else if(CompareWithSQL1(user,password)) {
						JOptionPane.showMessageDialog(null, "用户登录成功！");
						new TicketInformation().Remember(user);
						new UserTableWindow().userTableWindow();
						enter.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "你登录的用户不存在！");
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
		enter_Button.setBounds(170, 170, 100, 25);
		enter.getContentPane().add(enter_Button);
		
		//车站工作人员登录按钮
		JButton enter_Button_1 = new JButton("\u5DE5\u4F5C\u4EBA\u5458\u767B\u5F55");
		enter_Button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = username_Field.getText();
				String password = String.valueOf(password_Field.getPassword());
				try {
					if("".trim().equals(user)||"".trim().equals(password)) {
						JOptionPane.showMessageDialog(null, "用户名或密码未填写，请填写信息！");
					}
					else if(CompareWithSQL2(user,password)) {
						JOptionPane.showMessageDialog(null, "工作人员登录成功！");
						enter.dispose();
						new TicketInformation().Remember(user);
						new StationInformation().stationInformation();
					}
					else {
						JOptionPane.showMessageDialog(null, "没有你登录的账号信息！");
					}
						
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		enter_Button_1.setBounds(310, 170, 125, 25);
		enter.getContentPane().add(enter_Button_1);
		
		
		//系统管理员登录按钮
		JButton enter_Button_2 = new JButton("\u7CFB\u7EDF\u7BA1\u7406\u5458\u767B\u5F55");
		enter_Button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user= username_Field.getText();
				String password = String.valueOf(password_Field.getPassword());
				if("".trim().equals(user)||"".trim().equals(password)) {
					JOptionPane.showMessageDialog(null, "用户名或密码未填写，请填写信息！");
				}
				else if("Lavinia".trim().equals(user)&&"20010215".trim().equals(password)) {
					JOptionPane.showMessageDialog(null, "管理员登录成功！");
					enter.dispose();
					new TableWindow().tableWindow();
				}
				
			}
		});
		enter_Button_2.setBounds(160, 225, 120, 25);
		enter.getContentPane().add(enter_Button_2);
		
	}
	
	
	 //用户登录时信息与系统中的信息进行匹配
	private boolean CompareWithSQL1(String name, String pass) throws SQLException {
		Connection conn = ConnectionMySQL.getConnection();
		String sql = "select * from 用户信息";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			String user = rs.getString(1);
			String password = rs.getString(2);
			if(user.trim().equals(name)&&password.trim().equals(pass)) {
				return true;
			}
		}
		return false;
	}

	private boolean CompareWithSQL2(String name, String pass) throws SQLException {
		Connection conn = ConnectionMySQL.getConnection();
		String sql = "select * from 工作员信息";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			String user = rs.getString(1);
			String password = rs.getString(2);
			if(user.trim().equals(name)&&password.trim().equals(pass)) {
				return true;
			}
		}
		return false;
	}
	
}
