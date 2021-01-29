package bank;

import java.util.Scanner;

public class BankMain {

	public static void main(String[] args) {
		
		// BankDTO �� ������ ��� client ��ü ����
		BankDTO client = new BankDTO();
		
		// BankDAO�� ������ ��� server��ü����
		BankDAO server = new BankDAO();
		
		//�Է��� ���� sc��ü����
		Scanner sc = new Scanner(System.in);
		
		//���α׷� ������ ���� ���� run ����
		boolean run = true;
		
		//�׸��� ������ �� �ʿ��� ���� menu ����
		int menu = 0;
		
		System.out.println("ICIA���࿡ ���Ű��� ȯ���մϴ�.");
		System.out.println("���Ͻô� �޴��� �������ּ���!");
		System.out.println();
		
		//while���� ����Ͽ� ���α׷� ����
		while(run) {
			System.out.println("==============================");
			System.out.println("1. ���»���       2.�Ա�");
			System.out.println("3. ���             4.�ܾ���ȸ");
			System.out.println("5. �۱�             5.����");
			System.out.println("==============================");
			menu = sc.nextInt();
			
			server.connect();
			
			switch(menu) {
			case 1:
				int clientNumber = server.clientNumber() +1 ;
				
				System.out.println("ȸ�������� �Է����ּ���!");
				System.out.println("ȸ���̸�>>");
				String cName = sc.next();
				
				System.out.println("���¹�ȣ >> ");
				String accountNumber = sc.next();
				
				System.out.print("�ʱ��Աݾ�>>");
				int balance = sc.nextInt();
				//client.setBalance(balance);
				
							//ctlŰ������ Ŭ���ϸ� �̵�
				client = new BankDTO(clientNumber, cName, accountNumber, balance);
				//(�Ķ���� �̿��� �Ķ���͸Ű�ü ����)
				
				server.insertClient(client);
				
				break;
				
			case 2:
				System.out.println("���¹�ȣ >> ");
				accountNumber = sc.next();
				
				
				
				System.out.print("�Աݾ�>>");
				balance = sc.nextInt();
				
				//client = new BankDTO(clientNumber, cName, accountNumber, balance);
				
				
				//client�ȿ� '�Է��� ����' �����ϱ�
				client.setAccountNumber(accountNumber);
				client.setBalance(balance);
				
				
				// (1) BankDTO(client) �� �ִ� ��� ������ �ѱ�� �� (BankDTO client�� ���������ϱ�)
				server.deposit(client);
				//������ �Աݾ� ���� �־��ٰ���
				
				//(2) accountNumber(���¹�ȣ)�� balance(�Աݾ�)������ �ѱ��.
		//		server.deposit(accountNumber,balance);
				
				break;
				
			case 3:
				//�ܾ���ȸ�� ����Ͽ�
				// ��ݾ��� �ܾ׺��� ���� ��� ������� ���ϵ��� ������
				
				
				
				System.out.println("���¹�ȣ >> ");
				accountNumber = sc.next();
				
				int cBalance = server.checkBalance(accountNumber);
				// cBalance�� ���� ����ϰ��� �ϴ� ����� �ܾ�
				
				System.out.print("��ݾ�>>");
				balance = sc.nextInt();
				// balance�� ����ϰ��� �ϴ� �ݾ�
				
				//client = new BankDTO(clientNumber, cName, accountNumber, balance);
				
				
				if (cBalance >= balance) {
					server.withdraw(accountNumber,balance);
				}else {
					System.out.println("��ݾ���" +(balance - cBalance) +"��  �����մϴ�.");
					System.out.println("�����ܾ���" +cBalance+ "�� �Դϴ�.");
				
				}
				

				
				//client�ȿ� '�Է��� ����' �����ϱ�
				client.setAccountNumber(accountNumber);
				client.setBalance(balance);
				
				// (1) BankDTO(client) �� �ִ� ��� ������ �ѱ�� �� (BankDTO client�� ���������ϱ�)
	//			server.withdraw(client);
				//������ �Աݾ� ���� �־��ٰ���
				
				//(2) accountNumber(���¹�ȣ)�� balance(�Աݾ�)������ �ѱ��.
				server.withdraw(accountNumber,balance);
				
				
				break;
				
			case 4:
				System.out.println("���¹�ȣ>>");
				accountNumber = sc.next();
				
				balance =server.checkBalance(accountNumber);
				
				System.out.println("�ܾ���ȸ : " + balance);
				
				break;
				
			case 5:
				//==============���� �Ѱ�===========================
				// �۱��� ������ �ܾ��� �۱ݾ׺��� ���� ������?
				// �۱ݹ��� ���°� �ִ���?
//				
//				System.out.println("�۱��Ұ��¹�ȣ>>");
//				accountNumber = sc.next();
//				
//				System.out.println("�۱��� �ݾ�>>");
//				balance = sc.nextInt();
//				
//				System.out.println("�۱ݹ��� ���¹�ȣ>>");
//				accountNumber = sc.next();
//				
//				
//				
//				// �۱ݱݾ�
//				if (tBalance <= balance ) {
//					System.out.println("�۱ݼ���!");
//					server.tbalance(accountNumber,balance);
//				}else {
//					System.out.println("�۱� �Ұ��� �մϴ�. �ܾ��� �����մϴ�.");
//				}
//				
//				
//					// �۱ݹ��� ���� ����
//				accountNumber =server.checkAccount(accountNumber);
//			
//				if (tAccountNumber = server.accountNumber) {
//					System.out.println("�۱ݰ��� �����Դϴ�.");
//					
//					checkBalance(accountNumber)-balance;
//					checkBalance(tAccountNumber)+ balance;
//					
//				}else {
//					System.out.println("�۱ݹ��� ���°� �������� �ʽ��ϴ�.");
//				}
//				
//				//�۱ݾ��� �������ְ�;�
//				client.balance(accountNumber);
//				
				//==================================================
				
				// 1. �۱ݹ��� ���°� �ִ���?
				//send Account
				System.out.println("�۱� �� ���¹�ȣ>>");  
				String sAccountNumber = sc.next();
				
				//receive Account
				System.out.println("�۱� ���� ���¹�ȣ>>");  
				String rAccountNumber = sc.next();
				
				System.out.println("�۱ݾ�");
				balance = sc.nextInt();
				
				// ���°� �����ϸ�  true, �������� ������ false //checkAccount �޼ҵ����
				boolean sAccount = server.checkAccount(sAccountNumber);
				boolean rAccount = server.checkAccount(rAccountNumber);
				
				// �۱���  ������ �ܾ��� �۱ݾ׺��� ���� ������?
				int sBalance = server.checkBalance(sAccountNumber);
				
				//1. ������ ��� ���¹�ȣ
				if(sAccount) { // cAcount�� sAcount�� �ִ°� Ȯ���� true�� if��!
					//2. �޴� ��� ���¹�ȣ
					if(rAccount) {
						//3. �ܾ��� �۱ݺ��� ���ƾ��Ѵ�.
					
						if (sBalance >= balance) {
							// sever�� send ()�޼ҵ� ����
							server.send(sAccountNumber, rAccountNumber, balance);
						}else {
							System.out.println("�۱ݾ���" +(balance - sBalance) +"��  �����մϴ�.");
							System.out.println("�����ܾ���" +sBalance+ "�� �Դϴ�.");
						
						}
					}else {
						System.out.println("������ ���� ���¸� Ȯ�����ּ���");
					}
				}else {
					System.out.println("������ ���� ���¸� Ȯ�����ּ���");
				}
				
	
				
				
	
				
				
				
				
				
				
				break;
				
			case 6: 
				run = false;
				System.out.println("�̿����ּż� �����մϴ�.");
				break;
				
			default:
				System.out.println("�ٽ� �Է��� �ּ���");
				break;
				
			
			}//end switch
			
			
			
			
		}//end while
		
		
		
		server.conClose();
		
		
		
		
		
		

	} //end main

}//end class
