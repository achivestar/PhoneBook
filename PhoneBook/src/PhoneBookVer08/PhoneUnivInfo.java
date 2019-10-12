package PhoneBookVer08;

public class PhoneUnivInfo extends PhoneInfo{

	String major;
	int year;

	public PhoneUnivInfo(String name, String num, String major, int year) {
		super(name,num); // 상속받은 부모의 생성자
		this.major = major;
		this.year = year;
	}


}
