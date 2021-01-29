package bank;

import java.sql.*;

public class BankDAO {

	//DB접속을 위한 변수 선언
	Connection conn = null;
	
	//쿼리문 전송을 위한 변수 선언
	PreparedStatement pstmt = null;
	
	//조회결과를 저장하기 위한 변수 선언
	ResultSet rs = null;
	
	//DB접속을 위한 메소드 connect()
	public void connect() {
		conn = DBC.DBConnect();
	}
	
	//DB접속 해제를 위한 메소드 conClose()
	public void conClose() {
		try {
			conn.close();
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
	}
	
	//고객번호를 생성하기 위한 메소드 clientNumber()
	public int clientNumber() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT COUNT(*) FROM BANK";
		int cNumber = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
					
			if (rs.next()) {
				cNumber = rs.getInt(1);
			} // rs 값을 cNumber에 넣겠다.
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		
		return cNumber;
		
	}
	// 고객정보를 저장하기 위한 메소드 insertClient()
	public void insertClient(BankDTO client) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO BANK VALUES(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, client.getClientNumber());
			pstmt.setString(2,client.getcName());
			pstmt.setString(3, client.getAccountNumber());
			pstmt.setInt(4, client.getBalance());
			// ?에 넣어주기
			
			int result = pstmt.executeUpdate();
			
			if (result >0) {
				System.out.println("고객 등록 성공!");
			} else {
				System.out.println("고객 등록 실패!");
			}
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		
	}
	
	//입금 메소드 deposit()
	public void deposit(BankDTO client) {
		// TODO Auto-generated method stub
		
		System.out.println("입력한 계좌번호와 입금액 확인");
		System.out.println(client);
		
		String sql = "UPDATE BANK SET BALANCE  = BALANCE + ? WHERE ACCOUNTNUMBER = ?";
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, client.getBalance());
			pstmt.setNString(2, client.getAccountNumber());
			
			int result = pstmt.executeUpdate();
			//출력만을위한	//이 부분만 데이터베이스에 입력
			
			if(result > 0) {
				System.out.println("입금성공!");
			}else {
				System.out.println("입금실패");
			}
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		}
	

	// 출금 메소드 withdraw()  선언하기

	public void withdraw(String accountNumber, int balance) {
	// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
	
		
		String sql = "UPDATE BANK SET BALANCE  = BALANCE - ? WHERE ACCOUNTNUMBER = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, balance);
			pstmt.setString(2, accountNumber);
			
			int result = pstmt.executeUpdate();
			//출력만을위한	//이 부분만 데이터베이스에 입력
			
			if(result > 0) {
				System.out.println("출금성공!");
			}else {
				System.out.println("출금실패");
			}
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}

		
		
	}

	//잔액조회 메소드 생성 - 앞에 balance(int값인)를 붙여주니 void가아닌int메소드가 생성됨
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



	
	
	//송금계좌 체크하기
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
	
	
	
	// 계좌조회를 하는 메소드 checkAccount()
	public boolean checkAccount(String accountNumber) {// 데이터타임은 같아야하나   뒤변수는 달라도 됨
		// TODO Auto-generated method stub
		String sql = "SELECT ACCOUNTNUMBER FROM BANK WHERE ACCOUNTNUMBER=?";
		
		boolean cAccount = false;   // 그냥 처음부터 cAccount 값을 false로 지정해줌
									// 체크하고싶은 계좌를 적고 디비로 전송시키면 rs 값이 생기겠지 
									// if에 rs넣고 값 존재할때 그때부터 체크 실행할수있도록!
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountNumber);
			rs = pstmt.executeQuery(); // 디비로 전송
			//set 나오면 무조건 rs 하자
			
			/*
			 *  executeQuery 와 executeUpdate 의 차이
			 *   executeQuery는 result set(rs)을 만드는 sql문에서 사용, 주로 SELECT문 수행할때
			 *   executeUpdate는 INSERT 나 UPDATE와 같은 DDL이나DML을 실행할때 사용
			 */
			
			// 모오오오오든 정보가 rs가 되는거임 (result set)
			if(rs.next()) { // [re.next()] 라는 값이 존재할때 if가 실행됨 -> cAccount가 true값됨!
				cAccount= true;
			}
			
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();   //아무것도 안함
		}
		
		return cAccount;//cAccount 가 [true 거나 false거나] 가 return됨
						// 계좌있으면 true 없으면 false
	}

	
	//송금메소드 send()
	// 보내는 사람 계좌번호, 받는사람계좌번호, 송금액의 정보를 매개변수로 담아서 넘어옴
	public void send(String sAccountNumber, String rAccountNumber, int balance) {
		// TODO Auto-generated method stub
		// 받는 사람은 돈이 +	 : 입금
		// 보내는 사람은 돈이 - : 출금
		
		withdraw1(sAccountNumber, balance);
		deposit1(rAccountNumber, balance);
		System.out.println("송금 성공!");
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

