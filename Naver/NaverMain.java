package Naver;

import java.util.Scanner;

public class NaverMain {
//프론트엔드, 나중에 웹 페이지로 대체
	public static void main(String[] args) {
		
		//서버를 개발하는 NaverDAO클래스
		NaverDAO server = new NaverDAO();
		
		//회원가입 정보를 담고 있는 NaverDTO클래스
		NaverDTO naver = new NaverDTO();
		
		Scanner sc = new Scanner(System.in);
		
		//프로그램 실행을 위한 변수 run
		boolean run = true;
		
		// 항목을 선택할때 필요한 변수 menu
		int menu = 0;
		
		
		while(run) {
			System.out.println("=======================");
			System.out.println("1.DB접속              2.DB해제");
			System.out.println("3. 회원가입           4.회원조회");
			System.out.println("5. 회원수정           6.회원삭제");
			System.out.println("7. 종료");
			System.out.println("=======================");
			System.out.print("항목 선택>>");
			menu = sc.nextInt();
					
			
			switch(menu) {
			case 1:
				server.connect();
				break;
			case 2:
				server.connClose();
				break;
			case 3:
			System.out.println("회원정보를 입력해주세요!");
				
				System.out.println("아이디>> ");
				String naver_id = sc.next();
				naver.setNaver_id(naver_id);
				
				System.out.println("비밀번호>> ");
				String naver_pass = sc.next();
				
				System.out.println("비밀번호확인>> ");
				String npwc = sc.next();
				
				if(naver_pass.equals(npwc)) {
					System.out.println("사용가능한 비밀번호");
				}else {
					System.out.println("비밀번호가 틀렸습니다.");
					break;
				}
				
				
				System.out.println("이름>> ");
				String naver_name = sc.next();
				naver.setNaver_name(naver_name);
				
				System.out.println("생년월일 ");
				System.out.println("연도>> ");
				String nyear = sc.next();
				
				System.out.println("월>> ");
				String nmon = sc.next();
				
				System.out.println("일>> ");
				String nday = sc.next();
				
				System.out.println("생년월일 확인 :");
				System.out.println(nyear +nmon+nday);
				naver.setNaver_birth(nyear +nmon+nday);
				
				System.out.println("성별>> ");
				String naver_gender = sc.next();
				naver.setNaver_gender(naver_gender);
				
				System.out.println("이메일>> ");
				String naver_email = sc.next();
				naver.setNaver_email(naver_email);
				
				System.out.println("전화번호>> ");
				String naver_phone = sc.next();
				naver.setNaver_phone(naver_phone);
				
				server.memberJoin(naver); 
				// public void memberJoin(NaverDTO 생성
				//server(NaverDAO)의 memberJoin()메소드에 
				//naver(NaverDTO)의 정보를 담아 이동하겠다.
				
				
				server.insert(naver);
				break;
			
			case 4:
				//아이디랑 비밀번호를 입력받아서
				//admin 아이디만 조회를 가능하게끔
				server.memberList();
				break;
				
			case 5:

				System.out.println("변경할 회원아이디>> ");
				naver_id = sc.next();
				naver.setNaver_id(naver_id);
				
				System.out.println("변경할 비밀번호>>");
				naver_pass = sc.next();
				
				System.out.println("비밀번호 확인>>");
				npwc = sc.next();
				
				if(naver_pass.equals(npwc)) {
					System.out.println("사용가능한 비밀번호");
				
				naver.setNaver_pass(naver_pass);
				}else {
					System.out.println("비밀번호가 틀렸습니다.");
					break;
				}
				System.out.println("변경할 이름>>");
				naver_name = sc.next();
				naver.setNaver_name (naver_name);
				
				System.out.println("생년월일 ");
				System.out.println("연도>> ");
				nyear = sc.next();
			
				
				System.out.println("월>> ");
				nmon = sc.next();
				
				System.out.println("일>> ");
				nday = sc.next();
				
				System.out.println("생년월일 확인 :");
				System.out.println(nyear +nmon+nday);
				naver.setNaver_birth(nyear +nmon+nday);
				
				System.out.println("변경할 성별>>");
				naver_gender = sc.next();
				naver.setNaver_gender (naver_gender);
				
				System.out.println("변경할 이메일>>");
				naver_email = sc.next();
				naver.setNaver_email (naver_email);
				
				System.out.println("변경할 전화번호>>");
				naver_phone = sc.next();
				naver.setNaver_phone (naver_phone);
				
			
				
				server.memberModify(naver);
				break;
				
			case 6:
				System.out.println("삭제할 회원정보를 입력해주세요");
				
				System.out.println("삭제할 회원아이디>>");
				String dId = sc.next();
				
				System.out.println("비밀번호>> ");
				String dPw = sc.next();
				
				
				boolean check = server.idCheck(dId,dPw);
				// boolean타입의 변수 check선언
				// server(NaverDAO)에서 dId와 dPw의 정보를 담은
				// boolean타입의 메소드 idCheck생성
				
				if (check) {
					server.memberDelete(dId);
				}else {
					System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
				}
				
				
				break;
			case 7:
				//run 이 true이기 떄문에 반복문이 실행
				//run이 false가 되면 반복문 종료
				run = false;
				System.out.println("프로그램을 종료합니다");
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			} //end switch
			
		}//end while
		
		
		
		
		
		
		
	}//end main

}//end class
