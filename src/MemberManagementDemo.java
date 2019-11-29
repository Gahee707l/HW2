import java.util.*;

public class MemberManagementDemo {

	private ArrayList<Member> list;
	// ctrl shift o = import

	public MemberManagementDemo() {
		list = new ArrayList<Member>();
	}

	public void print() {
		System.out.println("*******************************************");
		// 예시
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
		String id = console("아이디>");
		String name = console("이름>");

		Member m = new Member(id, name);
		list.add(m);

		System.out.printf("총 회원은 %d 입니다.%n", list.size());

		print();
		String index = console("번호를 선택하세요>");
		run(index);
	}

	// 1.������ ���̵� �Է�(�����ϰ� ���ٴ� ���� ����)
	// 2.��� ����Ʈ���� ã�� ������ ������ �̸� �Է� �޾� ��� ����Ʈ�� ��� ����
	// ����.(serch ����?)
	// 3.���ٸ� "������ ���̵� �����ϴ�"��� �޼��� ���
	// 4.���� Ȯ�ο� �� ���� ���>>������� ��� ���
	// 5.back
	public void update() {
		String id = console("수정할 아이디>");

		print();
		String index = console("번호를 선택하세요>");
		run(index);

	}

	// 1.������ ���̵� �Է�(�����ϰ� ���ٴ� ���� ����)
	// 2.��� ����Ʈ���� ã�� ������ ������ �̸� �Է� �޾� ��� ����Ʈ�� ��� ����
	// ����.
	// 3.���ٸ� "������ ���̵� �����ϴ�"��� �޼��� ���
	// 4.������� ��� ���
	// 5.back
	public void delete() {
		String id = console("삭제할 아이디>");

	}

	// 1.�˻��� ���̵� �Է�(�����ϰ� ���ٴ� ���� ����)
	// 2.��� ����Ʈ���� ã�� ������ �˻��� �̸� �Է� �޾� ��� ����Ʈ�� ��� ���� ���.
	// 3.���ٸ� "�˻��� ���̵� �����ϴ�"��� �޼��� ���
	// 5.back
	public boolean existingId(String id) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				System.out.println("이미 존재하는 아이디 입니다.");
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	public void serch() {
		String id = console("검색할 아이디>");

		Member m;
		if (existingId(id)) {

		} else {
			System.out.println("검색한 아이디가 없습니다.");
		}

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
