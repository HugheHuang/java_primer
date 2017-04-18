import java.io.File;
import java.io.IOException;

public class TestFile1 {

	public static void main(String[] args) {
		try {
			File f=new File("d:/Javatest/TestFile/temp/1.txt");
			//创建文件
			f.createNewFile();
			//判断文件是否存在
			System.out.println(f.exists());
			//f.delete();
			System.out.println(f.getName());
			//获取文件夹路径
			System.out.println(f.getParent());
			//可以获取该文件的父类文件夹对象
			File pf=f.getParentFile();
			//判断文件是否是文件夹
			System.out.println(pf.isDirectory());
			
			File f2=new File("d:/Javatest/TestFile/temp/a");
			//创建一个目录(文件夹)
			f2.mkdir();
			
			File f3=new File("d:/Javatest/TestFile/temp/a/b/c/d/f/d");
			//如果父目录不存在,会先创建父目录,在创建相应的子目录
			f3.mkdirs();
			//如果删除的是目录,目录不为空就无法删除
			f3.delete();
			
			//重命名文件->可以用来剪切;
			f.renameTo(new File("d:/Javatest/TestFile/a.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
