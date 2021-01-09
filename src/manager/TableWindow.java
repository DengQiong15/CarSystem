package manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import DBC.TicketInformation;
import carsystem.MainWindow;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TableWindow {

	private JFrame table;

	/**
	 * Launch the application.
	 */
	public void tableWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableWindow window = new TableWindow();
					window.table.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TableWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		table = new JFrame();
		table.getContentPane().setBackground(new Color(255, 255, 224));
		table.setTitle("\u6B22\u8FCE\u8FDB\u5165\u552E\u7968\u7CFB\u7EDF\u7BA1\u7406\u754C\u9762");
		table.setBounds(100, 100, 354,418 );
		table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		table.getContentPane().setLayout(null);
		table.setLocationRelativeTo(null);
		
		JLabel system_Label = new JLabel("\u552E\u7968\u7CFB\u7EDF");
		system_Label.setForeground(new Color(0, 0, 0));
		system_Label.setFont(new Font("宋体", Font.PLAIN, 24));
		system_Label.setBounds(115, 10, 114, 43);
		table.getContentPane().add(system_Label);
		
		JButton check_car_Button = new JButton("\u67E5\u770B\u7CFB\u7EDF\u8F66\u6B21\u4FE1\u606F");
		check_car_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllCarInformation();
				table.dispose();
			}
		});
		check_car_Button.setFont(new Font("宋体", Font.PLAIN, 14));
		check_car_Button.setBounds(89, 85, 154, 30);
		table.getContentPane().add(check_car_Button);
		
		JButton check_worker_Button = new JButton("\u67E5\u770B\u5DE5\u4F5C\u4EBA\u5458\u4FE1\u606F");
		check_worker_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllWorkerInformation();
				table.dispose();
			}
		});
		check_worker_Button.setFont(new Font("宋体", Font.PLAIN, 14));
		check_worker_Button.setBounds(89, 154, 154, 30);
		table.getContentPane().add(check_worker_Button);
		
		JButton out_Button = new JButton("\u9000\u51FA");
		out_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainWindow().mainWindow();
				new TicketInformation().Out();
				table.dispose();
			}
		});
		out_Button.setFont(new Font("宋体", Font.PLAIN, 14));
		out_Button.setBounds(89, 284, 154, 30);
		table.getContentPane().add(out_Button);
		
		JButton users_Button = new JButton("\u67E5\u770B\u7528\u6237\u4FE1\u606F");
		users_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllUserInformation();
				table.dispose();
			}
		});
		users_Button.setFont(new Font("宋体", Font.PLAIN, 14));
		users_Button.setBounds(89, 220, 154, 30);
		table.getContentPane().add(users_Button);
	}
}
