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
		//����
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
	
	//1. id,name �Է¹ޱ�
	//2.��� ����Ʈ�� ��� �߰�
	//3.print()�޼ҵ� ȣǮ,��ȣ �缱��
	//(4).��ȣ �����ϼ��� > ����� Ű���� �Է� ���
	//5.��ȣ �Է� �ٵ�� run() ȣ��
	public void insert(){
		
		String id = console("���̵�>");
		String name = console("�̸�>");
		
		Member m =new Member(id,name);
		list.add(m);
		
		System.out.printf("�� ȸ���� %d �Դϴ�.%n",list.size());
		
		print();
		String index = console("��ȣ�� �����ϼ���>");
		run(index);
	}

	public static void main(String[] args) {
		MemberManagementDemo m1 = new MemberManagementDemo();
		
		m1.print();
		String index = m1.console("��ȣ�� �����ϼ���>");
		m1.run(index);
	}
}
