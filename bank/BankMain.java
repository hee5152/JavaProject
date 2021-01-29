package bank;

import java.util.Scanner;

public class BankMain {

	public static void main(String[] args) {
		
		// BankDTO 의 정보를 담는 client 객체 선언
		BankDTO client = new BankDTO();
		
		// BankDAO의 정보를 담는 server객체선언
		BankDAO server = new BankDAO();
		
		//입력을 위한 sc객체선언
		Scanner sc = new Scanner(System.in);
		
		//프로그램 실행을 위한 변수 run 선언
		boolean run = true;
		
		//항목을 선택할 때 필요한 변수 menu 선언
		int menu = 0;
		
		System.out.println("ICIA은행에 오신것을 환영합니다.");
		System.out.println("원하시는 메뉴를 선택해주세요!");
		System.out.println();
		
		//while문을 사용하여 프로그램 실행
		while(run) {
			System.out.println("==============================");
			System.out.println("1. 계좌생성       2.입금");
			System.out.println("3. 출금             4.잔액조회");
			System.out.println("5. 송금             5.종료");
			System.out.println("==============================");
			menu = sc.nextInt();
			
			server.connect();
			
			switch(menu) {
			case 1:
				int clientNumber = server.clientNumber() +1 ;
				
				System.out.println("회원정보를 입력해주세요!");
				System.out.println("회원이름>>");
				String cName = sc.next();
				
				System.out.println("계좌번호 >> ");
				String accountNumber = sc.next();
				
				System.out.print("초기입금액>>");
				int balance = sc.nextInt();
				//client.setBalance(balance);
				
							//ctl키누르고 클릭하면 이동
				client = new BankDTO(clientNumber, cName, accountNumber, balance);
				//(파라미터 이용한 파라미터매개체 생성)
				
				server.insertClient(client);
				
				break;
				
			case 2:
				System.out.println("계좌번호 >> ");
				accountNumber = sc.next();
				
				
				
				System.out.print("입금액>>");
				balance = sc.nextInt();
				
				//client = new BankDTO(clientNumber, cName, accountNumber, balance);
				
				
				//client안에 '입력한 정보' 저장하기
				client.setAccountNumber(accountNumber);
				client.setBalance(balance);
				
				
				// (1) BankDTO(client) 에 있는 모든 내용을 넘기게 함 (BankDTO client로 지정했으니까)
				server.deposit(client);
				//서버에 입금액 정보 넣어줄거임
				
				//(2) accountNumber(계좌번호)와 balance(입금액)정보만 넘긴다.
		//		server.deposit(accountNumber,balance);
				
				break;
				
			case 3:
				//잔액조회를 사용하여
				// 출금액이 잔액보다 많을 경우 출금하지 못하도록 만들어보자
				
				
				
				System.out.println("계좌번호 >> ");
				accountNumber = sc.next();
				
				int cBalance = server.checkBalance(accountNumber);
				// cBalance는 현재 출금하고자 하는 계과의 잔액
				
				System.out.print("출금액>>");
				balance = sc.nextInt();
				// balance는 출금하고자 하는 금액
				
				//client = new BankDTO(clientNumber, cName, accountNumber, balance);
				
				
				if (cBalance >= balance) {
					server.withdraw(accountNumber,balance);
				}else {
					System.out.println("출금액이" +(balance - cBalance) +"원  부족합니다.");
					System.out.println("현재잔액은" +cBalance+ "원 입니다.");
				
				}
				

				
				//client안에 '입력한 정보' 저장하기
				client.setAccountNumber(accountNumber);
				client.setBalance(balance);
				
				// (1) BankDTO(client) 에 있는 모든 내용을 넘기게 함 (BankDTO client로 지정했으니까)
	//			server.withdraw(client);
				//서버에 입금액 정보 넣어줄거임
				
				//(2) accountNumber(계좌번호)와 balance(입금액)정보만 넘긴다.
				server.withdraw(accountNumber,balance);
				
				
				break;
				
			case 4:
				System.out.println("계좌번호>>");
				accountNumber = sc.next();
				
				balance =server.checkBalance(accountNumber);
				
				System.out.println("잔액조회 : " + balance);
				
				break;
				
			case 5:
				//==============내가 한거===========================
				// 송금할 계좌의 잔액이 송금액보다 많지 않은지?
				// 송금받을 계좌가 있는지?
//				
//				System.out.println("송금할계좌번호>>");
//				accountNumber = sc.next();
//				
//				System.out.println("송금할 금액>>");
//				balance = sc.nextInt();
//				
//				System.out.println("송금받을 계좌번호>>");
//				accountNumber = sc.next();
//				
//				
//				
//				// 송금금액
//				if (tBalance <= balance ) {
//					System.out.println("송금성공!");
//					server.tbalance(accountNumber,balance);
//				}else {
//					System.out.println("송금 불가능 합니다. 잔액이 부족합니다.");
//				}
//				
//				
//					// 송금받을 계좌 존재
//				accountNumber =server.checkAccount(accountNumber);
//			
//				if (tAccountNumber = server.accountNumber) {
//					System.out.println("송금가능 계좌입니다.");
//					
//					checkBalance(accountNumber)-balance;
//					checkBalance(tAccountNumber)+ balance;
//					
//				}else {
//					System.out.println("송금받을 계좌가 존재하지 않습니다.");
//				}
//				
//				//송금액을 저장해주고싶어
//				client.balance(accountNumber);
//				
				//==================================================
				
				// 1. 송금받을 계좌가 있는지?
				//send Account
				System.out.println("송금 할 계좌번호>>");  
				String sAccountNumber = sc.next();
				
				//receive Account
				System.out.println("송금 받을 계좌번호>>");  
				String rAccountNumber = sc.next();
				
				System.out.println("송금액");
				balance = sc.nextInt();
				
				// 계좌가 존재하면  true, 존재하지 않으면 false //checkAccount 메소드생성
				boolean sAccount = server.checkAccount(sAccountNumber);
				boolean rAccount = server.checkAccount(rAccountNumber);
				
				// 송금할  계좌의 잔액이 송금액보다 많지 않은가?
				int sBalance = server.checkBalance(sAccountNumber);
				
				//1. 보내는 사람 계좌번호
				if(sAccount) {
					//2. 받는 사람 계좌번호
					if(rAccount) {
						//3. 잔액이 송금보다 많아야한다.
					
						if (sBalance >= balance) {
							// sever에 send ()메소드 생성
							server.send(sAccountNumber, rAccountNumber, balance);
						}else {
							System.out.println("송금액이" +(balance - sBalance) +"원  부족합니다.");
							System.out.println("현재잔액은" +sBalance+ "원 입니다.");
						
						}
					}else {
						System.out.println("받으실 분의 계좌를 확인해주세요");
					}
				}else {
					System.out.println("보내실 분의 계좌를 확인해주세요");
				}
				
	
				
				
	
				
				
				
				
				
				
				break;
				
			case 6: 
				run = false;
				System.out.println("이용해주셔서 감사합니다.");
				break;
				
			default:
				System.out.println("다시 입력해 주세요");
				break;
				
			
			}//end switch
			
			
			
			
		}//end while
		
		
		
		server.conClose();
		
		
		
		
		
		

	} //end main

}//end class
