package Naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NaverDAO {
	//DAO (Data Access Object) : 데이터 접근 객체
	//-백엔드서버, ojdbc를 사용하여 SQL을 사용 할 수있다.
	
	// DB접속을 위한 변수conn선언
	//conn은 DB연결상태 뜻한다.
	Connection conn = null;

	//쿼리문 전송을 위한 변수
	//Statement stmt = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;

	//조회(selcect) 결과를 저장하기 위한 변수 rs 선언
	ResultSet rs = null; //(input)헤주기

	
	//항목1. DB접속 메소드 connect()
	public void connect() {
		conn = NaverDBCon.DBConnect();
		// conn에 DBC클래스의 내장 메소드의 리턴값(con)을 저장한다.
		
	}
	//항목2. DB접속해제 메소드 conClose()
	public void connClose() {
		try {
			conn.close();
			//Connection클래스의 내장메소드 close()를 사용하여 접속을 해제한다
			
			System.out.println("DB접속해제!");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	//항목3. 회원가입 메소드 memberJoin()
	public void insert(NaverDTO naver) {
		String sql = "INSERT INTO NAVER VALUES(?,?,?,?,?,?,?)";
		//네이버테이블에 정보를 넣자 7개
		
		System.out.println("학생정보 :" + naver);
		System.out.println("DB연결 : " + conn);

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, naver.getNaver_id());
			pstmt.setString(2, naver.getNaver_pass());
			pstmt.setString(3, naver.getNaver_name());
			pstmt.setString(4, naver.getNaver_birth());
			pstmt.setString(5, naver.getNaver_gender());
			pstmt.setString(6, naver.getNaver_email());
			pstmt.setString(7, naver.getNaver_phone());

			//7개의 정보를 다 입력 한 후 데이터베이스 실행
			//pstmt.executeUpdate();
			
			//1. int result
//			int result = pstmt.executeUpdate();	
//			
//			if (result > 0) {
//				System.out.println("회원가입 성공!");
//			} else {
//				System.out.println("회원가입 실패!");
//			}
			
			
			//2. boolean result2
			boolean result2 = pstmt.execute();
			System.out.println("성공여부 : " +result2);
			
			if(result2) {
				System.out.println("회원가입 실패!");
			}else {
				System.out.println("회원가입 성공!");
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
	
	
	//항목4. 회원목록 조회하는 메소드 memberList()
	public void memberList() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT* FROM NAVER";
		System.out.println("DB접속x : conn 값?" + conn);
		

		try {
			pstmt = conn.prepareStatement(sql); //내장객체 - sql문을 pstmt에 담겠다
			
			//pstmt. setStirng(1,naver.getNaver_id())
			
			rs = pstmt.executeQuery(); //String sql = "SELECT* FROM NAVER"; 이거를 실제로 실행시켜줌
			// execute => boolean타입 반환
			// executeUpdate => int 타입 반환
			// executeQuery => ResultSet타입 반환
			
			int i = 1;
			while (rs.next()) {

				System.out.println(i + "번째회원 정보");
				System.out.println("아이디 : " + rs.getString(1));
				System.out.println("비밀번호: " + rs.getString(2));
				System.out.println("이름 :" + rs.getString(3));
				System.out.println("생년월일 : " + rs.getString(4));
				System.out.println("성별 : " + rs.getString(5));
				System.out.println("이메일 :" + rs.getString(6));
				System.out.println("전화번호 : " + rs.getString(7));
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

	
	//항목5. 회원목록 수정하는 메소드 memberModify()
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
			//이 애들이 ? 안에 들어감
			
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("회원정보 수정성공!");
			} else {
				System.out.println("회원정보 수정실패!");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	//항목6-1. 회원정보를 삭제하기 위해
	//아이디와 비밀번호를 검사하는 메소드idCheck()
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
		
		
			//while(rs.next())는 안쓸거임
			//rs의 결과값이 1개이기 때문에 while이 아닌 if를 사용
			
			if(rs.next()) {
				checkResult = true;
			}else {
				checkResult = false; //안써줘도 상관없음
			}
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		
		return checkResult;
	}
	
	//항목 6. 회원정보를 삭제하는 메소드 memberDelete()
	
	public void memberDelete(String dId) {
		// TODO Auto-generated method stub
		String sql = "DELETE NAVER WHERE NAVER_ID=?";
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1,dId);
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("회원정보 삭제성공!");
			}else {
				System.out.println("회원정보 삭제실패!");
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
