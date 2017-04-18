import java.io.File;
import java.io.FilenameFilter;

public class TestFile3 {

	public static void main(String[] args) {
		new TestFile3().run();
	}



	public void run(){
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
  /*如果这个类仅仅是在某个类的内部可以访问,可以直接将类写在类的内部
   * 这个类在外部就无法访问,这种类叫做内部类
   * 内部类要在static之后才能声明,所以不能在static的方法中使用内部类
   * */
class JavaFileFilter implements FilenameFilter{

	public boolean accept(File dir, String name) {
		//过滤的结果是显示返回为true的值
		if(name.endsWith(".java")) return true;
		return false;
	}
	
}
}
