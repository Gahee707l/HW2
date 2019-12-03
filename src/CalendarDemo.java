import java.util.*;

public class CalendarDemo {
	
	public static void Calendar(String ymd){
		
		String[] date=ymd.split(" ");
		
		if( date.length == 1 ){
			new Date(Integer.parseInt(date[0]));
		}else if(date.length == 2){
			new Date(Integer.parseInt(date[0]),Integer.parseInt(date[1]));
		}else{
			System.out.println(new Date(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2])).toString());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ymd = sc.nextLine();
		sc.close();
		//year month day
		
		Calendar(ymd);
		//프린트 함수 오버 로딩도 하나의 방법.
	}

}
