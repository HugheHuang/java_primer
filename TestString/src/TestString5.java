import java.util.Arrays;
import java.util.List;

public class TestString5 {
	
	public static List<String> accTypes=Arrays.asList("jpg","bmp","gif","doc","rar","xls");
	public static void main(String[] args) {
		for(String arg:args){
			String type=getFileType(arg);
			if(accTypes.contains(type)){
				System.out.println(arg+"合法");
			} else{
				System.out.println(arg+"[不合法]");
			}
		}
	}
	
	public static String getFileType(String filename){
		int pos=filename.lastIndexOf(".");
		if(pos==-1){
			return null;
		}
		return filename.substring(pos+1);
	}
}
