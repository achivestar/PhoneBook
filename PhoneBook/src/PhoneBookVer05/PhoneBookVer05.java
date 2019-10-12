package PhoneBookVer05;

import java.util.Scanner;

public class PhoneBookVer05 {

	public static void main(String[] args) {

		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		Scanner sc = new Scanner(System.in);
		int choice;

		while (true) {
			try {
				System.out.println("선택하세요.");
				System.out.println("1. 데이터 입력");
				System.out.println("2. 데이터 검색");
				System.out.println("3. 데이터 삭제");
				System.out.println("4. 데이터 조회");
				System.out.println("5. 데이터 종료");
				System.out.print("선택 :");
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
					System.out.println("프로그램을 종료합니다.");
					return;
				}

			}catch(MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("메뉴 선택을 처음부터 다시 진행합니다.\n");
			}
			
		}
	}

}
