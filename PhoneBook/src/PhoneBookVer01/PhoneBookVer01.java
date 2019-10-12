package PhoneBookVer01;

/*
 *  전화번호 관리 프로그램
 *  Version 0.1
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

public class PhoneBookVer01 {

	public static void main(String[] args) {
		PhoneInfo pInfo1 = new PhoneInfo("홍길동","010-3235-7676","1998-03-21");
		PhoneInfo pInfo2 = new PhoneInfo("김효정","010-6777-4566");
		pInfo1.showPhoneInfo();
		pInfo2.showPhoneInfo();
				

	}

}
