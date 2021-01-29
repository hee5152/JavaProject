package MydogShelter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyShelterDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void connect() {
		// TODO Auto-generated method stub
		
	}

	public void memberJoin(MyShelterDTO shelter) {
		// TODO Auto-generated method stub
String sql = "INSERT INTO SHELTER VALUES(?,?,?,?,?,?)";
		
		System.out.println("회원정보 : "+shelter);
		System.out.println("DB연결 : "+conn);
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setNString(1, shelter.getsId());
			pstmt.setNString(2, shelter.getsPw());
			pstmt.setNString(3, shelter.getsName());
			pstmt.setNString(4, shelter.getsAddr());
			pstmt.setNString(5, shelter.getsEmail());
			pstmt.setNString(6, shelter.getsPhone());
			
			boolean result2 = pstmt.execute();
			if (!result2) {
				System.out.println("회원등록 성공");
			}else {
				System.out.println("회원등록 실패");
			}
		}catch (SQLException se){
			se.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
		}
	}
	

	public void addDog(MyDogDTO dog) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO DOG VALUES(?,?,?,?,?,?)";
		
		System.out.println("유기견 정보 :" +dog);
		System.out.println("DB연결 : " + conn);
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setNString(1, dog.getdNo());
			pstmt.setNString(2, dog.getdName());
			pstmt.setInt(3, dog.getdAge());
			pstmt.setNString(4, dog.getdSex());
			pstmt.setNString(4, dog.getdBreed());
			pstmt.setNString(4, dog.getdRegitDate());
			
			boolean result2 = pstmt.execute();
			if (!result2) {
				System.out.println("유기견등록 성공");
			}else {
				System.out.println("유기견등록 실패");
			}
		}catch (SQLException se){
			se.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
		}
		
		
	}

	public boolean dogCheck(String modDNo) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT DNO FROM DOG WHERE DNO = ?";
		boolean checkResult = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, modDNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				checkResult = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return checkResult;
	}

	

	public void modifyDog(MyDogDTO dog) {
		// TODO Auto-generated method stub
		String sql = "UPDATE DOG SET DNO=?,DNAME=?, DAGE=?, DBREED=?, DSEX=?, DREGITDATE=? WHERE DNO=?";
		
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setNString(1, dog.getdNo());
			pstmt.setNString(2, dog.getdName());
			pstmt.setInt(3, dog.getdAge());
			pstmt.setNString(4, dog.getdBreed());
			pstmt.setNString(5, dog.getdSex());
			pstmt.setNString(6, dog.getdRegitDate());
			
			int result = pstmt.executeUpdate();
			if (result>0) {
				System.out.println("유기견정보 수정 성공");
			}else {
				System.out.println("유기견정보 수정 실패");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public void deleteDog(String delDNo) {
		// TODO Auto-generated method stub
		
		String sql = "DELETE DOG WHERE DNO=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setNString(1, delDNo);
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("유기견 삭제성공");
			}else {
				System.out.println("유기견 삭제실패");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
		}
		
	}


//로그인아이디 비번 체크하기
	public boolean idpwCheck(String sId, String sPw) {
		// TODO Auto-generated method stub
		String sql = "SELECT SID FROM SHELTER WHERE SID, SELECT SPW FROM SHLETER WHERE SPW = ?";
		boolean idResult = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, sId);
			pstmt.setNString(2, sPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				idResult = true;
			}
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		
		return idResult;
	}

	// 자신이 회원 탈퇴할때
	public boolean idpwCheck1(String delId, String delPw) {
		// TODO Auto-generated method stub
		String sql = "SELECT SID FROM SHELTER WHERE SID=? AND SPW = ?";
		boolean idResult = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, delId);
			pstmt.setNString(2, delPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				idResult = true;
			}
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		
		return idResult;
	}
	
	
// 관리자가 회원 삭제할때

	public boolean idCheck(String delId) {
		// TODO Auto-generated method stub
		String sql = "SELECT SID FROM SHELTER WHERE SID=?";
		boolean checkResult = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,delId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				checkResult = true;
				
			}else {
				checkResult = false;
			}
			
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		
		return checkResult;
	}

	public void deleteId(String delId) {
		// TODO Auto-generated method stub
		
		String sql = "DELETE SHLETER WHERE SID=?";
		boolean idResult = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setNString(1, delId);
			

			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("삭제성공");
				idResult = true;
			}else {
				System.out.println("삭제실패");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
		
		}
	}
	
	


/// 마이페이지 1. 내정보 보기
	public void myinfo(MyShelterDTO shelter) {
		// TODO Auto-generated method stub
		
String sql = "SELECT * FROM SHELTER WHERE SID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
					
			int i =0;
			while(rs.next()) {
				System.out.println(i+"번째 회원 정보");
				System.out.println("아이디 :" + rs.getString(1));
				System.out.println("비밀번호 :" + rs.getString(2));
				System.out.println("이름 :" + rs.getString(3));
				System.out.println("주소 :" + rs.getString(4));
				System.out.println("이메일 :" + rs.getString(5));
				System.out.println("전화번호 :" + rs.getString(6));
				System.out.println();
				i++;
			}
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
		}
	}
// 강아지 리스트 전체보기
	public void dogList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM DOG";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			int i =0;
			while (rs.next()) {
				System.out.println(i+"번째 강아지 정보");
				System.out.println("공고번호 : " + rs.getString(1));
				System.out.println("이름 : " + rs.getString(2));
				System.out.println("추정나이 : " + rs.getString(3));
				System.out.println("품종 : " + rs.getString(4));
				System.out.println("성별 : " + rs.getString(5));
				System.out.println("접수일자 : " + rs.getString(6));
				System.out.println();
				i++;
			
			}
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		
	}
	// 품종별로 강아지 보기
	public void dogListByBreed(String breed) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM DOG WHERE DBREED";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			int i =0;
			while (rs.next()) {
				System.out.println(i+"번째 강아지 정보");
				System.out.println("공고번호 : " + rs.getString(1));
				System.out.println("이름 : " + rs.getString(2));
				System.out.println("추정나이 : " + rs.getString(3));
				System.out.println("품종 : " + rs.getString(4));
				System.out.println("성별 : " + rs.getString(5));
				System.out.println("접수일자 : " + rs.getString(6));
				System.out.println();
				i++;
			
			}
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		
	}
	
	// 후원하기
	public void donation(int money) {
		// TODO Auto-generated method stub
		String sql = "UPDATE DONATE SET DONATION = DONATION + ?"
					+ "WHERE DNO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,money);
			pstmt.setString(2,sId1);
			

			public void deposit(MyShelterDTO shelter) {
				// TODO Auto-generated method stub
				
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void memberList(MyShelterDTO shelter) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM SHELTER";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
					
			int i =0;
			while(rs.next()) {
				System.out.println(i+"번째 회원 정보");
				System.out.println("아이디 :" + rs.getString(1));
				System.out.println("비밀번호 :" + rs.getString(2));
				System.out.println("이름 :" + rs.getString(3));
				System.out.println("주소 :" + rs.getString(4));
				System.out.println("이메일 :" + rs.getString(5));
				System.out.println("전화번호 :" + rs.getString(6));
				System.out.println();
				i++;
			}
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
		}
	}





		
	}


