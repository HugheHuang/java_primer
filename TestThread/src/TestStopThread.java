
public class TestStopThread {

	public static void main(String[] args) {
		new TestStopThread().run();
	}
	public void run(){
		MyThread mt=new MyThread();
		Thread tmt=new Thread(mt);
		tmt.start();
		
			if(mt.index==500){
				mt.stop1();	
				//让线程停止
				System.out.println("----");
			
			
		}
		
	}
	class MyThread implements Runnable{
		int index=0;
		private boolean flag=true;
		public void run(){
			for(index=0;index<1000;index++){
				if(!flag) break;
				System.out.println("index:"+index);
			}
		}
		public void stop1(){
			//在这个位置释放资源
			flag=false;
		}
	}
}
