package PhoneBookVer08;

public class PhoneCompanyInfo extends PhoneInfo{

	String company;
	
	public PhoneCompanyInfo(String name, String num, String company) {
		super(name, num); //��ӹ��� �θ��� ������
		this.company = company;
	}
	
}
