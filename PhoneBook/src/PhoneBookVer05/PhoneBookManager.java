package PhoneBookVer05;

import java.util.Scanner;

public class PhoneBookManager {

	final int MAX_CNT = 100;
	PhoneInfo[] infoStorage = new PhoneInfo[MAX_CNT];
	int curCnt = 0;
	Scanner sc = new Scanner(System.in);
	
	static PhoneBookManager inst = null;
	public static PhoneBookManager createManagerInst() {
		if(inst==null) {
			inst = new PhoneBookManager();
		}
		
		return inst;
	}
	

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
		infoStorage[curCnt++] = info;
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.");
	}
	
	public void searchData() {
		System.out.println("������ �˻��� �����մϴ�.");
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		
		int dataIdx = search(name);
		if(dataIdx<0) {
			System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�.");
		}else {
			infoStorage[dataIdx].showPhoneInfo();
			System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�.");
		}
	}
	
	public void deleteData() {
		System.out.println("������ ������ �����մϴ�.");
		System.out.print("�̸� :");
		String name = sc.nextLine();
		
		int dataIdx = search(name);
		if(dataIdx<0) {
			System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�.");
		}else {
			for(int idx=dataIdx; idx<(curCnt-1);idx++) {
				infoStorage[idx] = infoStorage[idx+1];
			}
			curCnt--;
			System.out.println("������ ������ �Ϸ� �Ǿ����ϴ�.");
		}
	}
	
	public void selectData() {
		for(int idx=0; idx<curCnt;idx++) {
			infoStorage[idx].showPhoneInfo();
		}		
	}
	private int search(String name) {
		for(int idx=0; idx<curCnt;idx++) {
			PhoneInfo curInfo = infoStorage[idx];
			if(name.equals(curInfo.name)) {
				return idx;
			}	
		}
		return -1;
	}


	
}
