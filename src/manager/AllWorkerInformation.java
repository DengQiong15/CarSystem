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

public class AllWorkerInformation extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	public AllWorkerInformation() {
		String[] columnName = { "工作员名", "密码", "工作车站" };
		Object[][] rowData = new Object[100][3];
		String sql = "select * from 工作员信息";
		Connection conn = ConnectionMySQL.getConnection();
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			int count = 0;
			while (rs.next()) {
				rowData[count][0] = rs.getString("工作员名");
				rowData[count][1] = rs.getString("密码");
				rowData[count][2] = rs.getString("工作车站");
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Container container = getContentPane();
		table = new JTable(rowData, columnName);
		JScrollPane scrollPane = new JScrollPane(table);
		container.add(scrollPane, BorderLayout.CENTER);
		setVisible(true);
		setSize(450, 300);
		setLocationRelativeTo(null);

		JButton return_Button = new JButton("\u8FD4\u56DE");
		return_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TableWindow().tableWindow();
			}
		});

		return_Button.setSize(50, 10);
		getContentPane().add(return_Button, BorderLayout.SOUTH);
	}
}
