
public class TestThread1 {
	
	public static void main(String[] args) {
		new TestThread1().run();
		
		
	}
	public void run(){
		FirstThread ft=new FirstThread("老张");
		//此处是使用start来开启线程,不是启动run
		//ft.run();是函数调用
		ft.start();
		for(int i=0;i<100;i++){
			//显示main()函数或者没有手动定义name的线程
			//通过Thread.currentThread().getName()获取
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}


	public class FirstThread extends Thread {
		//Thread都有一個名稱,只要继承Thread就可以调用super方法设置名称
		public FirstThread(String name){
			super (name);
		}

	
		public void run() {
		
			for(int i=0;i<100;i++){
				//Thread名称
				System.out.println(this.getName()+":"+i);
			}
		}

	}
}