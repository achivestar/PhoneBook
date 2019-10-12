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
					System.out.println("등록성공\n");
				}else {
					System.out.println("등록실패\n");
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
					System.out.println("등록성공\n");
				}else {
					System.out.println("등록실패\n");
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
					System.out.println("등록성공\n");
				}else {
					System.out.println("등록실패\n");
				}
			}
			
			break;
		}

		
		
	}
	
	public void updateData() {
		System.out.println("수정할 맴버의 전화번호 : ");
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
				System.out.println("회원정보수정 성공");
			}else {
				System.out.println("회원정보수정 실패");
			}
		}else {
			System.out.println("등록된 맴버의 전화번호가 없습니다.");
			
		}
		
	}
	
	public void deleteData() {
		System.out.println("삭제할 맴버의 전화번호:");
		String dNum = sc.next();
		phoneInfoService pis = new phoneInfoService();
		boolean isPhoneNum = pis.isPhoneNum(dNum);
		if(isPhoneNum) {
			boolean removeSuccess = pis.removePhoneNum(dNum);
			if(removeSuccess) {
				System.out.println("회원정보삭제 성공");
			}else {
				System.out.println("회원정보삭제 실패");
			}
			
		}else {
			System.out.println("등록된 맴버의 전화번호가 없습니다.");
		}
		
		
	}
	
	
	public void searchData() {
		
		System.out.println("맴버이름 : ");
		String sname = sc.next();
		phoneInfoService pis = new phoneInfoService();
		ArrayList<PhoneBookMember> searchMember = pis.searchMember(sname); 
		System.out.println("총"+searchMember.size()+"개");
		for(int i=0; i<searchMember.size();i++) {
			PhoneBookMember data = searchMember.get(i);
			String name = data.getName();
			String phoneNum = data.getPhoneNum();
			String mayer = data.getMayer();
			int year = data.getYear();
			String company = data.getCompany();
			
			System.out.println("이름 :"+name+",전화번호 : "+phoneNum);
			if(mayer!=null) {
				System.out.println("이름 :"+name+",전화번호 : "+phoneNum+",학과 :"+mayer+",학년 :"+year);
			}
			if(company!=null) {
				System.out.println("이름 :"+name+",전화번호 : "+phoneNum+",회사 :" + company);
			}
			
		}
	}
	

	public void selectData() {
		phoneInfoService pis = new phoneInfoService();
		ArrayList<PhoneBookMember> memberList = pis.getMemberList();
		System.out.println("총"+memberList.size()+"개");
		for(int i=0; i<memberList.size();i++) {
			PhoneBookMember data = memberList.get(i);
			String name = data.getName();
			String phoneNum = data.getPhoneNum();
			String mayer = data.getMayer();
			int year = data.getYear();
			String company = data.getCompany();
			
			System.out.println("이름 :"+name+",전화번호 : "+phoneNum);
			if(mayer!=null) {
				System.out.println("이름 :"+name+",전화번호 : "+phoneNum+",학과 :"+mayer+",학년 :"+year);
			}
			if(company!=null) {
				System.out.println("이름 :"+name+",전화번호 : "+phoneNum+",회사 :" + company);
			}
			
		}
    }	


	
}
