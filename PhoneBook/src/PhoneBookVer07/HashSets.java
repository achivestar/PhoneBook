package PhoneBookVer07;

import java.util.HashSet;

public class HashSets {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("First");
		hs.add("Second");
		hs.add("Third");
		hs.add("First");
		
		System.out.println("����� ������ �� :" +hs.size());
	}

}
