package Jason_test0727;
/*
 * 联系使用多线程，使用runnable和Thread
 * Editor：Jason Green
 * */
public class test0727 {

	public static void main(String[] args) {
		test0727 t27 =new test0727();
		Thread Th1 = new Thread();
		new Th1().start();
		new Thread(new Th2()).start();
	}
	


	static class  Th1 extends Thread {
		public void run() {
			super.run();
			task();
		}
	}
	
	static class Th2 implements Runnable{
		public void run() {
			task();
		}
	}
	
	static void task() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100 ; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}

