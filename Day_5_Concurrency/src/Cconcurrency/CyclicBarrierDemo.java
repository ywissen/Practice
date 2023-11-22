package Cconcurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//Printing numbers in groups by three threads
public class CyclicBarrierDemo {
	public static void main(String[] args) throws InterruptedException {
		// creating a constructor CyclicBarrier class
		CyclicBarrier cb = new CyclicBarrier(3, new AfterAction());
		for(int i=0;i<3;i++) {
			Thread t1 = new Thread(new TxtReader("T-1", "demo1", cb));
			Thread t2 = new Thread(new TxtReader("T-2", "demo2", cb));
			Thread t3 = new Thread(new TxtReader("T-3", "demo3", cb));
			t1.start();
			Thread.sleep(500);
			t2.start();
			Thread.sleep(500);
			t3.start();
			Thread.sleep(500);
			
		}
		
	}
}

class TxtReader implements Runnable {
	private String threadName;
	private String fileName;
	private CyclicBarrier cb;

	TxtReader(String threadName, String fileName, CyclicBarrier cb) {
		this.threadName = threadName;
		this.fileName = fileName;
		this.cb = cb;
	}

	@Override
	public void run() {
		System.out.println("Reading file " + fileName + " thread " + threadName);
		try {
			// calling await so the current thread suspends
			cb.await();
		} catch (InterruptedException e) {
			System.out.println(e);
		} catch (BrokenBarrierException e) {
			System.out.println(e);
		}
	}
}

class AfterAction implements Runnable {
	@Override
	public void run() {
		System.out.println("In after action class, start further processing as all files are read");
	}
}