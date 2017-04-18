
public class TestBank {

	public static void main(String[] args) {
		new TestBank().run();
	}
	public void run(){
		Family f=new Family();
		new Thread(f,"�ɷ�").start();
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
		
		//����ֱ�Ӵ���һ��������Ϊͬ����Կ��
		Object key=new Object();
		@Override
		public void run() {
			//Ҳ����ֱ����this����Կ��,�κ�һ�����󶼿�����Կ��
			synchronized (key) {
				System.out.println(Thread.currentThread().getName()+"ȡ��:"+getMoney+"Ԫ");
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
		//ͬ������,Ĭ��ʹ��this��ΪԿ��
		public synchronized void getMoney(){
			//Ҳ����ֱ����this����Կ��,�κ�һ�����󶼿�����Կ��
			//synchronized (this) {
				System.out.println(Thread.currentThread().getName()+"ȡ��:"+getMoney+"Ԫ");
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
		 * ʹ��ͬ������ʵ�ʾ͵���
		 * synchronized (this) {}
		 */
		public Family(){
			saveMoney=5000;
			getMoney=2000;
			curMoney=0;
		}
		public void show(){
			System.out.println("���л���:"+saveMoney+"Ԫ,������:"+curMoney+"Ԫ");
		}
	}

}
