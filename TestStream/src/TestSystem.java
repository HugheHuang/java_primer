import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestSystem {
	public static void main(String[] args) throws IOException {
			BufferedReader br=null;
			try {
				//���ֽ���ת��Ϊ�ַ���
				br=new BufferedReader(new InputStreamReader(System.in));
				String str =null;
				while((str=br.readLine())!=null){
					if(str.equals("exit")) break;
					System.out.println(str);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				try {
					if(br!=null) br.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
	}
}
