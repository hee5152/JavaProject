package dogShelter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {
		public static Connection DBConnect() {
				
				Connection con = null;
				
				String url = "jdbc:oracl:thin@localhost:1521:XE";
				
				String user = "seunghee";
				String password = "1111";
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					con = DriverManager.getConnection(url,user,password);
					
					System.out.println("db�젒�냽 �꽦怨�");
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					System.out.println("db�젒�냽 �떎�뙣: �뱶�씪�씠踰� 濡쒕뵫 �떎�뙣");
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("db�젒�냽 �떎�뙣: 怨꾩젙�젙蹂댄솗�씤");
				}
				return con;
		}
}