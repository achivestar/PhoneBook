package PhoneBookVer08;

public class PhoneUnivInfo extends PhoneInfo{

	String major;
	int year;

	public PhoneUnivInfo(String name, String num, String major, int year) {
		super(name,num); // ��ӹ��� �θ��� ������
		this.major = major;
		this.year = year;
	}


}
