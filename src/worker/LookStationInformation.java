package worker;

import java.awt.BorderLayout;
import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DBC.ConnectionMySQL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LookStationInformation extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTable table;
	
	public LookStationInformation() {
		String []columnName = {"车次","出发地","目的地","出发时间","剩余票数","价格"};
		Object [][]rowData = new Object[1000][6];
		String sql = "select *from 车次信息 where 出发地 = (select 工作车站 from 工作员信息 where 工作员名 =(select 用户名 from 登录表))";
		Connection conn = ConnectionMySQL.getConnection();
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			int count = 0;
			while(rs.next()) {
				rowData[count][0]=rs.getString("车次");
				rowData[count][1]=rs.getString("出发地");
				rowData[count][2]=rs.getString("目的地");
				rowData[count][3]=rs.getString("出发时间");
				rowData[count][4]=rs.getString("剩余票数");
				rowData[count][5]=rs.getString("价格");
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
			new StationInformation().stationInformation();
		}
	});
	return_Button.setSize(50, 10);
	getContentPane().add(return_Button,BorderLayout.SOUTH);
	}
}
