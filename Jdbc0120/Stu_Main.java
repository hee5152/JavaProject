package Jdbc0120;

import java.util.Scanner;

public class Stu_Main {

	public static void main(String[] args) {
		// SQL���� �����ϱ� ���� ��ü ����
		Stu_SQL sql = new Stu_SQL();
		
		//stu Ŭ����
		StuDTO stu = new StuDTO();
		
		//������ �Է¹ޱ� ����sc ��ü ����
		Scanner sc = new Scanner(System.in); //scanner- input
		
		boolean run = true;
		int menu = 0;
		
		while(run) {
			System.out.println("===========================");
			System.out.println("1.DB����              2.DB����");
			System.out.println("3. �л����           4.�л���ȸ");
			System.out.println("5. �л�����           6.�л�����");
			System.out.println("7. ����");
			System.out.println("===========================");
			System.out.println("�׸� ����>>");
			menu = sc.nextInt();
					
			// switch �� �ۼ�
			switch(menu) {
			case 1:
				sql.connect();
				 //db ���� ��� �ֱ�
				break;
			case 2:
				sql.conClose();
				//db ������ɳֱ�
				break;
			case 3:
				System.out.println("�л������� �Է����ּ���!");
				
				System.out.println("�̸�>> ");
				String stuName = sc.next();
				
				System.out.println("����>> ");
				int stuAge = sc.nextInt();
				
				stu.setStuName (stuName);
				stu.setStuAge(stuAge);
				
				sql.insert(stu);
				break;
			
			case 4:
				sql.select();
				break;
				
			case 5 :
				System.out.println("������ �л������� �Է����ּ���");
				
				System.out.println("������ �л��̸�>> ");
				stuName = sc.next();
				
				System.out.println("������ ����>>");
				stuAge = sc.nextInt();
				
				
				stu.setStuAge(stuAge);
				stu.setStuName (stuName);

				
				sql.update(stu);
				
				break;
			case 6 :
				
				System.out.println("������ �л������� �Է����ּ���");
				
				System.out.println("������ �л��̸�>> ");
				String dName = sc.next();
				
			
				stu.delete(dName);

		
				
				break;
			case 7 :
				run = false;
				System.out.println("���α׷��� �����մϴ�");
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			} //end switch
		}	//end while
		
		System.out.println("�ý����� �����մϴ�.");
	

	}

}
