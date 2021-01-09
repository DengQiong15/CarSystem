package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DBC.TicketInformation;

public class CarInformation {

	private JFrame carinformation;
	private JTextField Ticket_Field;

	/**
	 * Launch the application.
	 */
	public void carInformation() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarInformation window = new CarInformation();
					window.carinformation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CarInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		carinformation = new JFrame();
		carinformation.setResizable(false);
		carinformation.setTitle("\u8F66\u6B21\u4FE1\u606F");
		carinformation.setSize(350, 250);
		//carinformation.setLocation(875,450);
		carinformation.setLocationRelativeTo(null);
		carinformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		carinformation.getContentPane().setLayout(null);
		
		
		JLabel Tip_Label = new JLabel("\u8F93\u5165\u9700\u8981\u8D2D\u4E70\u7684\u8F66\u6B21\uFF1A");
		Tip_Label.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		Tip_Label.setBounds(10, 26, 168, 33);
		carinformation.getContentPane().add(Tip_Label);
		
		Ticket_Field = new JTextField();
		Ticket_Field.setBounds(102, 86, 147, 29);
		carinformation.getContentPane().add(Ticket_Field);
		Ticket_Field.setColumns(10);
		
		
		JButton buy_Button = new JButton("\u8D2D\u7968");
		buy_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ticket = Ticket_Field.getText();
				boolean flag;
				try {
					flag = new TicketInformation().Buy_Ticket(ticket);//对车票进行判断
					if(flag) {
						JOptionPane.showMessageDialog(null, "购票成功！");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		buy_Button.setFont(new Font("宋体", Font.PLAIN, 14));
		buy_Button.setBounds(63, 154, 83, 29);
		carinformation.getContentPane().add(buy_Button);
		
		JButton return_Button = new JButton("\u8FD4\u56DE");
		return_Button.setFont(new Font("宋体", Font.PLAIN, 14));
		return_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserTableWindow().userTableWindow();
				carinformation.dispose();
				
			}
		});
		return_Button.setBounds(227, 154, 73, 28);
		carinformation.getContentPane().add(return_Button);
		
	}
}
