package August.JasonTest0801;


public class testForThreadPool_3 implements Runnable {
	private String name;
	private int ticket = 500;
	
	public testForThreadPool_3(String name, int ticket) {
		this.name = name;
		this.ticket = ticket;
	}
	@Override
	public void run() {
		for (int i = 0; i < 16; i++) {
			if (this.ticket > 0) {
				
				System.out.println(Thread.currentThread().getName() + " is selling -----> " +this.ticket--);
			}
		}
	}
	
	public static void main(String[] args) {
	 testForThreadPool_3 myThread = new testForThreadPool_3("Thread 1", 10);
	 Thread t1 = new Thread(myThread, "一号窗口");
	 Thread t2 = new Thread(myThread, "二号窗口");
	 Thread t3 = new Thread(myThread, "三号窗口");
	 t1.start();
	 t2.start();
	 t3.start();
	}
}
