import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate1 {

	public static void main(String[] args) {
		try {
			//����һ��������ʾ��ʽ
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d=new Date();
			//�����ڶ����ʽ��Ϊ�ַ�������,����SimpleDateFormat�����ø�ʽ
			System.out.println(sdf.format(d));
			//����һ�����ڵ��ַ�������
			String str="1987-12-22 12:22:33";
			//���ַ���ת��Ϊ����,ʹ��sdf��ʽ,ע�������ʽ�������׳��쳣
			System.out.println(sdf.parse(str));
			//System.out.println(x);
			String ol="2012-08-16 12:00:00";
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
