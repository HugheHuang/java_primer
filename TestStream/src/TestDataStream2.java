import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataStream2 {

	public static void main(String[] args) {
		FileOutputStream fos=null;
		DataOutputStream dos=null;
		DataInputStream dis=null;
		
		try {
			fos=new FileOutputStream("D:\\Javatest\\TestFile\\temp\\num2.dat");
			//���ϣ���洢�����������;�ʹ��DataOutputStream,Ҳ���ǹ�����
			dos=new DataOutputStream(fos);
			dos.writeInt(1282111);
			dos.writeInt(567);
			dos.writeInt(-124234);
			dos.writeInt(666);
			//���ļ���ȡ������������ʹ��DataInputStream,ͬ��Ҳ�ǹ�����
			dis=new DataInputStream(new FileInputStream("D:\\Javatest\\TestFile\\temp\\num2.dat"));
			int a=dis.readInt();
			System.out.println(a);
			System.out.println(dis.readInt());
			System.out.println(dis.readInt());
			System.out.println(dis.readInt());
			System.out.println(dis.readInt());
		//	System.out.println(dis.readInt());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
				
					try {
						if(dos!=null) dos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
		}
	}

}
