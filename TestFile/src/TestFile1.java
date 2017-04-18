import java.io.File;
import java.io.IOException;

public class TestFile1 {

	public static void main(String[] args) {
		try {
			File f=new File("d:/Javatest/TestFile/temp/1.txt");
			//�����ļ�
			f.createNewFile();
			//�ж��ļ��Ƿ����
			System.out.println(f.exists());
			//f.delete();
			System.out.println(f.getName());
			//��ȡ�ļ���·��
			System.out.println(f.getParent());
			//���Ի�ȡ���ļ��ĸ����ļ��ж���
			File pf=f.getParentFile();
			//�ж��ļ��Ƿ����ļ���
			System.out.println(pf.isDirectory());
			
			File f2=new File("d:/Javatest/TestFile/temp/a");
			//����һ��Ŀ¼(�ļ���)
			f2.mkdir();
			
			File f3=new File("d:/Javatest/TestFile/temp/a/b/c/d/f/d");
			//�����Ŀ¼������,���ȴ�����Ŀ¼,�ڴ�����Ӧ����Ŀ¼
			f3.mkdirs();
			//���ɾ������Ŀ¼,Ŀ¼��Ϊ�վ��޷�ɾ��
			f3.delete();
			
			//�������ļ�->������������;
			f.renameTo(new File("d:/Javatest/TestFile/a.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
