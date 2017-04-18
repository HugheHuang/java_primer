import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate1 {

	public static void main(String[] args) {
		try {
			//定义一种日期显示格式
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d=new Date();
			//将日期对象格式化为字符串对象,按照SimpleDateFormat中设置格式
			System.out.println(sdf.format(d));
			//创建一个日期的字符串对象
			String str="1987-12-22 12:22:33";
			//将字符串转换为日期,使用sdf格式,注意如果格式不符会抛出异常
			System.out.println(sdf.parse(str));
			//System.out.println(x);
			String ol="2012-08-16 12:00:00";
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
