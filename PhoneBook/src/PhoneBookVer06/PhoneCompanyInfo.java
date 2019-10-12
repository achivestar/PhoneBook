package PhoneBookVer06;

public class PhoneCompanyInfo extends PhoneInfo{

	String company;
	
	public PhoneCompanyInfo(String name, String num, String company) {
		super(name, num); //상속받은 부모의 생성자
		this.company = company;
	}
	
	public void showPhoneInfo() {
		System.out.println();
		super.showPhoneInfo(); //상속받은 부모의 showPhoneInfo() 메소드 사용
		System.out.println("company : "+company);
	}
}
