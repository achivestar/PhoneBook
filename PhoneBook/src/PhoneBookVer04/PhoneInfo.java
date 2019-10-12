package PhoneBookVer04;

public class PhoneInfo {
  
	String name;
	String phoneNumber;
	
	public PhoneInfo(String name, String num) {
		this.name = name;
		phoneNumber = num;
	}
	
	public void showPhoneInfo() {
		System.out.println();
		System.out.println("name : "+name);
		System.out.println("phone : "+phoneNumber);
	}
	
}
