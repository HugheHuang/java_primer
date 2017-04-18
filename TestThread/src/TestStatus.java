
public class TestStatus {

	public static void main(String[] args) {
		new TestStatus().run();
	}
	public void run(){
		MyThread mt=new MyThread("abcd");
		mt.start();
		new MyThread02("ddddddddddddd").start();;
//		try {
		//一直等待该进程执行结束才去执行其它线程
//			mt.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		for(int i=0;i<20;i++){
			System.out.println("main:"+i);
			Thread.yield();
		}
	}
	class MyThread extends Thread{
		public MyThread(String name){
			super(name);
		}
		public void run() {
			for(int i=0;i<10;i++){
				System.out.println("---------------"+this.getName()+":"+i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	class MyThread02 extends Thread{
		public MyThread02(String name){
			super(name);
		}
		public void run() {
			for(int i=0;i<100;i++){
				System.out.println("---------------"+this.getName()+":"+i);
			
			}
			
		}
	}
}
