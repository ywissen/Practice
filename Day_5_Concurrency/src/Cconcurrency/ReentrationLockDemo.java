package Cconcurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrationLockDemo {

	public static void main(String[] args) throws InterruptedException {

		ReentrantLock lock = new ReentrantLock();
		RunnableClass myRnbl = new RunnableClass(lock);
		new Thread(myRnbl, "Thread-1").start();
		Thread.sleep(2000);
		new Thread(myRnbl, "Thread-2").start();
		Thread.sleep(2000);
		new Thread(myRnbl, "Thread-3").start();
		Thread.sleep(2000);
		new Thread(myRnbl, "Thread-4").start();
		Thread.sleep(2000);
		new Thread(myRnbl, "Thread-5").start();
		Thread.sleep(2000);
		new Thread(myRnbl, "Thread-6").start();

	}
}

class RunnableClass implements Runnable {

	ReentrantLock lock;

	public RunnableClass(ReentrantLock lock) {
		this.lock = lock;
	}

	public void run() {

		System.out.println(Thread.currentThread().getName() + " is Waiting to get the lock");

		lock.lock();

		System.out.println(Thread.currentThread().getName() + " has got the  lock.");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		System.out.println(Thread.currentThread().getName() + " has released the lock.");

		lock.unlock(); // read explanation for 5sec
	}
}
