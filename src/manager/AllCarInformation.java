package manager;

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

public class AllCarInformation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTable table;
	public AllCarInformation() {

			String []columnName = {"����","������","Ŀ�ĵ�","����ʱ��","ʣ��Ʊ��","�۸�"};
			Object [][]rowData = new Object[1000][6];
			String sql = "select *from ������Ϣ";
			Connection conn = ConnectionMySQL.getConnection();
			
			try {
				PreparedStatement ptmt = conn.prepareStatement(sql);
				ResultSet rs = ptmt.executeQuery();
				int count = 0;
				while(rs.next()) {
					rowData[count][0]=rs.getString("����");
					rowData[count][1]=rs.getString("������");
					rowData[count][2]=rs.getString("Ŀ�ĵ�");
					rowData[count][3]=rs.getString("����ʱ��");
					rowData[count][4]=rs.getString("ʣ��Ʊ��");
					rowData[count][5]=rs.getString("�۸�");
					count++;
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
		setSize(800,600);
		setLocationRelativeTo(null);
		
		JButton return_Button = new JButton("\u8FD4\u56DE");
		return_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TableWindow().tableWindow();
				dispose();
			}
		});
		return_Button.setSize(50, 10);
		getContentPane().add(return_Button,BorderLayout.SOUTH);
		}

}
