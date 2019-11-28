//import java.lang.*;

public class Member {//extends Object
	private String id;
	private String name;

	public Member(String id, String name) {
		//super();
		this.id = id;
		this.name = name;
	}
	//alt shift s o
	//alt shift s r
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//alt shif s s
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + "]";
	}
	

}
