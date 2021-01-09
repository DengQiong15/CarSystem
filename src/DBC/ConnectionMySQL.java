package DBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionMySQL {

		private static Connection conn = null;
		protected static String url = "jdbc:mysql://localhost:3306/汽车售票系统?useSSL=false&serverTimezone=GMT%2B8";
		protected static String user = "root";
		protected static String password = "123456789";
		static {
		// 1.加载启动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接（连接对象内部其实包含Socket对象，是一个远程连接。比较耗时！
			//这是Connection对象管理的一个要点
			//在真正的开发中，为了提高效率，都会使用连接池来管理连接对象！
			// 2.建立数据库连接
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
