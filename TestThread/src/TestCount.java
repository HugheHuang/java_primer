
public class TestCount {

	public static void main(String[] args) {
		new TestCount().run();
	}
	public void run() {
			MyThread mt=new MyThread();
			new Thread(mt,"mt1").start();
			new Thread(mt,"mt2").start();
		}
	class MyThread implements Runnable {
		int index=0;
		@Override
		public void run() {
			count();
		};
		
		/*
		 * public synchronized void count(){
			for(int i=0;i<10;i++){
			int temp=0;
			temp=index+1;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			index=temp;
			System.out.println(Thread.currentThread().getName()+":"+index);
			//������߳�һ��Ҫ��ѭ��ִ�������һ���̲߳���ִ��
			}
		}
		 */
		//�����̹߳���ͬһ������ʱ�����Ƿ�ͬ��
		public  void count(){
			for(int i=0;i<10;i++){
				synchronized (this) {
					int temp=0;
					temp=index+1;
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
					index=temp;
					System.out.println(Thread.currentThread().getName()+":"+index);
			
				}
			}
		}
	}

}
