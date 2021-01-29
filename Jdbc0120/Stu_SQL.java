package Jdbc0120;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Stu_SQL {
//�ʵ尪����
	// DB������ ���� ���� con ����
	Connection con = null; //connection input ���ֱ�
	
	// ������ ������ ���� ���� ����   //java sql�� input ���ֱ�
	Statement stmt =null;
	PreparedStatement pstmt = null;  //input ���ֱ�
	//PreparedStatement : ? �� ���ڷ� �ν�!
	
	//��ȸ(select) ����� �����ϱ� ���� ���� ����
	ResultSet rs = null;    // input ���ֱ�
	
//DB ������ ���� �޼ҵ�
	public void connect() {
		con = DBCon.DBConnect();
		//DBConŬ������ DBConnect()�޼ҵ��� ���ϰ� (con)��
		// con �� ��ڴ�.
	}
	
	// DB�������� //--������������ �����ϰ� ��������
	public void conClose() {
		
		try {
			con.close();            // con.close���� ���ٴ��� try catch�� ����
			System.out.println("DB���� ����!");
		} catch (SQLException se) {   //sql exception ����
			se.printStackTrace();
		}
	}
	// �л������ ���� �޼ҵ� insert --stu_main����  sql.insert(stu) Ŭ����
	// insert(StuDTO stu) : �Ķ���ͷ� StuDTO�� ������ �����´�.
	public void insert(StuDTO stu) {
		String sql = "INSERT INTO STUDTO VALUES(?,?)";
		
		//stu(�л�����)���� con(DB����) �� Ȯ��
		System.out.println("�л����� : " + stu);
		System.out.println("DB���� : " + con);
	
		//stmt = con.createStatement();
		
		try {
			pstmt = con.prepareStatement(sql); //try catch
			
			//���ڴ� ����ǥ �������, ����ǥ �ȿ� �� ����
			pstmt.setString(1, stu.getStuName());  // ù��° ? ǥ
			pstmt.setInt(2, stu.getStuAge());		// �ι�° ? ����ǥ�ȿ� �ְڴ�
		
			
			int count = pstmt.executeUpdate();
					
					
			if (count > 0 ) {
				System.out.println("�л���� ����!");
			}else {
				System.out.println("�л����  ����!");
			}
			
			
			//try - catch - finally�� ��Ʈ!
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			// try : ���������� �۵��Ҷ�
			// catch : ������ �߻� ( ����ó���� �߻��Ҷ�)
			// Exception : ����ó��
			// finally : ���������� �۵��ϰų� ����ó���� �߻��ص�
			//			  ������� ������ �۵�
			
			try {
				pstmt.close();  //try catch
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	// �л������� ��ȸ�ϴ� select () �޼ҵ�
	public void select() { //you don't need to put any inform in here
		String sql ="SELECT* FROM STUDTO";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i =1;
			while(rs.next()) {  //��ȸ�� �������� ������ŭ �ݺ��� ����
								//Cardinality(Tuple, Record, 
				System.out.println(i +"��° �л� ����");
				System.out.println("�̸� : " + rs.getString(1));
				System.out.println("���� : " + rs.getInt(2));
				System.out.println();
				i++;
			}
		
		}catch (SQLException se) {
			se.printStackTrace();
		}finally {
			try {
			pstmt.close();
			rs.close();
		}catch (SQLException se) {
			se.printStackTrace();
		}
	
		}
		
	}
	// �л����� ���� �޼ҵ� update()
	//update (StuDTO stu) : �޼ҵ� �ȿ� StuDTO������ ������ ����
	public void update(StuDTO stu) {
		System.out.println("stu���� : " + stu);
		System.out.println("con : " + con);
		
		String sql = "UPDATE STUDTO SET STUAGE=?"
					+"WHERE STUNAME=?";
				
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stu.getStuAge());
			pstmt.setString(2,stu.getStuName());
			int count = pstmt.executeUpdate();
					
			if(count > 0) {
				System.out.println("�л����� ��������!");
			}else {
				System.out.println("�л����� ��������!");
			}
		
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	// �л����� ���� �޼ҵ� delete
	//delete(string sName) : �޼ҵ� �ȿ� String Ÿ���� sName������ ������ �ִ�.
	public void delete(String dName) {
		String sql = "DELETE STUDTO WHERE STUNAME=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,dName);
			
			int count = pstmt.executeUpdate();
			
			System.out.println("count ��� : " + count);
		
			if (count >0) {
				System.out.println("�л����� ��������!");
			}else {
				System.out.println("�л����� ��������!");
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
	
}