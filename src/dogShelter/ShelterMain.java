package dogShelter;

import java.util.Scanner;

public class ShelterMain {

	public static void main(String[] args) {
		boolean op = true;
		ShelterDTO shelter = new ShelterDTO();
		ShelterDAO server = new ShelterDAO();
		Scanner scan = new Scanner(System.in);
		
		
		
		while(op) {
			System.out.println("===============================");
			System.out.println("1.로그인  2.회원가입  3.유기견메뉴  4.종료");
			System.out.println("===============================");
			System.out.print("메뉴를선택하세요 >> ");
			int menu = scan.nextInt();
			server.connect(); // DB connect
			
			switch(menu) {
			case 1: System.out.print("아이디>> ");
					String sId = scan.next();
					System.out.print("비밀번호 >> ");
					String sPw = scan.next();
					boolean check = server.idCheck(sId,sPw);
					if(check) {
						System.out.println("=========== Menu =============");
						System.out.println("1.유기견 조회  2.후원하기  3.로그아웃");
						System.out.println("===============================");
						System.out.print("메뉴를 선택하세요>> ");
						int subMenu = scan.nextInt();
						boolean op1 = true;
						
						while(op1) {
							switch(subMenu) {
							case 1: System.out.println("========= Search Dog ==========");
									System.out.println("1.전체조회  2.품종별 조회  3.뒤로가기");
									System.out.println("===============================");
									System.out.print("메뉴를 선택하세요 >> ");
									int search = scan.nextInt();
									boolean op2 = true;
									
									while(op2) {
										switch(search) {
										case 1: server.dogList(); break;
										case 2: System.out.println("========== Breed ===========");
												System.out.println("1.품종1  2.품종2  3.뒤로가기");
												System.out.println("============================");
												System.out.print("원하는 품종을 선택하세요 >> ");
												int dNum = scan.nextInt();
												String breed = null;
												if(dNum==1) {
													breed = "breed1";
													server.dogListByBreed(breed);
												}
												else if(dNum==2) {
													breed = "breed2";
													server.dogListByBreed(breed);
												}
												else {break;}
												
												break;
										case 3: System.out.println("goto previous menu"); op2 = false; break;
										default: System.out.println("Re-enter the menu."); break;
										}
									}
									break;
							case 2: System.out.print("How much do you donate? ");
									int money = scan.nextInt();
									server.donation(money); 
									break;
									
							case 3: System.out.println("Log out!"); op1=false; break;
							default: System.out.println("Re-enter the menu."); break;
							}
						}
					}else {
						System.out.println("You entered wrong ID or Password.");
					}
					break;
			case 2: System.out.println("회원정보입력");
					System.out.print("아이디 >>");
					sId = scan.next();
					shelter.setsId(sId);
					System.out.print("비밀번호>>");
					sPw = scan.next();
					System.out.print("비밀번호확인>>");
					String sPwc = scan.next();
					if(sPw.equals(sPwc)) {
						System.out.println("Correct PW");
						shelter.setsPw(sPw);
					}else {
						System.out.println("Incorrect PW");
					}
					System.out.print("이름>>");
					String sName = scan.next();
					shelter.setsName(sName);
					System.out.print("주소>>");
					String sAddr = scan.next();
					shelter.setsAddr(sAddr);
					System.out.print("이메일 >>");
					String sEmail = scan.next();
					shelter.setsEmail(sEmail);
					System.out.print("전화번호 >>");
					String sPhone = scan.next();
					shelter.setsPhone(sPhone);
					
					server.memberJoin(shelter);
					break;
			case 3: System.out.print("관리자아이디>>"); //id = admin
					String adminId = scan.next();
					System.out.print("비밀번호>>");
					String adminPW = scan.next();
					if(adminId.equals("admin")) {
						server.dogMenu(); 
					}else {
						System.out.println(" 관리자기아닙니다.");
					}
					
					break;
			case 4: op = false; System.out.println("이용해주셔서 감사합니다."); break;
			default: System.out.println("다시 메뉴를 선택해주세요"); break;
			}
			server.conClose(); // DB disconnect
		}
	}

}

