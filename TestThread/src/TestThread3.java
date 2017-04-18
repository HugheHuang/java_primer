
public class TestThread3 {

	public static void main(String[] args) {
		new TestThread3().begin();
	}
	/*
	 * 该方法的使用,由于MyThread没有start()方法,
	 * 所以需要将其放置到一个Thread类中运行
	 */
	public void begin(){
		MyThread mt=new  MyThread();
		//放置到一个Thread类中运行
		//构造函数第二个参数就是线程名称
		Thread t=new Thread(mt,"老李");
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
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
		
	}

}
