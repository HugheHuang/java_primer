public class TestMain2{
	public static void main(String[] args){
		if(args.length<2){
			System.out.println("��������ȷ����");
			return;
		}
		try{
			//�ַ���ת��Ϊint
			//ת��ʱ���׳���Ӧ��NumberFormatException
			int r=Integer.parseInt(args[0])+Integer.parseInt(args[1]);
		System.out.println(r);
		}
		catch(NumberFormatException e){
			System.out.println("��������ȷ����");
		}
		
	}
}

