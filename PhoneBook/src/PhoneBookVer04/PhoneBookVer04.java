package PhoneBookVer04;

import java.util.Scanner;

public class PhoneBookVer04 {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while(true) {
			System.out.println("�����ϼ���.");
			System.out.println("1. ������ �Է�");
			System.out.println("2. ������ �˻�");
			System.out.println("3. ������ ����");
			System.out.println("4. ������ ��ȸ");
			System.out.println("5. ������ ����");
			System.out.print("���� :");
			choice = sc.nextInt();
			sc.nextLine();
					
			switch(choice) {
			case 1: manager.inputData();
			break;
			case 2 : manager.searchData();
			break;
			case 3 :  manager.deleteData();
			break;
			case 4 : manager.selectData();
			break;
			case 5 :
				System.out.println("���α׷��� �����մϴ�.");
				return;
			}
			
		}
	}

}
