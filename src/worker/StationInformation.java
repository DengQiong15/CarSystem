package worker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import DBC.TicketInformation;
import carsystem.MainWindow;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//工作人员页面
public class StationInformation {

	private JFrame wokerSystem;

	/**
	 * Launch the application.
	 */
	public void stationInformation() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StationInformation window = new StationInformation();
					window.wokerSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StationInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		wokerSystem = new JFrame();
		wokerSystem.getContentPane().setBackground(new Color(255, 255, 224));
		wokerSystem.setTitle("\u6B22\u8FCE\u4F7F\u7528\u8F66\u7AD9\u8D2D\u7968\u7CFB\u7EDF");
		wokerSystem.setBounds(100, 100, 436, 566);
		wokerSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wokerSystem.getContentPane().setLayout(null);
		wokerSystem.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u5728\u7EBF\u8F66\u7AD9\u8D2D\u7968\u7CFB\u7EDF\u7CFB\u7EDF");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(87, 10, 265, 48);
		wokerSystem.getContentPane().add(lblNewLabel);
		
		JButton change_Button = new JButton("\u4FEE\u6539\u4FE1\u606F");
		change_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangeInformation().chageInformation();
				wokerSystem.dispose();
			}
		});
		change_Button.setBounds(147, 153, 120, 38);
		wokerSystem.getContentPane().add(change_Button);
		
		JButton look_Button = new JButton("\u67E5\u770B\u8F66\u7968\u4FE1\u606F");
		look_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LookStationInformation();
				wokerSystem.dispose();
			}
		});
		look_Button.setBounds(148, 85, 119, 38);
		wokerSystem.getContentPane().add(look_Button);
		
		JButton delete_Button = new JButton("\u5220\u9664\u4FE1\u606F");
		delete_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteInformation().deleteInformation();
				wokerSystem.dispose();
			}
		});
		delete_Button.setBounds(147, 303, 117, 38);
		wokerSystem.getContentPane().add(delete_Button);
		
		JButton insert_Button = new JButton("\u589E\u52A0\u4FE1\u606F");
		insert_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsertInformation().insertInformation();
				wokerSystem.dispose();
			}
		});
		insert_Button.setBounds(148, 232, 119, 38);
		wokerSystem.getContentPane().add(insert_Button);
		
		JButton check_Button = new JButton("\u67E5\u770B\u4E2A\u4EBA\u4FE1\u606F");
		check_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WorkerSelfInformation();
				wokerSystem.dispose();
			}
		});
		check_Button.setBounds(147, 374, 117, 38);
		wokerSystem.getContentPane().add(check_Button);
		
		JButton out_Button = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		out_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TicketInformation().Out();
				wokerSystem.dispose();
				new MainWindow().mainWindow();
			}
		});
		out_Button.setBounds(147, 439, 117, 38);
		wokerSystem.getContentPane().add(out_Button);
	}

}
