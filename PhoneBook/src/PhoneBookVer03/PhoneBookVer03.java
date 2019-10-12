package PhoneBookVer03;

import java.util.Scanner;

class PhoneInfo{
	String name;
	String phoneNumber;
	String birth;
	
	public PhoneInfo(String name, String num, String birth) {
		this.name = name;
		this.phoneNumber = num;
		this.birth = birth;
	}
	
	public PhoneInfo(String name, String num) {
		this.name = name;
		phoneNumber = num;
		this.birth = birth;
	}
	
	public void showPhoneInfo() {
		System.out.println("name : "+name);
		System.out.println("phone : "+phoneNumber);
		if(birth!=null) {
			System.out.println("birth : "+birth);
		}
		
		System.out.println();
	}
}

class PhoneBookManager{
	final int MAX_CNT = 3;
	Scanner sc = new Scanner(System.in);
	PhoneInfo[] infoStorage = new PhoneInfo[MAX_CNT];
	int curCnt = 0;
	
	public void inputData() {
		System.out.println("데이터 입력을 시작합니다.");
		System.out.print("이름 :");
		String name = sc.nextLine();
		System.out.print("전화번호 :");
		String phone = sc.nextLine();
		System.out.print("생년월일 :");
		String birth = sc.nextLine();
		
		infoStorage[curCnt++] = new PhoneInfo(name, phone,birth);
		System.out.println("데이터 입력이 완료되었습니다."+curCnt);
		
	}
	
	public void searchData() {
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름 :");
		String name = sc.nextLine();
		
		int dataIdx = search(name);
		if(dataIdx<0) {
			System.out.println("해당하는 데이터가 존재하지 않습니다.\n");
		}else {
			infoStorage[dataIdx].showPhoneInfo();
			System.out.println("데이터 검색이 완료되었습니다."+curCnt);
		}
	}
	
	public void deleteData() {
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("이름:");
		String name = sc.nextLine();
		int dataIdx =search(name);
		
		if(dataIdx<0) {
			System.out.println("해당하는 데이터가 존재하지 않습니다.");
		}else {
			 for(int i=dataIdx; i<(curCnt-1); i++) {
				 /*curCnt-1 을 한 이유는  인덱스는 0부터 시작하는데
				 * curCnt는 인덱스번호보다 1개 더 계산되어있다.
				 * 예를 들어 dataIdx는 2이고 2번 인덱스번호의 정보를 삭제해야 하는 상황이면
				 * curCnt는 3이 되어 있는 상황이다. 인덱스는 0,1,2 
				 * curCnt는 3이면  ArrayIndex 범위를 벗어나게 되는 것이므로 -1을 해야한다
                 * 쉽게 생각해서 아래   infoStorage[i+1] 의 범위가 0,1,2 범위를 벗어나면 
                 * 안되는 것이다			
				 */
				 infoStorage[i] = infoStorage[i+1];
				 /* 배열의 중간에 저장된 데이터를 삭제할 경우에는
				  * 해당 요솧의 뒤에 저장된 요소들을 한 칸씩 앞으로 이동시키는 형태로
				  * 삭제한다. 	
				  */
			 }

			 curCnt--; // 데이터 하나가 빠졌으니    빼야함
			 System.out.println("데이터 삭제가 완료되었습니다."+curCnt);
		}
	}
	
	public void selectData() {
		for(int i=0; i<curCnt; i++) {
			infoStorage[i].showPhoneInfo();
		}
		System.out.println(curCnt);
	}

	private int search(String name) {
		for(int i=0; i<curCnt; i++) {
			PhoneInfo curInfo = infoStorage[i];
			if(name.equals(curInfo.name))
				return i;
		}
		return -1;
	}
}
public class PhoneBookVer03 {

	public static void main(String[] args) {
		 PhoneBookManager manager = new PhoneBookManager();
		 Scanner sc = new Scanner(System.in);
		 int choice;
		 while(true) {
			 System.out.println("선택하세요");
			 System.out.println("1.데이터입력");
			 System.out.println("2.데이터삭제");
			 System.out.println("3.데이터검색");
			 System.out.println("4.데이터조회");
			 System.out.println("5.프로그램종료");
			 System.out.print("선택 : ");
			 choice = sc.nextInt();
			 
			 switch(choice) {
			 case 1 : manager.inputData();
			 		 break;
			 case 2 : manager.deleteData();
	 		         break;
			 case 3 : manager.searchData();
	 		         break;
			 case 4 : manager.selectData();
		         break;
			 case 5 : System.out.println("프로그램을 종료합니다.");
	 				  return;
			 }
			 
		 }
	}

}
