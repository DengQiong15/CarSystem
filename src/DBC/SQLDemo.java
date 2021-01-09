package DBC;

import java.sql.Connection;

public class SQLDemo {

	public static void main(String[] args) {
		Connection conn = ConnectionMySQL.getConnection();
		System.out.println(conn);

	}

}
