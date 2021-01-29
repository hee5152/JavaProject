package Naver;

import java.util.Scanner;

public class NaverMain {
//����Ʈ����, ���߿� �� �������� ��ü
	public static void main(String[] args) {
		
		//������ �����ϴ� NaverDAOŬ����
		NaverDAO server = new NaverDAO();
		
		//ȸ������ ������ ��� �ִ� NaverDTOŬ����
		NaverDTO naver = new NaverDTO();
		
		Scanner sc = new Scanner(System.in);
		
		//���α׷� ������ ���� ���� run
		boolean run = true;
		
		// �׸��� �����Ҷ� �ʿ��� ���� menu
		int menu = 0;
		
		
		while(run) {
			System.out.println("=======================");
			System.out.println("1.DB����              2.DB����");
			System.out.println("3. ȸ������           4.ȸ����ȸ");
			System.out.println("5. ȸ������           6.ȸ������");
			System.out.println("7. ����");
			System.out.println("=======================");
			System.out.print("�׸� ����>>");
			menu = sc.nextInt();
					
			
			switch(menu) {
			case 1:
				server.connect();
				break;
			case 2:
				server.connClose();
				break;
			case 3:
			System.out.println("ȸ�������� �Է����ּ���!");
				
				System.out.println("���̵�>> ");
				String naver_id = sc.next();
				naver.setNaver_id(naver_id);
				
				System.out.println("��й�ȣ>> ");
				String naver_pass = sc.next();
				
				System.out.println("��й�ȣȮ��>> ");
				String npwc = sc.next();
				
				if(naver_pass.equals(npwc)) {
					System.out.println("��밡���� ��й�ȣ");
				}else {
					System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
					break;
				}
				
				
				System.out.println("�̸�>> ");
				String naver_name = sc.next();
				naver.setNaver_name(naver_name);
				
				System.out.println("������� ");
				System.out.println("����>> ");
				String nyear = sc.next();
				
				System.out.println("��>> ");
				String nmon = sc.next();
				
				System.out.println("��>> ");
				String nday = sc.next();
				
				System.out.println("������� Ȯ�� :");
				System.out.println(nyear +nmon+nday);
				naver.setNaver_birth(nyear +nmon+nday);
				
				System.out.println("����>> ");
				String naver_gender = sc.next();
				naver.setNaver_gender(naver_gender);
				
				System.out.println("�̸���>> ");
				String naver_email = sc.next();
				naver.setNaver_email(naver_email);
				
				System.out.println("��ȭ��ȣ>> ");
				String naver_phone = sc.next();
				naver.setNaver_phone(naver_phone);
				
				server.memberJoin(naver); 
				// public void memberJoin(NaverDTO ����
				//server(NaverDAO)�� memberJoin()�޼ҵ忡 
				//naver(NaverDTO)�� ������ ��� �̵��ϰڴ�.
				
				
				server.insert(naver);
				break;
			
			case 4:
				//���̵�� ��й�ȣ�� �Է¹޾Ƽ�
				//admin ���̵� ��ȸ�� �����ϰԲ�
				server.memberList();
				break;
				
			case 5:

				System.out.println("������ ȸ�����̵�>> ");
				naver_id = sc.next();
				naver.setNaver_id(naver_id);
				
				System.out.println("������ ��й�ȣ>>");
				naver_pass = sc.next();
				
				System.out.println("��й�ȣ Ȯ��>>");
				npwc = sc.next();
				
				if(naver_pass.equals(npwc)) {
					System.out.println("��밡���� ��й�ȣ");
				
				naver.setNaver_pass(naver_pass);
				}else {
					System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
					break;
				}
				System.out.println("������ �̸�>>");
				naver_name = sc.next();
				naver.setNaver_name (naver_name);
				
				System.out.println("������� ");
				System.out.println("����>> ");
				nyear = sc.next();
			
				
				System.out.println("��>> ");
				nmon = sc.next();
				
				System.out.println("��>> ");
				nday = sc.next();
				
				System.out.println("������� Ȯ�� :");
				System.out.println(nyear +nmon+nday);
				naver.setNaver_birth(nyear +nmon+nday);
				
				System.out.println("������ ����>>");
				naver_gender = sc.next();
				naver.setNaver_gender (naver_gender);
				
				System.out.println("������ �̸���>>");
				naver_email = sc.next();
				naver.setNaver_email (naver_email);
				
				System.out.println("������ ��ȭ��ȣ>>");
				naver_phone = sc.next();
				naver.setNaver_phone (naver_phone);
				
			
				
				server.memberModify(naver);
				break;
				
			case 6:
				System.out.println("������ ȸ�������� �Է����ּ���");
				
				System.out.println("������ ȸ�����̵�>>");
				String dId = sc.next();
				
				System.out.println("��й�ȣ>> ");
				String dPw = sc.next();
				
				
				boolean check = server.idCheck(dId,dPw);
				// booleanŸ���� ���� check����
				// server(NaverDAO)���� dId�� dPw�� ������ ����
				// booleanŸ���� �޼ҵ� idCheck����
				
				if (check) {
					server.memberDelete(dId);
				}else {
					System.out.println("���̵�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				}
				
				
				break;
			case 7:
				//run �� true�̱� ������ �ݺ����� ����
				//run�� false�� �Ǹ� �ݺ��� ����
				run = false;
				System.out.println("���α׷��� �����մϴ�");
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			} //end switch
			
		}//end while
		
		
		
		
		
		
		
	}//end main

}//end class
