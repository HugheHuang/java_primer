
public class TestThread3 {

	public static void main(String[] args) {
		new TestThread3().begin();
	}
	/*
	 * �÷�����ʹ��,����MyThreadû��start()����,
	 * ������Ҫ������õ�һ��Thread��������
	 */
	public void begin(){
		MyThread mt=new  MyThread();
		//���õ�һ��Thread��������
		//���캯���ڶ������������߳�����
		Thread t=new Thread(mt,"����");
		t.start();
		for(int i=0;i<100;i++){
			System.out.println("main:"+i);
		}
	}
	/*
	 * �ڶ��ַ�ʽ,��һ����ʵ��Runnable�ӿ�,��ʵ��run����
	 */
	class MyThread implements Runnable{

		public void run() {
			for(int i=0;i<100;i++){
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
		
	}

}
