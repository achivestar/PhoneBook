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
			System.out.println("이미 등록된 전화번호입니다");
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
			System.out.println("검색된 맴버가 없습니다.");
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
		System.out.println("수정할 회원정보를 입력 하세요.");
		
		System.out.print("이전 이름 :" + oldMember.getName()+"\n");
		System.out.print("수정할 이름 :");
		name = sc.next();
		
		System.out.print("이전 전화번호:" + oldMember.getPhoneNum()+"\n");
		System.out.print("수정할 전화번호 :");
		phoneNum = sc.next();
		
		if(oldMember.getMayer()!=null) {
			System.out.print("이전 학과:" + oldMember.getMayer()+"\n");
			System.out.print("수정할 학과 :");
			mayer = sc.next();
			
			System.out.print("이전  학년:" + oldMember.getYear()+"\n");
			System.out.print("수정할 학년 :");
			year = sc.nextInt();
		}
		
		if(oldMember.getCompany()!=null) {
			System.out.print("이전 회사명:" + oldMember.getCompany()+"\n");
			System.out.print("수정할 회사명 :");
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
