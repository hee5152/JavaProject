package dogShelter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
	//DB에 접속하기 위한 메소드 DBConnect()
	public static Connection DBConnect() {
		//Db에 접속 저장을 위한Connection 변수 conn 선언
		Connection conn = null;
		
		//접속할 DB의 주소정보
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		//접속할 DB의 계정정보
		String user = "seunghee";
		String password ="1111";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//ojdbc6 라이브러리를 현재 소스에 적용
			conn = DriverManager.getConnection(url,user,password);
										//    SQL- url,id pssword
			System.out.println("DB접속 성공!");
			
		} catch (ClassNotFoundException cne) {
			cne.printStackTrace();
			System.out.println("DB접속 실패 : 드라이버 로딩 실패");
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("DB접속실패 : 계정정보 확인");
		}
		
		return conn;	//계속 접속되어있도록
		
	}
	
}

