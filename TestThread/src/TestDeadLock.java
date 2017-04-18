import java.util.FormatFlagsConversionMismatchException;

import org.omg.CORBA.OBJECT_NOT_EXIST;

public class TestDeadLock {

	public static void main(String[] args) {
		new TestDeadLock().run();
	}
	public void run(){
		Mythread mt=new Mythread();
		new Thread(mt,"����").start();
		new Thread(mt,"����").start();
		
	}
	class Mythread implements Runnable{
		private Object k1=new Object();
		private Object k2=new Object();
		private boolean flag =true;
		@Override
		public void run() {
			if(flag){
				flag=false;
				synchronized (k1) {
					System.out.println(Thread.currentThread().getName()+":k1");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (k2) {
						System.out.println(Thread.currentThread().getName()+":k2");
					}
				}
			} else {
				flag=true;
				synchronized (k2) {
					System.out.println(Thread.currentThread().getName()+":k2");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (k1) {
						System.out.println(Thread.currentThread().getName()+":k1");
					}
				}
			}
		}
	}
}
