package PhoneBookVer04;

import java.util.Scanner;

public class PhoneBookVer04 {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while(true) {
			System.out.println("선택하세요.");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 검색");
			System.out.println("3. 데이터 삭제");
			System.out.println("4. 데이터 조회");
			System.out.println("5. 데이터 종료");
			System.out.print("선택 :");
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
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
		}
	}

}
