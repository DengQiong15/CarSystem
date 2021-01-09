package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import DBC.TicketInformation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CarFind {

	private JFrame carfind;
	private JTextField start_Field;
	private JTextField end_Field_1;

	/**
	 * Launch the application.
	 */
	public void find() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarFind window = new CarFind();
					window.carfind.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CarFind() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		carfind = new JFrame();
		carfind.setTitle("\u8F66\u6B21\u67E5\u8BE2");
		carfind.setSize(536, 376);
		carfind.setLocationRelativeTo(null);
		carfind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		carfind.getContentPane().setLayout(null);
		
		JLabel tip_Label = new JLabel("\u8BF7\u8F93\u5165\u67E5\u8BE2\u4FE1\u606F\uFF01");
		tip_Label.setFont(new Font("黑体", Font.PLAIN, 25));
		tip_Label.setBounds(170, 36, 220, 72);
		carfind.getContentPane().add(tip_Label);
		
		JLabel start_Label = new JLabel("\u51FA\u53D1\u5730");
		start_Label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		start_Label.setBounds(151, 130, 65, 35);
		carfind.getContentPane().add(start_Label);
		
		start_Field = new JTextField();
		start_Field.setBounds(116, 175, 121, 29);
		carfind.getContentPane().add(start_Field);
		start_Field.setColumns(10);
		
		JLabel end_Label = new JLabel("\u76EE\u7684\u5730");
		end_Label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		end_Label.setBounds(341, 130, 85, 35);
		carfind.getContentPane().add(end_Label);
		
		end_Field_1 = new JTextField();
		end_Field_1.setBounds(311, 175, 121, 29);
		carfind.getContentPane().add(end_Field_1);
		end_Field_1.setColumns(10);
		
		JButton check_Button = new JButton("\u7ACB\u5373\u67E5\u8BE2");
		check_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  start = start_Field.getText();
				String end = end_Field_1.getText();
				try {
					boolean flag= new TicketInformation().FindCar(start,end);
					if(flag) {
						carfind.dispose();
						new CarInformationTable(start,end);
					}
					else {
						JOptionPane.showMessageDialog(null, "没有该线路车次！");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		check_Button.setOpaque(false);
		check_Button.setFont(new Font("黑体", Font.PLAIN, 15));
		check_Button.setBounds(286, 247, 97, 23);
		carfind.getContentPane().add(check_Button);
		
		JButton out_Button = new JButton("\u8FD4\u56DE");
		out_Button.setFont(new Font("黑体", Font.PLAIN, 15));
		out_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carfind.dispose();
				new UserTableWindow().userTableWindow();
				
			}
		});
		out_Button.setBounds(119, 247, 97, 23);
		carfind.getContentPane().add(out_Button);
	}
}
