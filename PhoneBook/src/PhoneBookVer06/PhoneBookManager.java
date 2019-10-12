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
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = sc.nextLine();

		return new PhoneInfo(name, phone);
	}

	private PhoneInfo readUnivFriendInfo() {
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = sc.nextLine();
		System.out.print("���� : ");
		String major = sc.nextLine();
		System.out.print("�г� : ");
		int year = sc.nextInt();
		sc.nextLine();

		return new PhoneUnivInfo(name, phone, major, year);
	}

	private PhoneInfo readCompanyFriendInfo() {
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = sc.nextLine();
		System.out.print("ȸ�� : ");
		String company = sc.nextLine();

		return new PhoneCompanyInfo(name, phone, company);
	}

	public void inputData() throws MenuChoiceException{
		System.out.println("������ �Է��� �����մϴ�.");
		System.out.println("1.�Ϲ�   2.����   3.ȸ�� ");
		System.out.print("����:");
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
			System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.\n");
		else 
			System.out.println("�̹� ����� ������ �Դϴ�.\n");
		
		
	}
	
	public void searchData() {
		System.out.println("������ �˻��� �����մϴ�.");
		System.out.print("�̸� : ");
		String name = sc.nextLine();

		 PhoneInfo info = search(name);
		 if(info==null) {
			 System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�.");
		 }else {
			 info.showPhoneInfo();
			 System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�.");
		 }
	}
	
	public void deleteData() {
		System.out.println("������ ������ �����մϴ�.");
		System.out.print("�̸� :");
		String name = sc.nextLine();

		Iterator<PhoneInfo> itr = infoStorage2.iterator();
		while(itr.hasNext()) {
			PhoneInfo  curInfo = itr.next();
			if(name.equals(curInfo.name)) {
				itr.remove();
				System.out.println("������ ������ �Ϸ� �Ǿ����ϴ�.");
				return;
			}
		}
		System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�.");
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
