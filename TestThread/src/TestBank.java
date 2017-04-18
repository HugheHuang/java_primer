
public class TestBank {

	public static void main(String[] args) {
		new TestBank().run();
	}
	public void run(){
		Family f=new Family();
		new Thread(f,"丈夫").start();
		new Thread(f,"qizi").start();
		while(true){
			if(f.times>=2){
				f.show();
				break;
			}
		}
	}
	class Family implements Runnable{
		private int saveMoney;
		private int getMoney;
		private int curMoney;
		private int times =0;
		
		//可以直接创建一个对象作为同步锁钥匙
		Object key=new Object();
		@Override
		public void run() {
			//也可以直接用this来做钥匙,任何一个对象都可以做钥匙
			synchronized (key) {
				System.out.println(Thread.currentThread().getName()+"取了:"+getMoney+"元");
				curMoney+=getMoney;
				int temp=saveMoney-getMoney;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				saveMoney=temp;
				times++;
			}
			
		}
		//同步方法,默认使用this作为钥匙
		public synchronized void getMoney(){
			//也可以直接用this来做钥匙,任何一个对象都可以做钥匙
			//synchronized (this) {
				System.out.println(Thread.currentThread().getName()+"取了:"+getMoney+"元");
				curMoney+=getMoney;
				int temp=saveMoney-getMoney;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				saveMoney=temp;
				times++;
			}
		/*
		 * 使用同步方法实际就等于
		 * synchronized (this) {}
		 */
		public Family(){
			saveMoney=5000;
			getMoney=2000;
			curMoney=0;
		}
		public void show(){
			System.out.println("银行还有:"+saveMoney+"元,家中有:"+curMoney+"元");
		}
	}

}
