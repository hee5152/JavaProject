package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
	//DB�� �����ϱ� ���� �޼ҵ� DBConnect()
	public static Connection DBConnect() {
		//Db�� ���� ������ ����Connection ���� conn ����
		Connection conn = null;
		
		//������ DB�� �ּ�����
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		//������ DB�� ��������
		String user = "seunghee";
		String password ="1111";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//ojdbc6 ���̺귯���� ���� �ҽ��� ����
			conn = DriverManager.getConnection(url,user,password);
										//    SQL- url,id pssword
			System.out.println("DB���� ����!");
			
		} catch (ClassNotFoundException cne) {
			cne.printStackTrace();
			System.out.println("DB���� ���� : ����̹� �ε� ����");
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("DB���ӽ��� : �������� Ȯ��");
		}
		
		return conn;	//��� ���ӵǾ��ֵ���
		
	}
	
}
