package PhoneBookVer04;

import java.util.Scanner;

public class PhoneBookManager {

	final int MAX_CNT = 100;
	PhoneInfo[] infoStorage = new PhoneInfo[MAX_CNT];
	int curCnt = 0;
	Scanner sc = new Scanner(System.in);

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

	public void inputData() {
		System.out.println("������ �Է��� �����մϴ�.");
		System.out.println("1.�Ϲ�   2.����   3.ȸ�� ");
		System.out.print("����:");
		int choice = sc.nextInt();
		sc.nextLine();
		PhoneInfo info = null;

		switch (choice) {
		case 1:
			info = readFriendInfo();
			break;
		case 2:
			info = readUnivFriendInfo();
			break;
		case 3:
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
