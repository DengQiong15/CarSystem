package worker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import DBC.TicketInformation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertInformation {

	private JFrame insert;
	private JTextField order_Field;
	private JTextField end_Field;
	private JTextField time_Field;
	private JTextField number_Field;
	private JTextField price_Field;

	/**
	 * Launch the application.
	 */
	public void insertInformation() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertInformation window = new InsertInformation();
					window.insert.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InsertInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		insert = new JFrame();
		insert.setTitle("\u589E\u52A0\u8F66\u6B21");
		insert.setBounds(100, 100, 441, 443);
		insert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		insert.getContentPane().setLayout(null);
		insert.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u65B0\u589E\u8F66\u6B21\u4FE1\u606F!");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(123, 10, 187, 34);
		insert.getContentPane().add(lblNewLabel);
		
		order_Field = new JTextField();
		order_Field.setBounds(215, 66, 95, 25);
		insert.getContentPane().add(order_Field);
		order_Field.setColumns(10);
		
		JLabel order_Label_1 = new JLabel("\u8F66\u6B21:");
		order_Label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		order_Label_1.setBounds(68, 66, 78, 25);
		insert.getContentPane().add(order_Label_1);
		
		JLabel end_Label = new JLabel("\u76EE\u7684\u5730\uFF1A");
		end_Label.setFont(new Font("宋体", Font.PLAIN, 16));
		end_Label.setBounds(68, 117, 78, 25);
		insert.getContentPane().add(end_Label);
		
		JLabel time_Label = new JLabel("\u51FA\u53D1\u65F6\u95F4\uFF1A");
		time_Label.setFont(new Font("宋体", Font.PLAIN, 16));
		time_Label.setBounds(68, 162, 85, 25);
		insert.getContentPane().add(time_Label);
		
		JLabel number_Label = new JLabel("\u5269\u4F59\u7968\u6570\uFF1A");
		number_Label.setFont(new Font("宋体", Font.PLAIN, 16));
		number_Label.setBounds(68, 209, 85, 25);
		insert.getContentPane().add(number_Label);
		
		JLabel price_Label = new JLabel("\u4EF7\u683C(\u5143)\uFF1A");
		price_Label.setFont(new Font("宋体", Font.PLAIN, 16));
		price_Label.setBounds(68, 264, 85, 25);
		insert.getContentPane().add(price_Label);
		
		JButton insert_Button = new JButton("\u63D2\u5165\u8F66\u6B21");
		insert_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String order = order_Field.getText();
				String end = end_Field.getText();
				String time = time_Field.getText();
				String number = number_Field.getText();
				String price = price_Field.getText();
				if("".equals(order)||"".equals(end)||"".equals(time)||"".equals(number)||"".equals(price)) {
					JOptionPane.showMessageDialog(null,"请完善数据！");
				}
				else {
					//填入信息后计入数据库
				new TicketInformation().Worker_Insert_Information(order,end,time,number,price);
				}
			}
		});
		insert_Button.setBounds(68, 343, 108, 34);
		insert.getContentPane().add(insert_Button);
		
		end_Field = new JTextField();
		end_Field.setColumns(10);
		end_Field.setBounds(215, 118, 95, 25);
		insert.getContentPane().add(end_Field);
		
		time_Field = new JTextField();
		time_Field.setColumns(10);
		time_Field.setBounds(215, 163, 95, 25);
		insert.getContentPane().add(time_Field);
		
		number_Field = new JTextField();
		number_Field.setColumns(10);
		number_Field.setBounds(215, 210, 95, 25);
		insert.getContentPane().add(number_Field);
		
		price_Field = new JTextField();
		price_Field.setColumns(10);
		price_Field.setBounds(215, 254, 95, 25);
		insert.getContentPane().add(price_Field);
		
		JButton return_Button = new JButton("\u8FD4\u56DE");
		return_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StationInformation().stationInformation();
				insert.dispose();
			}
		});
		return_Button.setBounds(238, 343, 108, 33);
		insert.getContentPane().add(return_Button);
	}
}
