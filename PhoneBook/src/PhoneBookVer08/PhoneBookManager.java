package PhoneBookVer08;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookManager {


	Scanner sc = new Scanner(System.in);
	
	static PhoneBookManager inst = null;
	public static PhoneBookManager createManagerInst() {
		if(inst==null) {
			inst = new PhoneBookManager();
		}
		
		return inst;
	}
	private PhoneBookManager() {
		
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
		boolean isPhoneNum = false;
		boolean isSuccess = false;
		sc.nextLine();	

		if(choice<INPUT_SELECT.NORMAL || choice>INPUT_SELECT.COMPANY) {
			throw new MenuChoiceException(choice);
		}
	 
		switch (choice) {
		case INPUT_SELECT.NORMAL:
			PhoneInfo info = readFriendInfo();
			phoneInfoService pis = new phoneInfoService();
			isPhoneNum = pis.isPhoneNum(info.phoneNumber);
		    isSuccess = pis.addPhoneInfo(info,choice);
			if(!isPhoneNum) {
				if(isSuccess) {
					System.out.println("��ϼ���\n");
				}else {
					System.out.println("��Ͻ���\n");
				}
			}
	
			break;
		case INPUT_SELECT.UNIV:
			PhoneUnivInfo infoUniv = (PhoneUnivInfo) readUnivFriendInfo();
			phoneInfoService pisUniv = new phoneInfoService();
			isPhoneNum = pisUniv.isPhoneNum(infoUniv.phoneNumber);
			isSuccess = pisUniv.addPhoneInfo(infoUniv,choice);
			if(!isPhoneNum) {
				if(isSuccess) {
					System.out.println("��ϼ���\n");
				}else {
					System.out.println("��Ͻ���\n");
				}
			}
			
			break;
		case INPUT_SELECT.COMPANY:
			PhoneCompanyInfo infoComp = (PhoneCompanyInfo) readCompanyFriendInfo();
			phoneInfoService pisComp = new phoneInfoService();
			isPhoneNum = pisComp.isPhoneNum(infoComp.phoneNumber);
			isSuccess = pisComp.addPhoneInfo(infoComp,choice);
			if(!isPhoneNum) {
				if(isSuccess) {
					System.out.println("��ϼ���\n");
				}else {
					System.out.println("��Ͻ���\n");
				}
			}
			
			break;
		}

		
		
	}
	
	public void updateData() {
		System.out.println("������ �ɹ��� ��ȭ��ȣ : ");
		String uNum = sc.next();
		phoneInfoService pis = new phoneInfoService();
		boolean isPhoneNum = pis.isPhoneNum(uNum);
		if(isPhoneNum) {
			PhoneBookMember oldMember = pis.getOldMember(uNum);
			PhoneBookMember updateMember = pis.getUpdateMember(oldMember);
			Connection con = JdbcUtil.getConnection();
			PhoneInfoDAO infoDAO = new PhoneInfoDAO(con);
			int updateCount = infoDAO.updateMember(updateMember);
			
			if(updateCount>0) {
				System.out.println("ȸ���������� ����");
			}else {
				System.out.println("ȸ���������� ����");
			}
		}else {
			System.out.println("��ϵ� �ɹ��� ��ȭ��ȣ�� �����ϴ�.");
			
		}
		
	}
	
	public void deleteData() {
		System.out.println("������ �ɹ��� ��ȭ��ȣ:");
		String dNum = sc.next();
		phoneInfoService pis = new phoneInfoService();
		boolean isPhoneNum = pis.isPhoneNum(dNum);
		if(isPhoneNum) {
			boolean removeSuccess = pis.removePhoneNum(dNum);
			if(removeSuccess) {
				System.out.println("ȸ���������� ����");
			}else {
				System.out.println("ȸ���������� ����");
			}
			
		}else {
			System.out.println("��ϵ� �ɹ��� ��ȭ��ȣ�� �����ϴ�.");
		}
		
		
	}
	
	
	public void searchData() {
		
		System.out.println("�ɹ��̸� : ");
		String sname = sc.next();
		phoneInfoService pis = new phoneInfoService();
		ArrayList<PhoneBookMember> searchMember = pis.searchMember(sname); 
		System.out.println("��"+searchMember.size()+"��");
		for(int i=0; i<searchMember.size();i++) {
			PhoneBookMember data = searchMember.get(i);
			String name = data.getName();
			String phoneNum = data.getPhoneNum();
			String mayer = data.getMayer();
			int year = data.getYear();
			String company = data.getCompany();
			
			System.out.println("�̸� :"+name+",��ȭ��ȣ : "+phoneNum);
			if(mayer!=null) {
				System.out.println("�̸� :"+name+",��ȭ��ȣ : "+phoneNum+",�а� :"+mayer+",�г� :"+year);
			}
			if(company!=null) {
				System.out.println("�̸� :"+name+",��ȭ��ȣ : "+phoneNum+",ȸ�� :" + company);
			}
			
		}
	}
	

	public void selectData() {
		phoneInfoService pis = new phoneInfoService();
		ArrayList<PhoneBookMember> memberList = pis.getMemberList();
		System.out.println("��"+memberList.size()+"��");
		for(int i=0; i<memberList.size();i++) {
			PhoneBookMember data = memberList.get(i);
			String name = data.getName();
			String phoneNum = data.getPhoneNum();
			String mayer = data.getMayer();
			int year = data.getYear();
			String company = data.getCompany();
			
			System.out.println("�̸� :"+name+",��ȭ��ȣ : "+phoneNum);
			if(mayer!=null) {
				System.out.println("�̸� :"+name+",��ȭ��ȣ : "+phoneNum+",�а� :"+mayer+",�г� :"+year);
			}
			if(company!=null) {
				System.out.println("�̸� :"+name+",��ȭ��ȣ : "+phoneNum+",ȸ�� :" + company);
			}
			
		}
    }	


	
}
