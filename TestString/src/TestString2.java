
public class TestString2 {

	public static void main(String[] args) {
		String str="hello";
		//��ȡĳ��λ�õ��ַ�����0��ʼ
		System.out.println(str.charAt(1));
		
		String str2="heLLo";
		//��дתСд
		System.out.println(str2.toLowerCase());
		//Сдת��д		
		System.out.println(str2.toUpperCase());
		//ȡ�ַ����ĳ���
		System.out.println(str2.length());
		
		String str3="Hello world";
		//�滻�ַ���
		System.out.println(str3.replace("world", "you"));
		//�滻��ԭ���ַ������
		System.out.println(str3);
		//�Ƿ�ʹ��ĳ���ַ�����ͷ,��Сд����
		System.out.println(str3.startsWith("He"));
		//�Ƿ���ĳ���ַ�����β,���������ļ������ж�
		System.out.println(str3.endsWith("world"));
		
		String filename="aaa.txt";
		System.out.println(filename.endsWith("exe"));
		
		String str4="hello";
		String str5="Hello";
		System.out.println(str4.equals(str5));
		//���Դ�Сд���бȽ�
		System.out.println(str4.equalsIgnoreCase(str5));
		
		//ȥ���ַ���ǰ��ͺ���Ŀո�,�м�Ŀո�ȥ��.
		String str6="       skldfja odfada  ";
		System.out.println("|"+str6.trim()+"|");
	}

}
