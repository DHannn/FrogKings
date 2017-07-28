package Jason_test0727;

public class SynchronizedPractices {

	public double num;

	synchronized void deposit(double amt) throws InterruptedException {
		double tmp = num + amt;
		Thread.sleep(100);
		num = tmp;
	}

	synchronized void withdraw(double amt) throws InterruptedException {
		double temp = num - amt;
		Thread.sleep(100);
		num = temp;
	}

	public static void main(String[] args) {

		int inumber = 100;
		Thread[] t = new Thread[inumber];
		final SynchronizedPractices syn = new SynchronizedPractices();
		for (int i = 0; i < inumber; i++) {
			t[i] = new Thread(new Runnable() {
				public void run() {
					try {
						syn.deposit(100.0);
						syn.withdraw(100.0);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			t[i].start();
		}
		for (int i = 0; i < inumber; i++) {
			try {
				t[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Balance is :" + syn.num);
		}
	}
}
