import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestStream1 {
	static FileInputStream fis=null;
	public static void main(String[] args) {
		try {
			//1.����һ���ļ�������
			fis =new FileInputStream("D:\\�ҵ��ĵ�\\�γ�\\C++\\4-1 ��������¼�����ɣ�����.cpp");
			//2.����һ���ַ�����洢��ȡ��Ϣ
			byte[] buf=new byte[1024];
			//3.ʹ��len��ʾ��ȡ�ĳ���
			int len=0;
			//4.ѭ����ȡ����
			//ֻҪlen>=0˵����ȡ��Ԫ��,����ֱ�Ӷ�Ԫ�ز���
			while((len=fis.read(buf))>=0){
				//5.ͨ������̨�������
				System.out.write(buf,0,len);
				//write(buf)���е�С�� ���ܻ����,�������ȷ���ظ���
			}
			//6.��ȡ��ɺ����ر���,�ͷ���Դ
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//�����λ�ùر���
			try {
				if(fis!=null) fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}		}
		
	}

}
