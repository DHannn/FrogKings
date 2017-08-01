package August.JasonTest0801;


public class testForThreadPool_1 implements Runnable{
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new testForThreadPool_1("task1"));
		Thread thread2 = new Thread(new testForThreadPool_1("task2"));
		Thread thread3 = new Thread(new testForThreadPool_1("task3"));
		Thread thread4 = new Thread(new testForThreadPool_1("task4"));
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		System.out.println("task started, main ended.");
	}
	private String taskName;
	public  testForThreadPool_1(String taskName){
		super();
		this.taskName = taskName;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("task " + taskName + " is running.");
		for (int i = 0; i < 10 ; i++) {
			System.out.println(taskName + "run" + i);
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(taskName + " is complecated.");
		}
	}
}


