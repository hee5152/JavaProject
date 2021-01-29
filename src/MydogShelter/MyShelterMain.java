package MydogShelter;

import java.util.Scanner;

public class MyShelterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyShelterDTO shelter = new MyShelterDTO();
		MyDogDTO	dog 	= new MyDogDTO();
		MyShelterDAO server = new MyShelterDAO();
		
		Scanner scan = new Scanner(System.in);
		boolean op = true;
		
		
		while(op) {
			System.out.println("                                                                                         \r\n" + 
					",------.                                                      ,----.     ,---.  ,------. \r\n" + 
					"|  .-.  \\  ,---. ,--.--.,--. ,--.,---.  ,---.  ,---.  ,--,--.'  .-./    /  O  \\ |  .---' \r\n" + 
					"|  |  \\  :| .-. :|  .--' \\  '  /| .-. :| .-. || .-. |' ,-.  ||  | .---.|  .-.  ||  `--,  \r\n" + 
					"|  '--'  /\\   --.|  |     \\   ' \\   --.' '-' '' '-' '\\ '-'  |'  '--'  ||  | |  ||  `---. \r\n" + 
					"`-------'  `----'`--'   .-'  /   `----' `---' .`-  /  `--`--' `------' `--' `--'`------' \r\n" + 
					"                        `---'                 `---'                                      ");
			System.out.println("===============================");
			System.out.println("1.로그인  2.회원가입  3. 관리자  4.종료");
			System.out.println("===============================");
			System.out.print("메뉴를 선택 하세오 >> ");
			int menu = scan.nextInt();
			server.connect(); //DB connect
			
			
			switch(menu) {
			case 1: System.out.print("아이디 >> ");
			String sId = scan.next();
			System.out.print("비밀번호 >> ");
			String sPw = scan.next();
			boolean check = server.idpwCheck(sId,sPw);
			
			if (check) {
				System.out.println("================ Menu ==================");
				System.out.println("1.유기견 조회  2.후원하기 3. 마이페이지 4.로그아웃");
				System.out.println("======================================");
				System.out.print("메뉴를 선택 하세오 >> ");
				int subMenu = scan.nextInt();
				boolean op1 = true;
				
				while (op1) {
					switch(subMenu) {
					case 1:
						System.out.println("================ Search Dog ==================");
						System.out.println("1.전체조회  2.품종별 조회  3.뒤로가기");
						System.out.println("======================================");
						System.out.print("메뉴를 선택 하세오 >> ");
						int dogsearch = scan.nextInt();
						boolean op2 = true;
						
						while (op2) {
							switch(dogsearch) {
							case 1: server.dogList(); break;
							
							case 2: 
								System.out.println("========== Breed ===========");
								System.out.println("1.포메라이언 2.푸들  3.뒤로가기");
								System.out.println("============================");
								System.out.print("원하는 품종을 선택 하세오 >> ");
								int dNum = scan.nextInt();
								String breed = null;
								
								if(dNum==1) {
									breed = "포메라이언";
									server.dogListByBreed(breed);
								}
								else if (dNum==2) {
									breed = "푸들";
									server.dogListByBreed(breed);
								}
								else {
									break;
								}
								
							case 3:System.out.println("goto previous menu"); op2 = false; break;
							default: System.out.println("Re-enter the menu."); break;
							}// switch dogsearch
						}// while op2
								
						
						
					case 2: // 후원하기
						
						System.out.print("아이디를입력해주세요 >> ");
						String deId = scan.next();
						
						System.out.print("후원하실 금액을 입력해주세요 >> ");
						int money = scan.nextInt();
						
						shelter.set(deposit);
						shelter.setsId(sId);
						
						server.deposit(shelter);
					
						break;
						
					case 3://마이페이지
						 System.out.println("================= My Page==============");
							System.out.println("1.내정보 보기 2.내정보 수정  3.회원탈퇴  4.뒤로가기");
							System.out.println("===============================");
							System.out.print("메뉴를 선택 하세오 >> ");
							int search = scan.nextInt();
							boolean mypage = true;
							
							while (mypage) {
								switch(search) {
								case 1: // 내정보 보기
									System.out.println("내정보 보기");
									System.out.println("내 아이디 입력");
									sId1 = scan.next();
									
									
									
									
								case 2: // 내 정보 수정
									
									System.out.println("수정할 회원 아이디>>");
									sId1 = scan.next();
									shelter.setsId(sId1);
									
									System.out.println("비밀번호>>");
									sPw = scan.next();
									
									System.out.println("비밀번호>>");
									String sPw2 = scan.next();
									
									if(sPw.equals(sPw2)) {
										System.out.println("사용가능한 비밀번호");
										
									} else {
										System.out.println("비밀번호가 틀렸습니다.");
										break;
									}
									
									System.out.print("이름 >> ");
									String sName = scan.next();
									shelter.setsName(sName);
									
								
									System.out.print("주소 >> ");
									String sAddr = scan.next();
									shelter.setsAddr(sAddr);
									
									System.out.print("이메일 >> ");
									String semail = scan.next();
									shelter.setsEmail(semail);
									
									System.out.print("휴대전화 >> ");
									String sphone = scan.next();
									shelter.setsPhone(sphone);
									
									server.memberJoin(shelter);
									break;
									
									
									////질문 : sql테이블 이름의 중요성 /같아야하는 항목이 있는지
											// 실행안됨 => 테이블 갯수가 같아야한다고 뜸
											// 등록한 회원 보기
									
									
									
								 // 회원탈퇴
								case 3: 

								
								System.out.print("삭제하기 위해 아이디를 입력해주세요>> ");
								String delId = scan.next();
		
								System.out.print("비밀번호를 입력해주세요>> ");
								String delPw = scan.next();
								boolean Check = server.idpwCheck1(delId,delPw);
								
								
								
									if (Check) {
									server.deleteId(delId);
								}else {
									System.out.println("존재하지 않는 아이디입니다.");
								}
							
								
								if(sPw.equals(delPw)) {
									System.out.println("확인되었습니다");
									shelter.setsPw(sPw);
								}else {
									System.out.println("비밀번호가 맞지않습니다.");
								}break;
									
									
								case 4: System.out.println("goto previous menu"); mypage = false; break;
								default: System.out.println("Re-enter the menu."); break;
								}// swtich mypage2
							}//while mypage
						
							
				
					
					}//switch subMenu
					
				}//while op1
			}//if check
			
				
			case 2: // 회원가입
				System.out.println("회원정보 입력");
				System.out.print("아이디 >>");
				sId = scan.next();
				shelter.setsId(sId);
				System.out.print("비밀번호 >>");
				sPw = scan.next();
				System.out.print("비밀번호 확인 >>");
				String sPwc = scan.next();
				if(sPw.equals(sPwc)) {
					System.out.println("Correct PW");
					shelter.setsPw(sPw);
				}else {
					System.out.println("Incorrect PW");
				}
				System.out.print("이름 >>");
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
				
				
				
				
			case 3:
				System.out.println("관리자 아이디>>");
				String adminId = scan.next();
				System.out.println("관리자 비밀번호 >>");
				String adminPw = scan.next();
				
				boolean admin = true;
				if(adminId.equals("admin")) {
					while(admin) {
						System.out.println("================== Dog =================");
						System.out.println("1.유기견 관리 2. 회원관리 3. 로그아웃");
						System.out.println("========================================");
						System.out.print("메뉴를 선택 하세오 >> ");
						int manage = scan.nextInt();
						
						switch(manage) {
						case 1: //1. 유기견 관리 화면
								boolean manadog = true;
								while(manadog) {
								System.out.println("================== Dog =================");
								System.out.println("1.유기견 등록 2.유기견 수정  3.유기견 삭제  4.뒤로가기");
								System.out.println("========================================");
								System.out.print("메뉴를 선택 하세오 >> ");
								int dsearch = scan.nextInt();
							
								
								switch(dsearch) {
								case 1: System.out.print("공고번호(ID) >> ");
										String dNo = scan.next();
										dog.setdNo(dNo);
										
										System.out.print("이름 >> ");
										String dName = scan.next();
										dog.setdName(dName);
										
										System.out.print("추정나이 >>");
										int dAge = scan.nextInt();
										dog.setdAge(dAge);
										System.out.print("품종 >> ");
										String dBreed = scan.next();
										dog.setdBreed(dBreed);
										System.out.print("성별 >> ");
										String dSex = scan.next();
										dog.setdSex(dSex);
										System.out.print("접수날짜 >> ");
										String dRegitDate = scan.next();
										dog.setdRegitDate(dRegitDate);
										
										server.addDog(dog);
										break;
								case 2: System.out.print("수정할 유기견 공고번호(ID) >> ");
										String modDNo = scan.next();
										boolean nCheck = server.dogCheck(modDNo);
										if(nCheck) {
											System.out.print("공고번호(ID) >> ");
											dNo = scan.next();
											dog.setdNo(dNo);
											System.out.print("이름 >> ");
											dName = scan.next();
											dog.setdName(dName);
											System.out.print("추정나이 >>");
											dAge = scan.nextInt();
											dog.setdAge(dAge);
											System.out.print("품종 >> ");
											dBreed = scan.next();
											dog.setdBreed(dBreed);
											System.out.print("성별 >> ");
											dSex = scan.next();
											dog.setdSex(dSex);
											System.out.print("접수날짜 >> ");
											dRegitDate = scan.next();
											dog.setdRegitDate(dRegitDate);
											
											server.modifyDog(dog);
										}else {
											System.out.println("There is no the dog no(id) entered.");
										}
										break;
								case 3: 
										System.out.print("삭제할 유기견 공고번호(ID) >> ");
										String delDNo = scan.next();
										boolean dCheck = server.dogCheck(delDNo);
										if(dCheck) {
											server.deleteDog(delDNo);
										}else {
											System.out.println("There is no the dog no(id) entered.");
										}
										break;
								case 4: System.out.println("goto previous menu"); manadog = false; break;
								default : System.out.println("Re-enter the menu."); break;
								}//switch dog search
							}//switch manadog while
						
		
						case 2: // 회원 관리 화면
							boolean op4 = true;
							while(op4) {
								System.out.println("================== 회원관리 =================");
								System.out.println("1.회원조회  2.회원 삭제  3.뒤로가기");
								System.out.println("========================================");
								System.out.print("메뉴를 선택 하세오 >> ");
								int member = scan.nextInt();
								
								switch(member) {
								case 1: 
									System.out.println("------회원목록-------");
									////// 등록한 회원정보 다 보기
									server.memberList(shelter);
									break;
										
										
								case 2:// 회원 삭제하기
									System.out.print("삭제하기 위해 아이디를 입력해주세요>> ");
									String delId = scan.next();
									
									
									boolean Check = server.idCheck(delId);
										if(Check) {
											server.deleteId(delId);
										}else {
											System.out.println("There is no the no(id) entered.");
										}
									break;
									
				
								case 3: System.out.println("goto previous menu"); op4 = false; break;
								default : System.out.println("Re-enter the menu."); break;
								}//switch dog search
							}//switch op4 while //회원관리
							break;
							
							
							
							
							
						case 3: // 로그아웃
							System.out.println("Log out!"); 
							op4=false;
							break;
						
						} 
					
						
						
						
					}//while op2
				}//op2 if adminId=admin
				else {
					System.out.println("관리자가 아닙니다.");
				}//manage switch
				break;
				
				
				
				
				
				
			case 4:
				op = false;
				System.out.println("종료합니다.");
				break;
			default : System.out.println("잘못입력하셨습니다.");
			 		break;
			
		
			}// end switch
			
			
			
			
		}// end while 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}// end public static void

}// end class
