package Cconcurrency;

import java.util.concurrent.Semaphore;

//printing odd and even numbers by two threads respectively
public class Semaphores {
    public static void main(String[] args){
        Print print = new Print();
        Thread threadOdd = new Thread(new Runnable() {
            @Override
            public void run() {
                while(print.number < 10){
                    print.printOdd();
                }
            }
        }, "Thread-odd");

        Thread threadEven = new Thread(new Runnable() {
            @Override
            public void run() {
                while(print.number < 10){
                    print.printEven();
                }
            }
        }, "Thread-even");

        threadEven.start();
        threadOdd.start();
    }
}

class Print{
    int number;
    Semaphore evenSemaphore;
    Semaphore oddSemaphore;

    Print(){
        number = 1;
        oddSemaphore = new Semaphore(1);
        evenSemaphore = new Semaphore(0);
    }
    void printEven(){
        try {
            evenSemaphore.acquire();
            System.out.println(Thread.currentThread().getName() +" : "+ number);
            number++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            oddSemaphore.release();
        }
    }
    void printOdd(){
        try {
            oddSemaphore.acquire();
            System.out.println(Thread.currentThread().getName() +" : "+ number);
            number++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            evenSemaphore.release();
        }
    }
}



