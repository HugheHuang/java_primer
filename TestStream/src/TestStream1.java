import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestStream1 {
	static FileInputStream fis=null;
	public static void main(String[] args) {
		try {
			//1.创建一个文件输入流
			fis =new FileInputStream("D:\\我的文档\\课程\\C++\\4-1 工作备忘录的生成（链表）.cpp");
			//2.创建一个字符数组存储读取信息
			byte[] buf=new byte[1024];
			//3.使用len表示读取的长度
			int len=0;
			//4.循环读取数据
			//只要len>=0说明读取到元素,可以直接对元素操作
			while((len=fis.read(buf))>=0){
				//5.通过控制台输出数据
				System.out.write(buf,0,len);
				//write(buf)会有点小错 可能会溢出,输出不正确的重复答案
			}
			//6.读取完成后必须关闭流,释放资源
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//在这个位置关闭流
			try {
				if(fis!=null) fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}		}
		
	}

}
