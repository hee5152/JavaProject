package Jdbc0120;

import java.util.Scanner;

public class Stu_Main {

	public static void main(String[] args) {
		// SQL문을 실행하기 위한 객체 선언
		Stu_SQL sql = new Stu_SQL();
		
		//stu 클래스
		StuDTO stu = new StuDTO();
		
		//정보를 입력받기 위한sc 객체 선언
		Scanner sc = new Scanner(System.in); //scanner- input
		
		boolean run = true;
		int menu = 0;
		
		while(run) {
			System.out.println("===========================");
			System.out.println("1.DB접속              2.DB해제");
			System.out.println("3. 학생등록           4.학생조회");
			System.out.println("5. 학생수정           6.학생삭제");
			System.out.println("7. 종료");
			System.out.println("===========================");
			System.out.println("항목 선택>>");
			menu = sc.nextInt();
					
			// switch 문 작성
			switch(menu) {
			case 1:
				sql.connect();
				 //db 접속 명령 넣기
				break;
			case 2:
				sql.conClose();
				//db 해제명령넣기
				break;
			case 3:
				System.out.println("학생정보를 입력해주세요!");
				
				System.out.println("이름>> ");
				String stuName = sc.next();
				
				System.out.println("나이>> ");
				int stuAge = sc.nextInt();
				
				stu.setStuName (stuName);
				stu.setStuAge(stuAge);
				
				sql.insert(stu);
				break;
			
			case 4:
				sql.select();
				break;
				
			case 5 :
				System.out.println("수정할 학생정보를 입력해주세요");
				
				System.out.println("변경할 학생이름>> ");
				stuName = sc.next();
				
				System.out.println("변경할 나이>>");
				stuAge = sc.nextInt();
				
				
				stu.setStuAge(stuAge);
				stu.setStuName (stuName);

				
				sql.update(stu);
				
				break;
			case 6 :
				
				System.out.println("삭제할 학생정보를 입력해주세요");
				
				System.out.println("삭제할 학생이름>> ");
				String dName = sc.next();
				
			
				stu.delete(dName);

		
				
				break;
			case 7 :
				run = false;
				System.out.println("프로그램을 종료합니다");
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			} //end switch
		}	//end while
		
		System.out.println("시스템을 종료합니다.");
	

	}

}
