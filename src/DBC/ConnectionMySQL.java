package DBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionMySQL {

		private static Connection conn = null;
		protected static String url = "jdbc:mysql://localhost:3306/������Ʊϵͳ?useSSL=false&serverTimezone=GMT%2B8";
		protected static String user = "root";
		protected static String password = "123456789";
		static {
		// 1.��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ӣ����Ӷ����ڲ���ʵ����Socket������һ��Զ�����ӡ��ȽϺ�ʱ��
			//����Connection��������һ��Ҫ��
			//�������Ŀ����У�Ϊ�����Ч�ʣ�����ʹ�����ӳ����������Ӷ���
			// 2.�������ݿ�����
			conn = DriverManager.getConnection(url, user, password);
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
		public static Connection getConnection() {
			return conn;
			
		}
}
