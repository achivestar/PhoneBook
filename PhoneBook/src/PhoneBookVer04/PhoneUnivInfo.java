package PhoneBookVer04;

public class PhoneUnivInfo extends PhoneInfo{

	String major;
	int year;
	
	public PhoneUnivInfo(String name, String num, String major, int year) {
		super(name,num); // ��ӹ��� �θ��� ������
		this.major = major;
		this.year = year;
	}
	
	public void showPhoneInfo() {
		System.out.println();
		super.showPhoneInfo(); // ��ӹ��� �θ��� showPhoneInfo() �޼ҵ� ���
		System.out.println("major : "+major);
		System.out.println("year : "+year);
	}
}
