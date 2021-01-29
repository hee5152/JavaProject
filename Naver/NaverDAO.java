package Naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NaverDAO {
	//DAO (Data Access Object) : ������ ���� ��ü
	//-�鿣�弭��, ojdbc�� ����Ͽ� SQL�� ��� �� ���ִ�.
	
	// DB������ ���� ����conn����
	//conn�� DB������� ���Ѵ�.
	Connection conn = null;

	//������ ������ ���� ����
	//Statement stmt = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;

	//��ȸ(selcect) ����� �����ϱ� ���� ���� rs ����
	ResultSet rs = null; //(input)���ֱ�

	
	//�׸�1. DB���� �޼ҵ� connect()
	public void connect() {
		conn = NaverDBCon.DBConnect();
		// conn�� DBCŬ������ ���� �޼ҵ��� ���ϰ�(con)�� �����Ѵ�.
		
	}
	//�׸�2. DB�������� �޼ҵ� conClose()
	public void connClose() {
		try {
			conn.close();
			//ConnectionŬ������ ����޼ҵ� close()�� ����Ͽ� ������ �����Ѵ�
			
			System.out.println("DB��������!");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	//�׸�3. ȸ������ �޼ҵ� memberJoin()
	public void insert(NaverDTO naver) {
		String sql = "INSERT INTO NAVER VALUES(?,?,?,?,?,?,?)";
		//���̹����̺� ������ ���� 7��
		
		System.out.println("�л����� :" + naver);
		System.out.println("DB���� : " + conn);

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, naver.getNaver_id());
			pstmt.setString(2, naver.getNaver_pass());
			pstmt.setString(3, naver.getNaver_name());
			pstmt.setString(4, naver.getNaver_birth());
			pstmt.setString(5, naver.getNaver_gender());
			pstmt.setString(6, naver.getNaver_email());
			pstmt.setString(7, naver.getNaver_phone());

			//7���� ������ �� �Է� �� �� �����ͺ��̽� ����
			//pstmt.executeUpdate();
			
			//1. int result
//			int result = pstmt.executeUpdate();	
//			
//			if (result > 0) {
//				System.out.println("ȸ������ ����!");
//			} else {
//				System.out.println("ȸ������ ����!");
//			}
			
			
			//2. boolean result2
			boolean result2 = pstmt.execute();
			System.out.println("�������� : " +result2);
			
			if(result2) {
				System.out.println("ȸ������ ����!");
			}else {
				System.out.println("ȸ������ ����!");
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}
	
	
	//�׸�4. ȸ����� ��ȸ�ϴ� �޼ҵ� memberList()
	public void memberList() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT* FROM NAVER";
		System.out.println("DB����x : conn ��?" + conn);
		

		try {
			pstmt = conn.prepareStatement(sql); //���尴ü - sql���� pstmt�� ��ڴ�
			
			//pstmt. setStirng(1,naver.getNaver_id())
			
			rs = pstmt.executeQuery(); //String sql = "SELECT* FROM NAVER"; �̰Ÿ� ������ ���������
			// execute => booleanŸ�� ��ȯ
			// executeUpdate => int Ÿ�� ��ȯ
			// executeQuery => ResultSetŸ�� ��ȯ
			
			int i = 1;
			while (rs.next()) {

				System.out.println(i + "��°ȸ�� ����");
				System.out.println("���̵� : " + rs.getString(1));
				System.out.println("��й�ȣ: " + rs.getString(2));
				System.out.println("�̸� :" + rs.getString(3));
				System.out.println("������� : " + rs.getString(4));
				System.out.println("���� : " + rs.getString(5));
				System.out.println("�̸��� :" + rs.getString(6));
				System.out.println("��ȭ��ȣ : " + rs.getString(7));
				System.out.println();
				i++;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	
	//�׸�5. ȸ����� �����ϴ� �޼ҵ� memberModify()
	public void memberModify(NaverDTO naver) {
		// TODO Auto-generated method stub
		
	
		String sql = "UPDATE NAVER SET NAVER_PASS=?" + "NAVER_NAME=?"
					+ "NAVER_BIRTH=?, NAVER_GENDER=?, NAVER_EMAIL=?, NAVER_PHONE=? "
					+ "WHERE NAVER_ID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, naver.getNaver_pass());
			pstmt.setString(2, naver.getNaver_name());
			pstmt.setString(3, naver.getNaver_birth());
			pstmt.setString(4, naver.getNaver_gender());
			pstmt.setString(5, naver.getNaver_email());
			pstmt.setString(6, naver.getNaver_phone());
			pstmt.setString(7, naver.getNaver_id());
			//�� �ֵ��� ? �ȿ� ��
			
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("ȸ������ ��������!");
			} else {
				System.out.println("ȸ������ ��������!");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	//�׸�6-1. ȸ�������� �����ϱ� ����
	//���̵�� ��й�ȣ�� �˻��ϴ� �޼ҵ�idCheck()
	public boolean idCheck(String dId, String dPw) {
		// TODO Auto-generated method stub
		String sql ="SELECT NAVER_ID FORM NAVER"
				+"WHERE NAVER_ID=? AND NAVER_PASS=?";
		boolean checkResult = false;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dId);
			pstmt.setString(2, dPw);
		
			rs =pstmt.executeQuery();
		
		
			//while(rs.next())�� �Ⱦ�����
			//rs�� ������� 1���̱� ������ while�� �ƴ� if�� ���
			
			if(rs.next()) {
				checkResult = true;
			}else {
				checkResult = false; //�Ƚ��൵ �������
			}
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		
		return checkResult;
	}
	
	//�׸� 6. ȸ�������� �����ϴ� �޼ҵ� memberDelete()
	
	public void memberDelete(String dId) {
		// TODO Auto-generated method stub
		String sql = "DELETE NAVER WHERE NAVER_ID=?";
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1,dId);
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("ȸ������ ��������!");
			}else {
				System.out.println("ȸ������ ��������!");
			}
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
	}
	public void memberJoin(NaverDTO naver) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	



		

		
	
			
			
		
		
	
}
