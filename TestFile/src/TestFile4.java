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
		 * �����ڲ���,����û������,���ڴ��뷵��֮ǰʵ��
		 * ���ַ�ʽ���ڵ�Ψһ����:ֻ��һ���������õ�����ʱ
		 * ����ж������ʹ�ø���,����ʹ���ڲ���,������������
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
  /*���������������ĳ������ڲ����Է���,����ֱ�ӽ���д������ڲ�
   * ��������ⲿ���޷�����,����������ڲ���
   * �ڲ���Ҫ��static֮���������,���Բ�����static�ķ�����ʹ���ڲ���
   * */
}