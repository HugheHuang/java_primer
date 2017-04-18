import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReader {

	public static void main(String[] args) {
		BufferedReader br=null;
		try {
			//字符流用来读取字符数据,对于输入字符流而言,
			//最为常用操作方法为使用BufferedReader
			//因为该流有一个readLine()方法
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
