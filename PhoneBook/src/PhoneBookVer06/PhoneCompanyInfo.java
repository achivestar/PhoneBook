package PhoneBookVer06;

public class PhoneCompanyInfo extends PhoneInfo{

	String company;
	
	public PhoneCompanyInfo(String name, String num, String company) {
		super(name, num); //��ӹ��� �θ��� ������
		this.company = company;
	}
	
	public void showPhoneInfo() {
		System.out.println();
		super.showPhoneInfo(); //��ӹ��� �θ��� showPhoneInfo() �޼ҵ� ���
		System.out.println("company : "+company);
	}
}
