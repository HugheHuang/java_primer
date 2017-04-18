

public class TestShop {

	public static void main(String[] args) {
		try {
			buyClothAndShoe(0,-1);
			buyPants(2);
			buyCloth(23);
			//捕获和抛出异常都支持多态
			//但是捕获顺序如果先捕获了父类异常就无法捕获子类的异常
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
	//方法上面是声明该方法可能产生的异常
	public static void buyCloth(int size)throws ClothException{
		if(size<0){
			//此处抛出的是一个异常对象
			throw new ClothException("衣服尺寸不对");
		}
		System.out.println("买了一件"+size+"码的衣服");
	}
	
	public static void buyPants(int size){
		if(size<0){
			throw new PantsException("裤子尺寸不对");
		}
		System.out.println("买了一件"+size+"码的裤子");
	}
	
	public static void buyClothAndShoe(int clothSize,int shoeSize) throws ClothException, ShoeException{
		if(clothSize<0){
			throw new ClothException("衣服尺寸不对");
		}
		if(shoeSize<0){
			throw new ShoeException("鞋子尺寸不对");
		}
		System.out.println("买了"+clothSize+"码的衣服和"+shoeSize+"码的鞋子");
	}
}
