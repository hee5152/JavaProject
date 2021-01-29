package Jdbc0120;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Stu_SQL {
//필드값선언
	// DB접속을 위한 변수 con 선언
	Connection con = null; //connection input 해주기
	
	// 쿼리문 전송을 위한 변수 선언   //java sql로 input 해주기
	Statement stmt =null;
	PreparedStatement pstmt = null;  //input 해주기
	//PreparedStatement : ? 를 문자로 인식!
	
	//조회(select) 결과를 저장하기 위한 변수 선언
	ResultSet rs = null;    // input 해주기
	
//DB 접속을 위한 메소드
	public void connect() {
		con = DBCon.DBConnect();
		//DBCon클래스의 DBConnect()메소드의 리턴값 (con)을
		// con 에 담겠다.
	}
	
	// DB접속해제 //--에러막기위해 해제하고 시작하자
	public void conClose() {
		
		try {
			con.close();            // con.close쓰고 밑줄눌러 try catch문 생성
			System.out.println("DB접속 해제!");
		} catch (SQLException se) {   //sql exception 약자
			se.printStackTrace();
		}
	}
	// 학생등록을 위한 메소드 insert --stu_main에서  sql.insert(stu) 클릭함
	// insert(StuDTO stu) : 파라미터로 StuDTO의 내용을 가져온다.
	public void insert(StuDTO stu) {
		String sql = "INSERT INTO STUDTO VALUES(?,?)";
		
		//stu(학생정보)값과 con(DB연결) 값 확인
		System.out.println("학생정보 : " + stu);
		System.out.println("DB연결 : " + con);
	
		//stmt = con.createStatement();
		
		try {
			pstmt = con.prepareStatement(sql); //try catch
			
			//숫자는 물음표 순서대로, 물음표 안에 들어갈 내용
			pstmt.setString(1, stu.getStuName());  // 첫번째 ? 표
			pstmt.setInt(2, stu.getStuAge());		// 두번째 ? 물음표안에 넣겠다
		
			
			int count = pstmt.executeUpdate();
					
					
			if (count > 0 ) {
				System.out.println("학생등록 성공!");
			}else {
				System.out.println("학생등록  실패!");
			}
			
			
			//try - catch - finally가 세트!
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			// try : 정상적으로 작동할때
			// catch : 오류가 발생 ( 예외처리가 발생할때)
			// Exception : 예외처리
			// finally : 정상적으로 작동하거나 예외처리가 발생해도
			//			  상관없이 무조건 작동
			
			try {
				pstmt.close();  //try catch
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	// 학생정보를 조회하는 select () 메소드
	public void select() { //you don't need to put any inform in here
		String sql ="SELECT* FROM STUDTO";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i =1;
			while(rs.next()) {  //조회된 데이터의 갯수만큼 반복문 실행
								//Cardinality(Tuple, Record, 
				System.out.println(i +"번째 학생 정보");
				System.out.println("이름 : " + rs.getString(1));
				System.out.println("나이 : " + rs.getInt(2));
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
	// 학생정보 수정 메소드 update()
	//update (StuDTO stu) : 메소드 안에 StuDTO정보를 가지고 있음
	public void update(StuDTO stu) {
		System.out.println("stu정보 : " + stu);
		System.out.println("con : " + con);
		
		String sql = "UPDATE STUDTO SET STUAGE=?"
					+"WHERE STUNAME=?";
				
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stu.getStuAge());
			pstmt.setString(2,stu.getStuName());
			int count = pstmt.executeUpdate();
					
			if(count > 0) {
				System.out.println("학생정보 수정성공!");
			}else {
				System.out.println("학생정보 수정실패!");
			}
		
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	// 학생정보 삭제 메소드 delete
	//delete(string sName) : 메소드 안에 String 타입의 sName정보를 가지고 있다.
	public void delete(String dName) {
		String sql = "DELETE STUDTO WHERE STUNAME=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,dName);
			
			int count = pstmt.executeUpdate();
			
			System.out.println("count 결과 : " + count);
		
			if (count >0) {
				System.out.println("학생정보 삭제성공!");
			}else {
				System.out.println("학생정보 삭제실패!");
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