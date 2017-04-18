import java.io.File;
import java.io.FilenameFilter;

public class TestFile4 {

	public static void main(String[] args) {
		new TestFile4().run();
	}



	public void run(){
		File f=new File("D:\\Javatest\\TestFile\\temp");
		/*System.out.println(f.exists());
		System.out.println(f.isFile());
		System.out.println(f.isDirectory());*/
		/*
		 * 匿名内部类,该类没有名称,是在代码返回之前实现
		 * 这种方式存在的唯一意义:只有一个方法会用到该类时
		 * 如果有多个方法使用该类,建议使用内部类,而不是匿名类
		 */
		String [] fns=f.list(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {
				return false;
			}
		});
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
}