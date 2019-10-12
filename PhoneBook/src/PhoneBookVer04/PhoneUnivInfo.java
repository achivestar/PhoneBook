package PhoneBookVer04;

public class PhoneUnivInfo extends PhoneInfo{

	String major;
	int year;
	
	public PhoneUnivInfo(String name, String num, String major, int year) {
		super(name,num); // 상속받은 부모의 생성자
		this.major = major;
		this.year = year;
	}
	
	public void showPhoneInfo() {
		System.out.println();
		super.showPhoneInfo(); // 상속받은 부모의 showPhoneInfo() 메소드 사용
		System.out.println("major : "+major);
		System.out.println("year : "+year);
	}
}
