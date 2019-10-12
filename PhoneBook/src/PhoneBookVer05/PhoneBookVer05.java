package PhoneBookVer05;

import java.util.Scanner;

public class PhoneBookVer05 {

	public static void main(String[] args) {

		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		Scanner sc = new Scanner(System.in);
		int choice;

		while (true) {
			try {
				System.out.println("�����ϼ���.");
				System.out.println("1. ������ �Է�");
				System.out.println("2. ������ �˻�");
				System.out.println("3. ������ ����");
				System.out.println("4. ������ ��ȸ");
				System.out.println("5. ������ ����");
				System.out.print("���� :");
				choice = sc.nextInt();
				sc.nextLine();
				
				if(choice<INIT_MENU.INPUT || choice>INIT_MENU.EXIT) {
					throw new MenuChoiceException(choice);
				}
				
				switch (choice) {
				case INIT_MENU.INPUT:
					manager.inputData();
					break;
				case INIT_MENU.SEARCH:
					manager.searchData();
					break;
				case INIT_MENU.DELETE:
					manager.deleteData();
					break;
				case INIT_MENU.SELECT:
					manager.selectData();
					break;
				case INIT_MENU.EXIT:
					System.out.println("���α׷��� �����մϴ�.");
					return;
				}

			}catch(MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("�޴� ������ ó������ �ٽ� �����մϴ�.\n");
			}
			
		}
	}

}
