package PhoneBookVer08;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class phoneInfoService {

	public boolean addPhoneInfo(PhoneInfo info, int choice) {
		
		boolean isInsertSuccess = false;
		
		Connection con = JdbcUtil.getConnection();
		PhoneInfoDAO infoDAO = new PhoneInfoDAO(con);
		
		int insertCount = infoDAO.insertPhoneInfo(info, choice);
		
		if(insertCount>0) {
			isInsertSuccess = true;
		}else {
			isInsertSuccess = false;
		}

		JdbcUtil.close(con);
		return isInsertSuccess;
	}

	public boolean isPhoneNum(String phoneNumber) {

		Connection con = JdbcUtil.getConnection();
		PhoneInfoDAO infoDAO = new PhoneInfoDAO(con);
        boolean isPhoneNum = false;		
		isPhoneNum = infoDAO.isPhoneNum(phoneNumber);
		if(isPhoneNum){
			System.out.println("�̹� ��ϵ� ��ȭ��ȣ�Դϴ�");
		}
		JdbcUtil.close(con);
		return isPhoneNum;


	}

	public ArrayList<PhoneBookMember> getMemberList() {
		
		Connection con = JdbcUtil.getConnection();
		PhoneInfoDAO infoDAO = new PhoneInfoDAO(con);
		ArrayList<PhoneBookMember> memberList = infoDAO.selectMemberList();
		
		JdbcUtil.close(con);
		return memberList;
	}

	public ArrayList<PhoneBookMember> searchMember(String sname) {
		Connection con = JdbcUtil.getConnection();
		PhoneInfoDAO infoDAO = new PhoneInfoDAO(con);
		ArrayList<PhoneBookMember> memberList = infoDAO.searchMemberList(sname);
		if(memberList.size()==0) {
			System.out.println("�˻��� �ɹ��� �����ϴ�.");
		}
		JdbcUtil.close(con);
		return memberList;
	}

	public PhoneBookMember getOldMember(String uNum) {
		PhoneBookMember oldMember = null;
		Connection con = JdbcUtil.getConnection();
		PhoneInfoDAO infoDAO = new PhoneInfoDAO(con);
		oldMember = infoDAO.selectOldMember(uNum);
		
		JdbcUtil.close(con);
		return oldMember;
	}

	public PhoneBookMember getUpdateMember(PhoneBookMember oldMember) {
		Scanner sc = new Scanner(System.in);
		String name,phoneNum;
		String mayer=null, company=null;
		int year=0;
		System.out.println("������ ȸ�������� �Է� �ϼ���.");
		
		System.out.print("���� �̸� :" + oldMember.getName()+"\n");
		System.out.print("������ �̸� :");
		name = sc.next();
		
		System.out.print("���� ��ȭ��ȣ:" + oldMember.getPhoneNum()+"\n");
		System.out.print("������ ��ȭ��ȣ :");
		phoneNum = sc.next();
		
		if(oldMember.getMayer()!=null) {
			System.out.print("���� �а�:" + oldMember.getMayer()+"\n");
			System.out.print("������ �а� :");
			mayer = sc.next();
			
			System.out.print("����  �г�:" + oldMember.getYear()+"\n");
			System.out.print("������ �г� :");
			year = sc.nextInt();
		}
		
		if(oldMember.getCompany()!=null) {
			System.out.print("���� ȸ���:" + oldMember.getCompany()+"\n");
			System.out.print("������ ȸ��� :");
			company = sc.next();
		}
		return new PhoneBookMember(name,phoneNum,mayer,year,company);
	}

	public boolean removePhoneNum(String dNum) {
		Connection con = JdbcUtil.getConnection();
		PhoneInfoDAO infoDAO = new PhoneInfoDAO(con);
		int deleteCount = infoDAO.deleteMember(dNum);
		if(deleteCount>0) {
			return true;
		}else {
			return false;
		}

	}

	
}
