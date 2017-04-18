import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestHtml {

	public static void main(String[] args) {
		BufferedReader br=null;
		PrintWriter out=null;
		
		try {
			br=new BufferedReader(new InputStreamReader(System.in));
			out=new PrintWriter(new BufferedWriter(new FileWriter("d:/2.html")));
			String str=null;
			while((str=br.readLine())!=null){
				if(str.equals("exit")){
					System.out.println("–ª–ª π”√");
					break;
				}
				out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(br!=null) br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(out!=null) out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

}
