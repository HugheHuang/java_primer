
public class TestThread4 {

	public static void main(String[] args) {
		new TestThread4().run();
	}
	public void run(){
		//ÿ����Ա�������в�ͬ�Ĵ洢�ռ�
		MyThread mt1 =new MyThread("mt1");
		mt1.start();
		MyThread mt2 =new MyThread("mt2");
		mt2.start();
//		for(int i=0;i<10;i++){
//			System.out.println("main:"+i);
//		}
	}
	class MyThread extends Thread{
		private int index=0;
		public void run() {
			for(;index<100;index++){
				System.out.println(Thread.currentThread().getName()+":"+index);
			}
		}
		public MyThread(String name){
			super(name);
		}
	}

}
