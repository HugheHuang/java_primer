

public class TestShop2 {

	public static void main(String[] args) {
		
			try {
			//	buyClothAndShoe(0, -1);
				buyPants(2);
				buyCloth(23);
			} catch (ClothException e) {
				e.printStackTrace();
			}finally {
				//finally�����е����ݲ�����������ִ��
				//����finally�еĴ���һ�������ͷ���Դ
				System.out.println("����");
			}
			try {
				System.out.println("hello");
			} finally{
				System.out.println("�һ�����");
			}
		
	}
	//���������������÷������ܲ������쳣
	public static void buyCloth(int size)throws ClothException{
		if(size<0){
			//�˴��׳�����һ���쳣����
			throw new ClothException("�·��ߴ粻��");
		}
		System.out.println("����һ��"+size+"����·�");
	}
	
	public static void buyPants(int size){
		if(size<0){
			throw new PantsException("���ӳߴ粻��");
		}
		System.out.println("����һ��"+size+"��Ŀ���");
	}
	
	public static void buyClothAndShoe(int clothSize,int shoeSize) throws ClothException, ShoeException{
		if(clothSize<0){
			throw new ClothException("�·��ߴ粻��");
		}
		if(shoeSize<0){
			throw new ShoeException("Ь�ӳߴ粻��");
		}
		System.out.println("����"+clothSize+"����·���"+shoeSize+"���Ь��");
	}
}
