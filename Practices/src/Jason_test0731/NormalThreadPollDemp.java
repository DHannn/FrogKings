package Jason_test0731;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NormalThreadPollDemp {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(5));

		for (int i = 0; i < 15; i++) {
			Mytask myTask = new Mytask(i);
			executor.execute(myTask);
			System.out.println("线程池中线程数目：" + executor.getPoolSize());
			System.out.println("队列中等待执行的任务数目：" + executor.getQueue().size());
			System.out.println("已执行完成的线程数目：" + executor.getCompletedTaskCount());
		}
	}
}

class Mytask implements Runnable {
	private int taskNum;

	public Mytask(int taskNum) {
		this.taskNum = taskNum;
	}

	@Override
	public void run() {
		System.out.println("正在执行task  " + taskNum);
		try {
			Thread.currentThread().sleep(000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task " + taskNum + "执行完毕");
	}
}
