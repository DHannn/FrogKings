package August.JasonTest0801;

public class testForThreadPool_2 extends Thread {

	private String name;
	private int ticket = 10;

	public testForThreadPool_2(String name) {
		this.name = name;
	}
	
	@Override
	public void run(){
		for (int i = 0; i < 25; i++) {
			if (this.ticket < 1)
				break;
			System.out.println(this.name+"  sell tickets -----> "+(this.ticket --));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testForThreadPool_2 myThread1= new testForThreadPool_2("Windows 1");
		testForThreadPool_2 myThread2 = new testForThreadPool_2("Windows 2");
		testForThreadPool_2 myThread3 = new testForThreadPool_2("Windows 3");
		testForThreadPool_2 myThread4 = new testForThreadPool_2("Windows 4");
		myThread1.start();
		myThread2.start();
		myThread3.start();
		myThread4.start();
	}

}
