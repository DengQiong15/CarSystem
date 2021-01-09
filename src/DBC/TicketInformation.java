package DBC;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

   
//����ҳ����õķ���

public class TicketInformation {

	
	// ���û�ע��
	public void Login_Insert(String user, String password) {
		Connection conn = ConnectionMySQL.getConnection();
		// Ԥ����
		String sql = "insert into �û���Ϣ(�û���,����,�ѹ�����) values (?,?,?)";

		// Ԥ����
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, user);
			ptmt.setString(2, password);
			ptmt.setString(3, "0");
			// ִ��
			ptmt.execute();
			
			JOptionPane.showMessageDialog(null, "ע��ɹ���");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
	
	
	//��ס��¼���û���
	public void Remember(String name) {
		Connection conn = ConnectionMySQL.getConnection();
		String sql = "insert into ��¼��(�û���) values(?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, name);
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	// ��ѯȫ��������Ϣ
	public void AllcarInformation() throws SQLException {
		Connection conn = ConnectionMySQL.getConnection();
		String sql = "select * from ������Ϣ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		int column = rs.getMetaData().getColumnCount();
		System.out.println("����\t������\tĿ�ĵ�\t����ʱ��\tʣ��Ʊ��\t�۸�");
		while (rs.next()) {
			for (int i = 1; i <= column; i++) {
				System.out.print(rs.getString(i) + "\t");
			}
			System.out.println();
		}

	}

	
	// Ѱ��ָ��Ŀ�ĵس�����Ϣ
	public boolean FindCar(String start, String end) throws SQLException {
		Connection conn = ConnectionMySQL.getConnection();
		String sql = "select * from ������Ϣ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		//int column = rs.getMetaData().getColumnCount();
		//System.out.println("����\t������\tĿ�ĵ�\t����ʱ��\tʣ��Ʊ��\t�۸�(Ԫ)");
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

	
	// �û���Ʊ
	public boolean Buy_Ticket(String ticket) throws SQLException {
		Connection conn = ConnectionMySQL.getConnection();
		String sql1 = "select * from �û���Ϣ";
		String sql2 = "update �û���Ϣ  set �ѹ����� = '" + ticket + "'where �û��� =(select * from ��¼��)";
		String sql3 = "select * from ������Ϣ";
		String sql4 = "update ������Ϣ  set ʣ��Ʊ��= ʣ��Ʊ��-1 where ���� = '" + ticket + "'";
		String sql5 = "select * From ��¼��";
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
			if (order.trim().equals(ticket)) {//�ж� 
				flag1 = true;
				if ("0".trim().equals(number)) {
					JOptionPane.showMessageDialog(null, "�ó�Ʊ�Ѿ�����,���ɹ���");
					return false;
				}
			}
		}
		
		if (!flag1) {
			JOptionPane.showMessageDialog(null, "�ó��β����ڣ�");
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
			JOptionPane.showMessageDialog(null, "�û������ڣ�");
			return false;
		}

		JOptionPane.showMessageDialog(null, "���ѹ���һ�ų�Ʊ��ÿ���û�ֻ�ܹ���һ�ų�Ʊ��");
		return false;
	}
	
	
	//�˳���¼,ɾ����¼�û�����Ϣ
	public void Out(){
		Connection conn = ConnectionMySQL.getConnection();
		String sql = "delete From ��¼��";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	//������Ա���ӳ�����Ϣ
	public void Worker_Insert_Information(String order, String end, String time, String number,
			String price) {
		Connection conn = ConnectionMySQL.getConnection();
		// Ԥ����
		String sql = "insert into ������Ϣ(����,������,Ŀ�ĵ�,����ʱ��,ʣ��Ʊ��,�۸�)values (?,?,?,?,?,?)";

		// Ԥ����
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, order);
			ptmt.setString(2, "�żҽ�");
			ptmt.setString(3, end);
			ptmt.setString(4, time);
			ptmt.setString(5, number);
			ptmt.setString(6, price);
			// ִ��
			
			ptmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "����ɹ���");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
	
	//������Աɾ��������Ϣ
	public boolean Worker_Delete_Information(String order) {
		Connection conn = ConnectionMySQL.getConnection();
		String sql1 = "delete from ������Ϣ  where ����= '"+order+"'";
		String sql2 = "select * from ������Ϣ";
		
		PreparedStatement ptmt1;
		PreparedStatement ptmt2;//��ѯ�Ƿ��иó�����Ϣ
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
			JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
			e.printStackTrace();
		}
		return flag;
	}
	
	//������Ա�޸ĳ���ʣ��Ʊ�����۸�
	public boolean Woker_Change_Information(String order,String number,String price) {
		Connection conn = ConnectionMySQL.getConnection();
		String sql1 = "select * from ������Ϣ";
		String sql2 = "update ������Ϣ set ʣ��Ʊ�� = '"+number+"',�۸�='"+price+"'where ����='"+order+"'";

		PreparedStatement ptmt1;
		PreparedStatement ptmt2;//��ѯ�Ƿ��иó�����Ϣ
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
			JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	
	
	
}



