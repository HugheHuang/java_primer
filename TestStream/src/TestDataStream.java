import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataStream {

	public static void main(String[] args) {
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("D:\\Javatest\\TestFile\\temp\\num.dat");
			String hello="hello world";
			//���ַ��������ַ���(���ֽ�������)
			//Ҫ����������Ļ�
			String str=String.valueOf(1282111);
			byte [] buf=hello.getBytes();
			fos.write(str.getBytes(),0,str.getBytes().length);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
				
					try {
						if(fos!=null) fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
		}
	}

}
