package bank;

import java.sql.*;

public class BankDAO {

	//DB������ ���� ���� ����
	Connection conn = null;
	
	//������ ������ ���� ���� ����
	PreparedStatement pstmt = null;
	
	//��ȸ����� �����ϱ� ���� ���� ����
	ResultSet rs = null;
	
	//DB������ ���� �޼ҵ� connect()
	public void connect() {
		conn = DBC.DBConnect();
	}
	
	//DB���� ������ ���� �޼ҵ� conClose()
	public void conClose() {
		try {
			conn.close();
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
	}
	
	//����ȣ�� �����ϱ� ���� �޼ҵ� clientNumber()
	public int clientNumber() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT COUNT(*) FROM BANK";
		int cNumber = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
					
			if (rs.next()) {
				cNumber = rs.getInt(1);
			} // rs ���� cNumber�� �ְڴ�.
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		
		return cNumber;
		
	}
	// �������� �����ϱ� ���� �޼ҵ� insertClient()
	public void insertClient(BankDTO client) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO BANK VALUES(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, client.getClientNumber());
			pstmt.setString(2,client.getcName());
			pstmt.setString(3, client.getAccountNumber());
			pstmt.setInt(4, client.getBalance());
			// ?�� �־��ֱ�
			
			int result = pstmt.executeUpdate();
			
			if (result >0) {
				System.out.println("�� ��� ����!");
			} else {
				System.out.println("�� ��� ����!");
			}
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		
	}
	
	//�Ա� �޼ҵ� deposit()
	public void deposit(BankDTO client) {
		// TODO Auto-generated method stub
		
		System.out.println("�Է��� ���¹�ȣ�� �Աݾ� Ȯ��");
		System.out.println(client);
		
		String sql = "UPDATE BANK SET BALANCE  = BALANCE + ? WHERE ACCOUNTNUMBER = ?";
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, client.getBalance());
			pstmt.setNString(2, client.getAccountNumber());
			
			int result = pstmt.executeUpdate();
			//��¸�������	//�� �κи� �����ͺ��̽��� �Է�
			
			if(result > 0) {
				System.out.println("�Աݼ���!");
			}else {
				System.out.println("�Աݽ���");
			}
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		}
	

	// ��� �޼ҵ� withdraw()  �����ϱ�

	public void withdraw(String accountNumber, int balance) {
	// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
	
		
		String sql = "UPDATE BANK SET BALANCE  = BALANCE - ? WHERE ACCOUNTNUMBER = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, balance);
			pstmt.setString(2, accountNumber);
			
			int result = pstmt.executeUpdate();
			//��¸�������	//�� �κи� �����ͺ��̽��� �Է�
			
			if(result > 0) {
				System.out.println("��ݼ���!");
			}else {
				System.out.println("��ݽ���");
			}
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}

		
		
	}

	//�ܾ���ȸ �޼ҵ� ���� - �տ� balance(int����)�� �ٿ��ִ� void���ƴ�int�޼ҵ尡 ������
	public int checkBalance(String accountNumber) {
		// TODO Auto-generated method stub
		
		String sql ="SELECT BALANCE FROM BANK WHERE ACCOUNTNUMBER =?";
		int balance = 0;
			
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountNumber);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				balance = rs.getInt(1);
				// balance = re.getInt("BALANCE");
			}
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		
		return balance;
	}



	
	
	//�۱ݰ��� üũ�ϱ�
//	public String checkAccount(String accountNumber) {
//		// TODO Auto-generated method stub
//		
//		String sql ="SELECT accountNumber FROM BANK WHERE ACCOUNTNUMBER =?";
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, accountNumber);
//			
//		} catch (SQLException se) {
//			se.printStackTrace();
//		}
//		
//		
//		return null;
//	}
//	
	
	
	
	// ������ȸ�� �ϴ� �޼ҵ� checkAccount()
	public boolean checkAccount(String accountNumber) {// ������Ÿ���� ���ƾ��ϳ�   �ں����� �޶� ��
		// TODO Auto-generated method stub
		String sql = "SELECT ACCOUNTNUMBER FROM BANK WHERE ACCOUNTNUMBER=?";
		
		boolean cAccount = false;   // �׳� ó������ cAccount ���� false�� ��������
									// üũ�ϰ���� ���¸� ���� ���� ���۽�Ű�� rs ���� ������� 
									// if�� rs�ְ� �� �����Ҷ� �׶����� üũ �����Ҽ��ֵ���!
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountNumber);
			rs = pstmt.executeQuery(); // ���� ����
			//set ������ ������ rs ����
			
			/*
			 *  executeQuery �� executeUpdate �� ����
			 *   executeQuery�� result set(rs)�� ����� sql������ ���, �ַ� SELECT�� �����Ҷ�
			 *   executeUpdate�� INSERT �� UPDATE�� ���� DDL�̳�DML�� �����Ҷ� ���
			 */
			
			// ����������� ������ rs�� �Ǵ°��� (result set)
			if(rs.next()) { // [re.next()] ��� ���� �����Ҷ� if�� ����� -> cAccount�� true����!
				cAccount= true;
			}
			
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();   //�ƹ��͵� ����
		}
		
		return cAccount;//cAccount �� [true �ų� false�ų�] �� return��
						// ���������� true ������ false
	}

	
	//�۱ݸ޼ҵ� send()
	// ������ ��� ���¹�ȣ, �޴»�����¹�ȣ, �۱ݾ��� ������ �Ű������� ��Ƽ� �Ѿ��
	public void send(String sAccountNumber, String rAccountNumber, int balance) {
		// TODO Auto-generated method stub
		// �޴� ����� ���� +	 : �Ա�
		// ������ ����� ���� - : ���
		
		withdraw1(sAccountNumber, balance);
		deposit1(rAccountNumber, balance);
		System.out.println("�۱� ����!");
	}
	
	
	public void withdraw1(String accountNumber, int balance) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			
			String sql = "UPDATE BANK SET BALANCE  = BALANCE - ? WHERE ACCOUNTNUMBER = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, balance);
				pstmt.setString(2, accountNumber);
				
				pstmt.executeUpdate();
				
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}
	}
			
			public void deposit1(String accountNumber, int balance) {
				// TODO Auto-generated method stub
					// TODO Auto-generated method stub
					
					String sql = "UPDATE BANK SET BALANCE  = BALANCE + ? WHERE ACCOUNTNUMBER = ?";
					
					try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, balance);
						pstmt.setString(2, accountNumber);
						
						 pstmt.executeUpdate();
						
					} catch (SQLException se) {
						// TODO Auto-generated catch block
						se.printStackTrace();
					}
	
	
	
	
			
	
	
	}
			

}//end class

