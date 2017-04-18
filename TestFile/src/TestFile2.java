import java.io.File;
import java.io.FilenameFilter;

public class TestFile2 {

	public static void main(String[] args) {
		File f=new File("D:\\Javatest\\TestFile\\temp");
		/*System.out.println(f.exists());
		System.out.println(f.isFile());
		System.out.println(f.isDirectory());*/
		
		String [] fns=f.list(new JavaFileFilter());
		for(String fn:fns){
			//if(fn.endsWith(".java"))
				System.out.println(fn);
		}
		System.out.println("-----------------");
		File[] fs=f.listFiles();
		for(File file:fs){
			System.out.println(file.getName());
			System.out.println(file.isDirectory());
			System.out.println(file.length());
		}
	}

}
//写一个类实现FilenameFilter专门用来过滤文件
class JavaFileFilter implements FilenameFilter{

	public boolean accept(File dir, String name) {
		//过滤的结果是显示返回为true的值
		if(name.endsWith(".java")) return true;
		return false;
	}
	
}
