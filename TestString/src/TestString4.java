
public class TestString4 {

	public static void main(String[] args) {
		String word="this is my world my name";
		//ͨ���ַ���������Ϊ����
		String[] strs=word.split(" ");
		System.out.println(strs.length);
		for(String str:strs){
			System.out.println(str);
		}
		String user="��������Ա,���·�����Ա,ϵͳ�û�";
		String [] rs=user.split(",");
		for(String r:rs){
			System.out.println(r);
		}
	}

}
