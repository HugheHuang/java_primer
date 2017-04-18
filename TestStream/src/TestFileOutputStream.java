import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class TestFileOutputStream {

	public static void main(String[] args) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream("D:\\ͼƬ\\u=3203495992,412977632&fm=21&gp=0.jpg");
			fos=new FileOutputStream("D:/Javatest/TestFile/temp/aa.jpg");
			byte[] buf=new byte[1024];
			int len=0;
			while((len=fis.read(buf))>=0){
				//System.out.write(buf,0,len);;
				fos.write(buf,0,len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
				try {
					if(fis!=null) fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
						if(fos!=null)fos.close();
				} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
			
		}
		
	}

}
