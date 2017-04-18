
public class TestString3 {

	public static void main(String[] args) {
		//希望获取一个文件的后缀->h.txt
		String str="14.65.416.5h.txt";
		//1.截取子串，开始包含，结束不包含。
		System.out.println(str.substring(0,2));
		//2.获取某个字符串的位置,从0开始，如果字符串不存在返回-1
		System.out.println(str.indexOf("4654156"));
		
		System.out.println(str.lastIndexOf("."));
		System.out.println(str.substring(str.indexOf(".")+1));
		System.out.println(str.substring(str.lastIndexOf(".")+1));
	}
	
	public static String getFileType(String filename){
		int pos=filename.lastIndexOf(".");
		if(pos==-1){
			return null;
		}
		return filename.substring(pos+1);
	}

}
