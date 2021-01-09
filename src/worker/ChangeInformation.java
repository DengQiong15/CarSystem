package worker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import DBC.TicketInformation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeInformation {

	private JFrame change;
	private JTextField order_Field;
	private JTextField number_Field;
	private JTextField price_Field;

	/**
	 * Launch the application.
	 */
	public void chageInformation() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeInformation window = new ChangeInformation();
					window.change.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChangeInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		change = new JFrame();
		change.setTitle("\u4FEE\u6539\u8F66\u6B21\u4FE1\u606F");
		change.setBounds(100, 100, 405, 382);
		change.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		change.getContentPane().setLayout(null);
		change.setLocationRelativeTo(null);
		
		
		JLabel Tip_Label = new JLabel("Tip:\u8BF7\u8F93\u5165\u4FEE\u6539\u540E\u7684\u5185\u5BB9.");
		Tip_Label.setBounds(0, 0, 261, 43);
		change.getContentPane().add(Tip_Label);
		
		JLabel order_Label = new JLabel("\u9700\u8981\u4FEE\u6539\u7684\u8F66\u6B21\uFF1A");
		order_Label.setFont(new Font("宋体", Font.PLAIN, 14));
		order_Label.setBounds(48, 53, 127, 33);
		change.getContentPane().add(order_Label);
		
		order_Field = new JTextField();
		order_Field.setBounds(195, 53, 136, 27);
		change.getContentPane().add(order_Field);
		order_Field.setColumns(10);
		
		JLabel number_Label = new JLabel("\u5269\u4F59\u7968\u6570\uFF1A");
		number_Label.setFont(new Font("宋体", Font.PLAIN, 14));
		number_Label.setBounds(48, 116, 127, 33);
		change.getContentPane().add(number_Label);
		
		JLabel price_Label = new JLabel("\u4EF7\u683C\uFF1A");
		price_Label.setFont(new Font("宋体", Font.PLAIN, 14));
		price_Label.setBounds(48, 185, 127, 33);
		change.getContentPane().add(price_Label);
		
		number_Field = new JTextField();
		number_Field.setColumns(10);
		number_Field.setBounds(195, 119, 136, 27);
		change.getContentPane().add(number_Field);
		
		price_Field = new JTextField();
		price_Field.setColumns(10);
		price_Field.setBounds(195, 188, 136, 27);
		change.getContentPane().add(price_Field);
		
		JButton change_Button = new JButton("\u4FEE\u6539");
		change_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String order = order_Field.getText();
				String number = number_Field.getText();
				String price = price_Field.getText();
				boolean flag = new  TicketInformation().Woker_Change_Information(order,number,price);
				if(flag) {
					JOptionPane.showMessageDialog(null, "修改成功！");
				}
				else {
					JOptionPane.showMessageDialog(null,"你所要修改的车次不存在！");
				}
			}
		});
		change_Button.setBounds(52, 255, 97, 23);
		change.getContentPane().add(change_Button);
		
		JButton return_Button = new JButton("\u8FD4\u56DE");
		return_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StationInformation().stationInformation();
				change.dispose();
			}
		});
		return_Button.setBounds(195, 255, 97, 23);
		change.getContentPane().add(return_Button);
	}
}
