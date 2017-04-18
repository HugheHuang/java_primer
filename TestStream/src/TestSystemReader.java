import java.io.IOException;
import java.io.InputStream;

public class TestSystemReader {
	public static void main(String[] args) throws IOException {
			InputStream is=System.in;
			while(true){
				byte[] buf=new byte[1024];
				int len=0;
				while((len=is.read(buf))>0){
					String str=new String(buf,0,len);
					if(str.trim().equals("exit")) {
						System.exit(0);
					}
					System.out.println(str);
				}
			}
	}
}
