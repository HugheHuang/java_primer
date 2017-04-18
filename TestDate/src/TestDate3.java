import java.util.Date;

public class TestDate3 {

	public static void main(String[] args) {
		Date today=new Date();
		System.out.println(String.format("%tc",today));
		System.out.println(String.format("%tr",new Date()));
		System.out.println(String.format("%tA %<tB %<td",new Date()));

	}

}
