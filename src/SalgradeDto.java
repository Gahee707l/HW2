
public class SalgradeDto {
	private int grade;
	private int low;
	private int high;
	
	public SalgradeDto() {
		super();
	}
	public SalgradeDto(int grade, int low, int high) {
		super();
		this.grade = grade;
		this.low = low;
		this.high = high;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}

}
