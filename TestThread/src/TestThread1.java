
public class TestThread1 {
	
	public static void main(String[] args) {
		new TestThread1().run();
		
		
	}
	public void run(){
		FirstThread ft=new FirstThread("����");
		//�˴���ʹ��start�������߳�,��������run
		//ft.run();�Ǻ�������
		ft.start();
		for(int i=0;i<100;i++){
			//��ʾmain()��������û���ֶ�����name���߳�
			//ͨ��Thread.currentThread().getName()��ȡ
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}


	public class FirstThread extends Thread {
		//Thread����һ�����Q,ֻҪ�̳�Thread�Ϳ��Ե���super������������
		public FirstThread(String name){
			super (name);
		}

	
		public void run() {
		
			for(int i=0;i<100;i++){
				//Thread����
				System.out.println(this.getName()+":"+i);
			}
		}

	}
}