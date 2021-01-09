package user;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DBC.ConnectionMySQL;

public class SelfInformation extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTable table;
	public SelfInformation() {
		
		String []columnName = {"�û���","����","�ѹ�����"};
		Object [][] rowData = new Object[1][3]; 
		String sql = "select * from �û���Ϣ where �û��� = (select * from ��¼��) ";
		String sql1 = "select * from ��¼��";
		
		Connection conn = ConnectionMySQL.getConnection();
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			PreparedStatement ptmt1 = conn.prepareStatement(sql1);
			ResultSet rs1 = ptmt1.executeQuery();
			if(rs1.next());
			String name = rs1.getString(1);
			int count = 0;
			boolean flag = false;
			while(rs.next()) {
				String user = rs.getString("�û���");
				if(user.trim().equals(name)){
					flag = true;
				rowData[count][0] = rs.getString("�û���");
				rowData[count][1] = rs.getString("����");
				if("0".trim().equals(rs.getString("�ѹ�����"))) {
				rowData[count][2] = "";
				}
				else {
					rowData[count][2] = rs.getString("�ѹ�����");
				}
				count ++;
				}
			}
			
			if(!flag) {
				JOptionPane.showMessageDialog(null,"����û���Ϣ�����ڣ�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Container container = getContentPane();
		table = new JTable(rowData,columnName);
		JScrollPane scrollPane = new JScrollPane(table);
		container.add(scrollPane, BorderLayout.CENTER);
		setVisible(true);
		setSize(450, 300);
		setLocationRelativeTo(null);
		

		JButton return_Button = new JButton("\u8FD4\u56DE");
		return_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserTableWindow().userTableWindow();
				dispose();
			}
		});
		return_Button.setSize(50, 10);
		getContentPane().add(return_Button,BorderLayout.SOUTH);
	}
	
}
