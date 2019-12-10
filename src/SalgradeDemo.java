import java.util.ArrayList;

public class SalgradeDemo {
	public static void main(String[] args) {
		SalgradeDao d = SalgradeDao.getInstance();
		// boolean isSuccess = d.insert(new SalgradeDto(6,4000,9999));
		// boolean isSuccess = d.update(new SalgradeDto(6,5000,9000));
		// boolean isSuccess = d.delete(6);
		// System.out.println(isSuccess);

		/*
		 * SalgradeDto dto = d.select(3); if (dto == null) { System.out.println(
		 * "no data"); } else { System.out.printf("%d, %s, %s %n",
		 * dto.getGrade(), dto.getLow(), dto.getHigh()); }
		 */
		ArrayList<SalgradeDto> list = d.select();
		for (SalgradeDto dto : list) {
			System.out.printf("%d, %s, %s %n", dto.getGrade(), dto.getLow(), dto.getHigh());

		}
	}
}
