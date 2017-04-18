import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate2 {

	public static void main(String[] args) {
		Date d=new Date();
		//通过1979-1-1 0:0来计算到今天的毫秒数
		long times =d.getTime();
		System.out.println(d.getTime());
		
		try {
		long year=times/(1000*60*60*24)/365;
		System.out.println(year);
		
		String olp="2016-05-27 21:05:59";
		SimpleDateFormat sdf =new SimpleDateFormat(olp);
		long endTime =sdf.parse(olp).getTime();
		long st=times-endTime;
		System.out.println(st/(1000*60*60*24)/365);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
