
public class TestString3 {

	public static void main(String[] args) {
		//ϣ����ȡһ���ļ��ĺ�׺->h.txt
		String str="14.65.416.5h.txt";
		//1.��ȡ�Ӵ�����ʼ������������������
		System.out.println(str.substring(0,2));
		//2.��ȡĳ���ַ�����λ��,��0��ʼ������ַ��������ڷ���-1
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
