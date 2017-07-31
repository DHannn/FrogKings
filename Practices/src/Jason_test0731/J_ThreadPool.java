package Jason_test0731;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class J_ThreadPool {

	public static void main(String[] args) {
		J_ThreadPool Jpool = new J_ThreadPool();
		Jpool.test();
	}
	
	void test(){
		System.out.println("Hello, ThreadPool Demo!");
		
		method_4();
	}

	void method_1() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			int index =1;
			try {
				Thread.sleep(index * 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println("Index : " + index);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Index : " + index);
				}
			});
		}
		
		cachedThreadPool.shutdownNow();
	}
	
	void method_2(){
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println("Index : " + index);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}

	void method_3(){
		ScheduledExecutorService scheculedThreadPool = Executors.newScheduledThreadPool(5);
		scheculedThreadPool.schedule(new Runnable() {
			public void run() {
				System.out.println("delay 3 seconds.");
			}
		}, 3, TimeUnit.SECONDS);
	}
	
	void method_3_2(){
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println("{1}: delay 1 second, and executed every 3 seconds.");
			}
		}, 1,  3, TimeUnit.SECONDS);
		
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println("{2}: delay 1 second, and executed every 3 seconds.");
			}
		}, 1,  3, TimeUnit.SECONDS);
	}
	
	void method_4(){
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				public void run() {
					try{
					System.out.println("Index : " + index);
					Thread.sleep(2000);					
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}


























