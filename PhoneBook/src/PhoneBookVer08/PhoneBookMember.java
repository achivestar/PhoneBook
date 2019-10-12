package PhoneBookVer08;

public class PhoneBookMember {

	private String name;
	private String phoneNum;
	private String mayer;
	private int year;
	private String company;
	
	public PhoneBookMember(String name,String phoneNum,String mayer,int year, String company) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.mayer = mayer;
		this.year = year;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getMayer() {
		return mayer;
	}

	public void setMayer(String mayer) {
		this.mayer = mayer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
}
