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
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DBC.ConnectionMySQL;

public class CarInformationTable extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	public CarInformationTable(String start,String end) {
		setTitle("\u8F66\u6B21\u4FE1\u606F");
		String[] columnNames = { "����", "������", "Ŀ�ĵ�", "����ʱ��", "ʣ��Ʊ��", "�۸�(Ԫ)" };// ��������
		Object [][] rowData = new Object[500][6];
		try{
			Connection conn = ConnectionMySQL.getConnection();
			String sql = "select * from ������Ϣ";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			int count = 0;
			while (rs.next()) {
				String  begin= rs.getString("������");
				String  ending= rs.getString("Ŀ�ĵ�");
				if(begin.trim().equals(start)&&ending.trim().equals(end)) {
					rowData[count][0] = rs.getString("����");
					rowData[count][1] = rs.getString("������");
					rowData[count][2] = rs.getString("Ŀ�ĵ�");
					rowData[count][3] = rs.getString("����ʱ��");
					rowData[count][4] = rs.getString("ʣ��Ʊ��");
					rowData[count][5] = rs.getString("�۸�");
					count++;
				}
			}
			}catch(
				SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Container container = getContentPane();
		table=new JTable(rowData,columnNames);// ʵ�������
		container.add(new JScrollPane(table),BorderLayout.CENTER);// �������
		setVisible(true);
		setSize(600, 400);
		setLocationRelativeTo(null);
		
		JButton return_Button = new JButton("\u8FD4\u56DE");
		return_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserTableWindow().userTableWindow();
				
			}
		});
		return_Button.setSize(50, 10);
		getContentPane().add(return_Button,BorderLayout.SOUTH);
		
	}
}
