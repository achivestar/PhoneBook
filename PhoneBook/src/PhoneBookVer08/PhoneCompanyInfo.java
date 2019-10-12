package PhoneBookVer08;

public class PhoneCompanyInfo extends PhoneInfo{

	String company;
	
	public PhoneCompanyInfo(String name, String num, String company) {
		super(name, num); //상속받은 부모의 생성자
		this.company = company;
	}
	
}
