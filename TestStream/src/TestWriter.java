import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestWriter {

	public static void main(String[] args) {
		BufferedReader br=null;
		PrintWriter out=null;
		try {
			//�ַ���������ȡ�ַ�����,���������ַ�������,
			//��Ϊ���ò�������Ϊʹ��BufferedReader
			//��Ϊ������һ��readLine()����
			br=new BufferedReader(new FileReader("D:\\Javatest\\TestFile\\temp\\num2.dat"));
			//out=new PrintWriter(new BufferedWriter(new FileWriter("D:\\Javatest\\TestFile\\temp\\num2.txt")));
			BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\Javatest\\TestFile\\temp\\num2.txt"));
			String str=null;
			while((str=br.readLine())!=null){
				System.out.println(str);
				bw.write(str+'\n');
				//bw.newLine();
			}
			bw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
