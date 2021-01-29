package Jdbc0120;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {

	// DB�� �����ϱ� ���� �޼ҵ� DBConnect()
	public static Connection DBConnect() {
		//DB�� �������� ������ ���� Connection ���� con ����
		Connection con = null;
		
		//������ DB�� �ּ�����
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		//������ DB�� ��������
		String user = "seunghee";
		String password = "1111";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ojdbc6 ���̺귯���� ���� �ҽ��� ����
			
			con = DriverManager.getConnection(url,user,password);
				//con = DriverManager.getConnection("jdbc:oracle:thine:@localhost:1521:XE","seunghee","1111");
				//con�� ���� DB�� Java�� �������ִ� ����!
			
			System.out.println("DB���� ����!");
		
		} catch (ClassNotFoundException cne) {
			cne.printStackTrace();
			System.out.println("DB���� ���� : ����̹� �ε� ����"); //ojdbc6 ���� �� �ȵȰ��
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("DB���� ���� : ��������  Ȯ��!");
		}
		// printStackTrace() : ���� �߻��� ��θ� ã���ش�.
		
		
		
		//DB������ ���������� �Ǹ� ���ӻ���(con)�� �������ش�.
		return con;
		
		
		
	}
}
