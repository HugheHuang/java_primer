import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReader {

	public static void main(String[] args) {
		BufferedReader br=null;
		try {
			//�ַ���������ȡ�ַ�����,���������ַ�������,
			//��Ϊ���ò�������Ϊʹ��BufferedReader
			//��Ϊ������һ��readLine()����
			br=new BufferedReader(new FileReader("D:\\Javatest\\TestFile\\temp\\num2.dat"));
			String str=null;
			while((str=br.readLine())!=null){
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
