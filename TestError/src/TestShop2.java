

public class TestShop2 {

	public static void main(String[] args) {
		
			try {
			//	buyClothAndShoe(0, -1);
				buyPants(2);
				buyCloth(23);
			} catch (ClothException e) {
				e.printStackTrace();
			}finally {
				//finally语句块中的内容不管怎样都会执行
				//所以finally中的代码一般用于释放资源
				System.out.println("运行");
			}
			try {
				System.out.println("hello");
			} finally{
				System.out.println("我会运行");
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
