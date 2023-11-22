package Cconcurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo{
	   public static void main(String args[])
	   throws InterruptedException{
	   
	      CountDownLatch latch = new CountDownLatch(4);
	      
	      Employee first = new Employee(1000, latch,"EMPLOYEE-1");
	      Employee second = new Employee(2000, latch,"EMPLOYEE-2");
	      Employee third = new Employee(3000, latch,"EMPLOYEE-3");
	      Employee fourth = new Employee(4000, latch,"EMPLOYEE-4");
	      first.start();
	      second.start();
	      third.start();
	      fourth.start();
	      
	      // The main task waits for four threads 
	      latch.await();
	      
	      // Main thread has started
	         System.out.println(Thread.currentThread().getName() +" has finished");
	   }
	}

	class Employee extends Thread{
	   private int delay;
	   private CountDownLatch latch;
	   public Employee(int delay, CountDownLatch latch,String name){
	      super(name);
	      this.delay = delay;
	      this.latch = latch;
	   }
	   @Override
	   public void run(){
	      try{
	         Thread.sleep(delay);
	         latch.countDown();
	         System.out.println(Thread.currentThread().getName()+ " finished");
	      }
	      catch (InterruptedException e){
	         e.printStackTrace();
	      }
	   }
	}