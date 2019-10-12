package PhoneBookVer02;

import java.util.Scanner;

/*
 * ��ȭ��ȣ ���� ���α׷�
 * Version 0.2
 * */
class PhoneInfo{
	String name;
	String phoneNumber;
	String birth;
	
	public PhoneInfo(String name, String num, String birth) {
		this.name = name;
		this.phoneNumber = num;
		this.birth = birth;
	}
	
	public PhoneInfo(String name, String num) {
		this.name = name;
		phoneNumber = num;
		this.birth = birth;
	}
	
	public void showPhoneInfo() {
		System.out.println("name : "+name);
		System.out.println("phone : "+phoneNumber);
		if(birth!=null) {
			System.out.println("birth : "+birth);
		}
		
		System.out.println();
	}
}
public class PhoneBookVer02 {
	static Scanner sc = new Scanner(System.in);
	public static void showMenu() {
		System.out.println("�����ϼ���!");
		System.out.println("1.�������Է�");
		System.out.println("2.���α׷� ����");
		System.out.print("���� > ");
	}
	
	public static void readData() {
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phoneNumber = sc.nextLine();
		System.out.print("������� : ");
		String birth = sc.nextLine();
		
		PhoneInfo info = new PhoneInfo(name, phoneNumber,birth);
		System.out.println("\n �Էµ� ���� ���..");
		info.showPhoneInfo();
	}
	public static void main(String[] args) {
		int choice;
		while(true) {
			showMenu();
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1 : 
				 readData();
				 break;
			case 2 :
				System.out.println("���α׷��� �����մϴ�");
				return;
			}
		}
	}

}
