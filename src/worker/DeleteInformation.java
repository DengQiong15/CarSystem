package worker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import DBC.TicketInformation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteInformation {

	 JFrame delete;
	 JTextField order_Field;

	/**
	 * Launch the application.
	 */
	public void deleteInformation() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteInformation window = new DeleteInformation();
					window.delete.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		delete = new JFrame();
		delete.setTitle("\u5220\u9664\u8F66\u6B21");
		delete.setBounds(100, 100, 450, 300);
		delete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		delete.getContentPane().setLayout(null);
		delete.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u5220\u9664\u7684\u8F66\u6B21");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(145, 27, 170, 68);
		delete.getContentPane().add(lblNewLabel);
		
		order_Field = new JTextField();
		order_Field.setBounds(141, 119, 150, 36);
		delete.getContentPane().add(order_Field);
		order_Field.setColumns(10);
		
		JButton delete_Button = new JButton("\u5220\u9664");
		delete_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String order = order_Field.getText();
				boolean flag =new TicketInformation().Worker_Delete_Information(order);
				if(flag) {
					JOptionPane.showMessageDialog(null, "删除成功！");
				}
				else {
					JOptionPane.showMessageDialog(null,"你所要删除的车次不存在！");
				}
			}
		});
		delete_Button.setBounds(81, 204, 97, 30);
		delete.getContentPane().add(delete_Button);
		
		JButton return_Button = new JButton("\u8FD4\u56DE");
		return_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StationInformation().stationInformation();
				delete.dispose();
			}
		});
		return_Button.setBounds(273, 206, 91, 27);
		delete.getContentPane().add(return_Button);
		
	}

}
