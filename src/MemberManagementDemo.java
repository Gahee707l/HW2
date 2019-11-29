import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class MemberManagementDemo {

	private ArrayList<Member> list;
	// ctrl shift o = import

	public MemberManagementDemo() {
		list = new ArrayList<Member>();
	}

	public void print() {
		System.out.println("*******************************************");
		// ����
		System.out.println("*1)insert 2)update 3)delete 4)serch 5)exit*");
		System.out.println("*******************************************");
	}

	public String console(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	public void run(String index) {
		if (index.equals("1")) {
			insert();
		} else if (index.equals("2")) {
			update();
		} else if (index.equals("3")) {
			delete();
		} else if (index.equals("4")) {
			serch();
		} else if (index.equals("5")) {
			System.out.print("Now the switch is on OFF.");
		} else {
			System.out.print("Sa-yonara,head!!");
		}
	}

	// 1. id,name �Է¹ޱ�
	// 2.��� ����Ʈ�� ��� �߰�
	// 3.print()�޼ҵ� ȣǮ,��ȣ �缱��
	// (4).��ȣ �����ϼ��� > ����� Ű���� �Է� ���
	// 5.��ȣ �Է� ������ run() ȣ��
	public void insert() {

		String id = console("���̵�>");
		String name = console("�̸�>");

		Member m = new Member(id, name);
		list.add(m);

		System.out.printf("�� ȸ���� %d �Դϴ�.%n", list.size());

		print();
		String index = console("��ȣ�� �����ϼ���>");
		run(index);
	}

	// 1.������ ���̵� �Է�(�����ϰ� ���ٴ� ���� ����)
	// 2.��� ����Ʈ���� ã�� ������ ������ �̸� �Է� �޾� ��� ����Ʈ�� ��� ���� ����.(serch ����?)
	// 3.���ٸ� "������ ���̵� �����ϴ�"��� �޼��� ���
	// 4.���� Ȯ�ο� �� ���� ���>>������� ��� ���
	// 5.back
	public void update() {
		String id = console("������ ���̵�>");

		print();
		String index = console("��ȣ�� �����ϼ���>");
		run(index);

	}

	// 1.������ ���̵� �Է�(�����ϰ� ���ٴ� ���� ����)
	// 2.��� ����Ʈ���� ã�� ������ ������ �̸� �Է� �޾� ��� ����Ʈ�� ��� ���� ����.
	// 3.���ٸ� "������ ���̵� �����ϴ�"��� �޼��� ���
	// 4.������� ��� ���
	// 5.back
	public void delete() {
		String id = console("������ ���̵�>");

	}

	// 1.�˻��� ���̵� �Է�(�����ϰ� ���ٴ� ���� ����)
	// 2.��� ����Ʈ���� ã�� ������ �˻��� �̸� �Է� �޾� ��� ����Ʈ�� ��� ���� ���.
	// 3.���ٸ� "�˻��� ���̵� �����ϴ�"��� �޼��� ���
	// 5.back
	public void serch() {
		String id = console("�˻��� ���̵�>");

		Member m;

		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < list.size(); i++) {
			m = list.get(i);
			map.put(m.getId(), m.getName());
		}

		Set<String> set = map.keySet();
		Iterator<String> ix = set.iterator();

		if (!(id.isEmpty()) && map.get(id) != null) {
			// while (ix.hasNext()) {
			// if(map.get(ix).equals(id)){
			/*for (Member member : list) {
				member.toString();
			}*/
			for(int i=0;i<list.size();i++){
				list.get(i).toString();
			}
		} else {
			System.out.println("�˻��� ���̵� �����ϴ�.");
		}

		/*
		 * if (!(id.isEmpty()) || list.contains(id)) {
		 * 
		 * } else {
		 * 
		 * for (int i = 0; i < list.size(); i++) { m = list.get(i); if
		 * (id.equals(m.getId())) {
		 * 
		 * } } }
		 */

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
