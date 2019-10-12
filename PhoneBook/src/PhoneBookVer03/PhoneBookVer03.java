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
		System.out.println("������ �Է��� �����մϴ�.");
		System.out.print("�̸� :");
		String name = sc.nextLine();
		System.out.print("��ȭ��ȣ :");
		String phone = sc.nextLine();
		System.out.print("������� :");
		String birth = sc.nextLine();
		
		infoStorage[curCnt++] = new PhoneInfo(name, phone,birth);
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�."+curCnt);
		
	}
	
	public void searchData() {
		System.out.println("������ �˻��� �����մϴ�.");
		System.out.print("�̸� :");
		String name = sc.nextLine();
		
		int dataIdx = search(name);
		if(dataIdx<0) {
			System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�.\n");
		}else {
			infoStorage[dataIdx].showPhoneInfo();
			System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�."+curCnt);
		}
	}
	
	public void deleteData() {
		System.out.println("������ ������ �����մϴ�.");
		System.out.print("�̸�:");
		String name = sc.nextLine();
		int dataIdx =search(name);
		
		if(dataIdx<0) {
			System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�.");
		}else {
			 for(int i=dataIdx; i<(curCnt-1); i++) {
				 /*curCnt-1 �� �� ������  �ε����� 0���� �����ϴµ�
				 * curCnt�� �ε�����ȣ���� 1�� �� ���Ǿ��ִ�.
				 * ���� ��� dataIdx�� 2�̰� 2�� �ε�����ȣ�� ������ �����ؾ� �ϴ� ��Ȳ�̸�
				 * curCnt�� 3�� �Ǿ� �ִ� ��Ȳ�̴�. �ε����� 0,1,2 
				 * curCnt�� 3�̸�  ArrayIndex ������ ����� �Ǵ� ���̹Ƿ� -1�� �ؾ��Ѵ�
                 * ���� �����ؼ� �Ʒ�   infoStorage[i+1] �� ������ 0,1,2 ������ ����� 
                 * �ȵǴ� ���̴�			
				 */
				 infoStorage[i] = infoStorage[i+1];
				 /* �迭�� �߰��� ����� �����͸� ������ ��쿡��
				  * �ش� �䙠�� �ڿ� ����� ��ҵ��� �� ĭ�� ������ �̵���Ű�� ���·�
				  * �����Ѵ�. 	
				  */
			 }

			 curCnt--; // ������ �ϳ��� ��������    ������
			 System.out.println("������ ������ �Ϸ�Ǿ����ϴ�."+curCnt);
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
			 System.out.println("�����ϼ���");
			 System.out.println("1.�������Է�");
			 System.out.println("2.�����ͻ���");
			 System.out.println("3.�����Ͱ˻�");
			 System.out.println("4.��������ȸ");
			 System.out.println("5.���α׷�����");
			 System.out.print("���� : ");
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
			 case 5 : System.out.println("���α׷��� �����մϴ�.");
	 				  return;
			 }
			 
		 }
	}

}
