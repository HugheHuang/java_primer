

public class TestShop {

	public static void main(String[] args) {
		try {
			buyClothAndShoe(0,-1);
			buyPants(2);
			buyCloth(23);
			//������׳��쳣��֧�ֶ�̬
			//���ǲ���˳������Ȳ����˸����쳣���޷�����������쳣
		}catch(PantsException e){
			System.out.println(e.getMessage());
		} catch(ClothException e){
			System.out.println(e.getMessage());
		} catch (ShoeException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			System.out.println("ddd"+e.getMessage());
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
