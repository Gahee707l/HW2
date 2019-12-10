public class EmpDao {
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static EmpDao single;

	private EmpDao() {
		// 생성을 막아둔다...50개의 엔트리에서 보통 막히니까.
	}
}