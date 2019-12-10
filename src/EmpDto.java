
public class EmpDto {

	private int no;
	private String name;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	public EmpDto(int no, int mgr, int sal, int comm, int deptno, String name, String job, String hiredate) {
		super();
		this.no = no;
		this.mgr = mgr;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
		this.name = name;
		this.job = job;
		this.hiredate = hiredate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public EmpDto() {
		super();
	}
	
}
