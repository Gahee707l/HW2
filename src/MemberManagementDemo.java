import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class MemberManagementDemo {
	
	private ArrayList<Member> list;
	//ctrl shift o = import 
	
	public MemberManagementDemo(){
		list=new ArrayList<Member>();
	}
	
	public void print(){
		System.out.println("*******************************************");
		//예시
		System.out.println("*1)insert 2)update 3)delete 4)serch 5)exit*");
		System.out.println("*******************************************");
	}
	
	public String console(String msg){
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
	public void run (String index){
		if(index.equals("1")){
			insert();
		}else if(index.equals("2")){
			
		}else if(index.equals("3")){
			
		}else if(index.equals("4")){
			
		}else if(index.equals("5")){
			System.out.print("Now the switch is on OFF.");
		}else{
			System.out.print("Sa-yonara,head!!");
		}
	}
	
	//1. id,name 입력받기
	//2.어레이 리스트에 멤버 추가
	//3.print()메소드 호풀,번호 재선택
	//(4).번호 선택하세요 > 출력후 키보드 입력 대기
	//5.번호 입력 바등면 run() 호출
	public void insert(){
		
		String id = console("아이디>");
		String name = console("이름>");
		
		Member m =new Member(id,name);
		list.add(m);
		
		System.out.printf("총 회원은 %d 입니다.%n",list.size());
		
		print();
		String index = console("번호를 선택하세요>");
		run(index);
	}

	public static void main(String[] args) {
		MemberManagementDemo m1 = new MemberManagementDemo();
		
		m1.print();
		String index = m1.console("번호를 선택하세요>");
		m1.run(index);
	}
}
