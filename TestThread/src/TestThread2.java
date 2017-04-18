
public class TestThread2 {

	public static void main(String[] args) {
		new TestThread2().begin();
	}
	/*
	 * 该方法的使用,由于MyThread没有start()方法,
	 * 所以需要将其放置到一个Thread类中运行
	 */
	public void begin(){
		MyThread mt=new  MyThread();
		//放置到一个Thread类中运行
		Thread t=new Thread(mt);
		t.start();
		for(int i=0;i<100;i++){
			System.out.println("main:"+i);
		}
	}
	/*
	 * 第二种方式,让一个类实现Runnable接口,并实现run方法
	 */
	class MyThread implements Runnable{

		public void run() {
			for(int i=0;i<100;i++){
				System.out.println("mt:"+i);
			}
		}
		
	}

}
