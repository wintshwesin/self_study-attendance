package attendance.dao;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class TestTimeZone {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		TimeZone tz = TimeZone.getTimeZone("Asia/Tokyo");
	    SimpleDateFormat sdf = new SimpleDateFormat("MMMMM dd, yyyy HH:mm:ss");
	    sdf.setTimeZone(tz);
	    System.out.println(sdf.format(new Date()));
	    LocalDateTime now = LocalDateTime.now();
	    System.out.println(now.format(DateTimeFormatter.ofPattern("HH:MM:SS")));

	}

}
