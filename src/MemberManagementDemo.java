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

	// 1. id,name 입력받기
	// 2.어레이 리스트에 멤버 추가
	// 3.print()메소드 호풀,번호 재선택
	// (4).번호 선택하세요 > 출력후 키보드 입력 대기
	// 5.번호 입력 받으면 run() 호출
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

	// 1.수정할 아이디 입력(유일하게 들어간다는 것이 전제)
	// 2.어레이 리스트에서 찾아 있으면 수정할 이름 입력 받아 어레이 리스트에 멤버 정보 수정.(serch 참조?)
	// 3.없다면 "수정할 아이디가 없습니다"라는 메세지 출력
	// 4.수정 확인용 고객 정보 출력>>멤버정보 모두 출력
	// 5.back
	public void update() {
		String id = console("수정할 아이디>");

		print();
		String index = console("번호를 선택하세요>");
		run(index);

	}

	// 1.삭제할 아이디 입력(유일하게 들어간다는 것이 전제)
	// 2.어레이 리스트에서 찾아 있으면 삭제할 이름 입력 받아 어레이 리스트에 멤버 정보 삭제.
	// 3.없다면 "삭제할 아이디가 없습니다"라는 메세지 출력
	// 4.멤버정보 모두 출력
	// 5.back
	public void delete() {
		String id = console("삭제할 아이디>");

	}

	// 1.검색할 아이디 입력(유일하게 들어간다는 것이 전제)
	// 2.어레이 리스트에서 찾아 있으면 검색할 이름 입력 받아 어레이 리스트에 멤버 정보 출력.
	// 3.없다면 "검색된 아이디가 없습니다"라는 메세지 출력
	// 5.back
	public void serch() {
		String id = console("검색할 아이디>");

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
			System.out.println("검색한 아이디가 없습니다.");
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
