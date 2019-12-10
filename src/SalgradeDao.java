import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalgradeDao {

	static {
		// 객체 생성은 없다,instance로 쓰지 않았으니까.
		try {
			//file에서 읽어와 대입해 넣어두기는 내일
			
			Class.forName("org.mariadb.jdbc.Driver");
			// 생성하지 않고 클래스만 메모리에 올려주는 것,new instance해야 객체 생성됨...늘 클래스가 먼저 올라가고
			// 나중에 객체가 생성된다.
			// 사실 new해도 됨...이럴땐 생성자에 넣는게 좋음.
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// 우리는 싱글턴으로 쓴다,엔트리가 50개로 보통은 제한되어있기 때문이다.
	// 하나만 만들어서 생성도 막아둔채 게속 쓴다는 말

	public static SalgradeDao single;

	private SalgradeDao() {
	}

	public static SalgradeDao getInstance() {
		// 다른데서 못만드니 가져다 쓰라고...
		if (single == null) {
			single = new SalgradeDao();
		}
		return single;
	}

	public boolean insert(SalgradeDto dto) {
		boolean isSucess = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/acorn?autoReconnetion=true", "acorn12",
					"acorn12");

			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO salgrade(grade,losal,hisal) VALUES(?,?,?)");
			pstmt = con.prepareStatement(sql.toString());

			int index = 0;
			// 이 인텍스는 각각의 바운딩연산자들이다...
			pstmt.setInt(++index, dto.getGrade());
			pstmt.setInt(++index, dto.getLow());
			pstmt.setInt(++index, dto.getHigh());

			pstmt.executeUpdate();
			isSucess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isSucess;
	}

	public boolean update(SalgradeDto dto) {
		boolean isSucess = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/acorn?autoReconnetion=true", "acorn12",
					"acorn12");

			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE salgrade ");
			sql.append("SET losal = ?,hisal = ? ");
			sql.append("WHERE grade = ?");
			pstmt = con.prepareStatement(sql.toString());

			int index = 0;
			pstmt.setInt(++index, dto.getLow());
			pstmt.setInt(++index, dto.getHigh());
			pstmt.setInt(++index, dto.getGrade());

			pstmt.executeUpdate();
			isSucess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isSucess;
	}

	public boolean delete(int grade) {
		boolean isSucess = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/acorn?autoReconnetion=true", "acorn12",
					"acorn12");

			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM salgrade ");
			sql.append("WHERE grade = ?");
			pstmt = con.prepareStatement(sql.toString());

			int index = 0;
			pstmt.setInt(++index, grade);

			pstmt.executeUpdate();
			isSucess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isSucess;
	}

	public SalgradeDto select(int grade) {
		SalgradeDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/acorn?autoReconnetion=true", "acorn12",
					"acorn12");

			StringBuffer sql = new StringBuffer();
			sql.append("select grade,losal,hisal ");
			sql.append("FROM salgrade ");
			sql.append("WHERE grade = ?");
			pstmt = con.prepareStatement(sql.toString());

			//잊지말자,이 인덱스는 ?에 대항하는 인덱스이다.
			int index = 0;
			pstmt.setInt(++index, grade);

			rs = pstmt.executeQuery();
			//셀렉트는 executequery로 리턴 값이 다름.
			
			if(rs.next()){
				//여긴 결과물의(각 항) 인덱스임.
				index = 0;
				int grd = rs.getInt(++index);
				int losal = rs.getInt(++index);
				int hisal = rs.getInt(++index);
				
				dto = new SalgradeDto(grd,losal,hisal);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dto;
	}
	public ArrayList<SalgradeDto> select() {
		ArrayList<SalgradeDto> list = new ArrayList<SalgradeDto>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/acorn?autoReconnetion=true", "acorn12",
					"acorn12");

			StringBuffer sql = new StringBuffer();
			sql.append("select grade,losal,hisal ");
			sql.append("FROM salgrade ");
			sql.append("order BY grade");
			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int index = 0;
				int grd = rs.getInt(++index);
				int losal = rs.getInt(++index);
				int hisal = rs.getInt(++index);
				
				list.add(new SalgradeDto(grd,losal,hisal));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
