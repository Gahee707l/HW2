
public class Date {
	private int year, month, day, dayIdx;
	private static int[] monthArr = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static String[] dayArr = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };
	private int total;

	public Date(int year) {
		this(year, 0, 0);
		printYear();
	}

	public Date(int year, int month) {
		this(year, month, 0);
		printMonth();
	}

	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		getTotal();
	}

	private boolean isLeapYear(int year) {
		if ((year % 4 == 0 && !(year % 100 == 0) || year % 400 == 0)) {
			monthArr[1] = 29;
			return true;
		}
		return false;
	}

	public void printYear() {
		System.out.println(year + "년");

		for (int i = 0; i < monthArr.length; i++) {
			printMonth(i);
		}

	}

	public void printMonth(int month) {
		isLeapYear(year);
		System.out.printf("%d월 \n", month + 1);

		for (int j = 0; j < dayArr.length; j++) {
			System.out.printf("%s\t", dayArr[j]);
		}
		System.out.println();
		for (int z = 0; z <= dayIdx; z++) {
			System.out.printf("\t");
		}
		for (int j = 1; j <= monthArr[month]; j++) {
			if ((j + dayIdx) % 7 == 0) {
				System.out.println();
			}
			System.out.print(j + "\t");
		}
		total += monthArr[month];
		getInitDate();
		System.out.println();
	}

	public void printMonth() {
		isLeapYear(year);
		System.out.printf("%d월 \n", month);

		for (int j = 0; j < dayArr.length; j++) {
			System.out.printf("%s\t", dayArr[j]);
		}
		System.out.println();
		for (int z = 0; z <= dayIdx; z++) {
			System.out.printf("\t");
		}

		// for (int i = 0; i < dayArr.length; i++) {
		for (int j = 1; j <= monthArr[month - 1]; j++) {
			if ((j + dayIdx) % 7 == 0) {
				System.out.println();
			}
			System.out.print(j + "\t");
		}
		total += monthArr[month - 1];
		getInitDate();
		System.out.println();
	}

	public int getTotal() {
		isLeapYear(year);

		int preYear = year - 1;
		int preMonth = month - 1;

		total = preYear * 365 + (preYear / 4 - preYear / 100 + preYear / 400);
		for (int i = 0; i < preMonth; i++) {
			total += monthArr[i];
		}
		total += day;

		getInitDate();

		return total;
	}

	public void getInitDate() {
		dayIdx = total % 7;
	}

	@Override
	public String toString() {
		String res = year + "년 " + month + "월 " + day + "일 " + dayArr[dayIdx] + " 입니다.";
		return res;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getdayIdx() {
		return dayIdx;
	}

	public void setdayIdx(int dayIdx) {
		this.dayIdx = dayIdx;
	}
}
