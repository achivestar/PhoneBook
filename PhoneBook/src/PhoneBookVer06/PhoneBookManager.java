package PhoneBookVer06;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager {

	HashSet<PhoneInfo> infoStorage2 = new HashSet<PhoneInfo>();
	Scanner sc = new Scanner(System.in);
	
	static PhoneBookManager inst = null;
	public static PhoneBookManager createManagerInst() {
		if(inst==null) {
			inst = new PhoneBookManager();
		}
		
		return inst;
	}
	private PhoneBookManager() {}

	private PhoneInfo readFriendInfo() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();

		return new PhoneInfo(name, phone);
	}

	private PhoneInfo readUnivFriendInfo() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		System.out.print("전공 : ");
		String major = sc.nextLine();
		System.out.print("학년 : ");
		int year = sc.nextInt();
		sc.nextLine();

		return new PhoneUnivInfo(name, phone, major, year);
	}

	private PhoneInfo readCompanyFriendInfo() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		System.out.print("회사 : ");
		String company = sc.nextLine();

		return new PhoneCompanyInfo(name, phone, company);
	}

	public void inputData() throws MenuChoiceException{
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1.일반   2.대학   3.회사 ");
		System.out.print("선택:");
		int choice = sc.nextInt();
		sc.nextLine();
		PhoneInfo info = null;
		

		if(choice<INPUT_SELECT.NORMAL || choice>INPUT_SELECT.COMPANY) {
			throw new MenuChoiceException(choice);
		}
	 
		switch (choice) {
		case INPUT_SELECT.NORMAL:
			info = readFriendInfo();
			break;
		case INPUT_SELECT.UNIV:
			info = readUnivFriendInfo();
			break;
		case INPUT_SELECT.COMPANY:
			info = readCompanyFriendInfo();
			break;
		}

		boolean isAdded = infoStorage2.add(info);
		if(isAdded==true) 
			System.out.println("데이터 입력이 완료되었습니다.\n");
		else 
			System.out.println("이미 저장된 데이터 입니다.\n");
		
		
	}
	
	public void searchData() {
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름 : ");
		String name = sc.nextLine();

		 PhoneInfo info = search(name);
		 if(info==null) {
			 System.out.println("해당하는 데이터가 존재하지 않습니다.");
		 }else {
			 info.showPhoneInfo();
			 System.out.println("데이터 검색이 완료되었습니다.");
		 }
	}
	
	public void deleteData() {
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("이름 :");
		String name = sc.nextLine();

		Iterator<PhoneInfo> itr = infoStorage2.iterator();
		while(itr.hasNext()) {
			PhoneInfo  curInfo = itr.next();
			if(name.equals(curInfo.name)) {
				itr.remove();
				System.out.println("데이터 삭제가 완료 되었습니다.");
				return;
			}
		}
		System.out.println("해당하는 데이터가 존재하지 않습니다.");
	}
	
	public void selectData() {
		Iterator<PhoneInfo> itr = infoStorage2.iterator();
		while(itr.hasNext()) {
			PhoneInfo  curInfo = itr.next();
			     curInfo.showPhoneInfo();
			}
    }	
	private PhoneInfo search(String name) {
		Iterator<PhoneInfo> itr = infoStorage2.iterator();
		while(itr.hasNext()) {
			PhoneInfo curInfo = itr.next();
			if(name.equals(curInfo.name)) {
				return curInfo;
			}
		}
		return null;
	}


	
}
