
public class TestArray {

	public static void main(String[] args) {
		//定义了一个变量nums可以存储4个int型数据
		int[] nums=new int[4];
		
		//不推荐下面这种方式
		int num []=new int[6];
		
		int[] nums2={1,2,3,10};
		
		
		//数组遍历,length
		for(int i=0;i<nums2.length;i++)
			System.out.println(nums2[i]);
		
		
	}

}
