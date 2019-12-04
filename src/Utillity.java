import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utillity {

	public static boolean isCopy(String from, String to) {
		// 객체 없이 클래스에서 겁근만 하니까 static ,성공 여부

		FileInputStream fis = null;
		FileOutputStream fos = null;
		boolean isSuccess = false;
		try {

			fis = new FileInputStream(from);
			fos = new FileOutputStream(to);
			int readByte = 0;

			byte[] readBytes = new byte[1024 * 2];
			int readByteCount = 0;
			while ((readByteCount = fis.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readByteCount);
			}
			isSuccess = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return isSuccess;
	}

	public static String getDate(String pattern) {
		//							년일지 월일지 일일지...
		return new SimpleDateFormat("pattern").format(Calendar.getInstance().getTime());
	}

}
