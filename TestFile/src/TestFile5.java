import java.io.File;
import java.io.FileFilter;

public class TestFile5 {

	public static void main(String[] args) {
		new TestFile5().run();
	}
	public void run(){
		File f=new File("D:\\Javatest\\TestFile\\temp");
		File [] fs = f.listFiles(new DirFilter());
		for(File file:fs){
			System.out.println(file.getName());
		}
	}
	private class DirFilter implements FileFilter {
		
		public boolean accept(File pathname){
			if(pathname.isDirectory()) return  true ;
			else  return false;
		}
	}
}
