package DBC;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

   
//其他页面调用的方法

public class TicketInformation {

	
	// 新用户注册
	public void Login_Insert(String user, String password) {
		Connection conn = ConnectionMySQL.getConnection();
		// 预处理
		String sql = "insert into 用户信息(用户名,密码,已购车次) values (?,?,?)";

		// 预编译
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, user);
			ptmt.setString(2, password);
			ptmt.setString(3, "0");
			// 执行
			ptmt.execute();
			
			JOptionPane.showMessageDialog(null, "注册成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "注册失败！");
			e.printStackTrace();
		}
	}
	
	
	
	//记住登录的用户名
	public void Remember(String name) {
		Connection conn = ConnectionMySQL.getConnection();
		String sql = "insert into 登录表(用户名) values(?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, name);
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	// 查询全部车次信息
	public void AllcarInformation() throws SQLException {
		Connection conn = ConnectionMySQL.getConnection();
		String sql = "select * from 车次信息";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		int column = rs.getMetaData().getColumnCount();
		System.out.println("车次\t出发地\t目的地\t出发时间\t剩余票数\t价格");
		while (rs.next()) {
			for (int i = 1; i <= column; i++) {
				System.out.print(rs.getString(i) + "\t");
			}
			System.out.println();
		}

	}

	
	// 寻找指定目的地车次信息
	public boolean FindCar(String start, String end) throws SQLException {
		Connection conn = ConnectionMySQL.getConnection();
		String sql = "select * from 车次信息";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		//int column = rs.getMetaData().getColumnCount();
		//System.out.println("车次\t出发地\t目的地\t出发时间\t剩余票数\t价格(元)");
		while (rs.next()) {
			String start1 = rs.getString(2);
			String end1 = rs.getString(3);
			if (start1.trim().equals(start) && end1.trim().equals(end)) {
				/*for (int i = 1; i <= column; i++) {
					System.out.print(rs.getString(i) + "\t");
				}*/
				return true;
				//System.out.println();
			}
		}
		
		return false;

	}

	
	// 用户购票
	public boolean Buy_Ticket(String ticket) throws SQLException {
		Connection conn = ConnectionMySQL.getConnection();
		String sql1 = "select * from 用户信息";
		String sql2 = "update 用户信息  set 已购车次 = '" + ticket + "'where 用户名 =(select * from 登录表)";
		String sql3 = "select * from 车次信息";
		String sql4 = "update 车次信息  set 剩余票数= 剩余票数-1 where 车次 = '" + ticket + "'";
		String sql5 = "select * From 登录表";
		PreparedStatement ptmt1 = conn.prepareStatement(sql1);
		PreparedStatement ptmt2 = conn.prepareStatement(sql3);
		PreparedStatement ptmt3 =conn.prepareStatement(sql5);
		Statement stmt1 = conn.createStatement();;
		Statement stmt2 = conn.createStatement();
		
		ResultSet rs2 = ptmt2.executeQuery();
		boolean flag1 = false;
		while (rs2.next()) {
			String order = rs2.getString(1);
			String number = rs2.getString(5);
			if (order.trim().equals(ticket)) {//判断 
				flag1 = true;
				if ("0".trim().equals(number)) {
					JOptionPane.showMessageDialog(null, "该车票已经售完,不可购买！");
					return false;
				}
			}
		}
		
		if (!flag1) {
			JOptionPane.showMessageDialog(null, "该车次不存在！");
			return false;
		}
		
		ResultSet rs1 = ptmt1.executeQuery();
		ResultSet rs3 = ptmt3.executeQuery();
		int column = rs1.getMetaData().getColumnCount();
		boolean flag2 = false;
		
		if(rs3.next());
		String name = rs3.getString(1);
		while (rs1.next()) {
			String user = rs1.getString(1);
			String ti = rs1.getString(3);
			if(user.trim().equals(name)) {
				flag2 = true;
				if ("0".trim().equals(ti)) {
					for (int i = 1; i <= column;) {
						System.out.print(rs1.getString(i) + "\t");
					}
						stmt1.executeUpdate(sql2);
						stmt2.executeUpdate(sql4);
						return true;
					}
			}
		}
		
		if (!flag2) {
			JOptionPane.showMessageDialog(null, "用户不存在！");
			return false;
		}

		JOptionPane.showMessageDialog(null, "你已购买一张车票，每个用户只能购买一张车票！");
		return false;
	}
	
	
	//退出登录,删除登录用户的信息
	public void Out(){
		Connection conn = ConnectionMySQL.getConnection();
		String sql = "delete From 登录表";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	//工作人员增加车次信息
	public void Worker_Insert_Information(String order, String end, String time, String number,
			String price) {
		Connection conn = ConnectionMySQL.getConnection();
		// 预处理
		String sql = "insert into 车次信息(车次,出发地,目的地,出发时间,剩余票数,价格)values (?,?,?,?,?,?)";

		// 预编译
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, order);
			ptmt.setString(2, "张家界");
			ptmt.setString(3, end);
			ptmt.setString(4, time);
			ptmt.setString(5, number);
			ptmt.setString(6, price);
			// 执行
			
			ptmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "插入成功！");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "插入失败！");
			e.printStackTrace();
		}
	}
	
	
	//工作人员删除车次信息
	public boolean Worker_Delete_Information(String order) {
		Connection conn = ConnectionMySQL.getConnection();
		String sql1 = "delete from 车次信息  where 车次= '"+order+"'";
		String sql2 = "select * from 车次信息";
		
		PreparedStatement ptmt1;
		PreparedStatement ptmt2;//查询是否有该车次信息
		boolean flag = false;
		try {
			ptmt2 = conn.prepareStatement(sql2);
			ptmt1 = conn.prepareStatement(sql1);
			//ResultSet rs1 = ptmt1.executeQuery();
			ResultSet rs2 = ptmt2.executeQuery();
			while(rs2.next()) {
				String location = rs2.getString(1);
				if(location.trim().equals(order))
					flag = true;
				ptmt1.executeUpdate();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "删除失败！");
			e.printStackTrace();
		}
		return flag;
	}
	
	//工作人员修改车次剩余票数及价格
	public boolean Woker_Change_Information(String order,String number,String price) {
		Connection conn = ConnectionMySQL.getConnection();
		String sql1 = "select * from 车次信息";
		String sql2 = "update 车次信息 set 剩余票数 = '"+number+"',价格='"+price+"'where 车次='"+order+"'";

		PreparedStatement ptmt1;
		PreparedStatement ptmt2;//查询是否有该车次信息
		boolean flag = false;
		try {
			ptmt1 = conn.prepareStatement(sql1);
			ptmt2 = conn.prepareStatement(sql2);
			//ResultSet rs1 = ptmt1.executeQuery();
			ResultSet rs = ptmt1.executeQuery();
			while(rs.next()) {
				String carorder = rs.getString(1);
				if(carorder.trim().equals(order))
					flag = true;
				ptmt2.executeUpdate();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "删除失败！");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	
	
	
}



