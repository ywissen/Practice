package Cconcurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService es = Executors.newFixedThreadPool(5);
		
		Future  f1 =es.submit(new Square(5));
		Future f2 =es.submit(new Qube(5));
		
		System.out.println("Result f1 : "+f1.get());
		System.out.println("Result f2 : "+f2.get());
	}

}

class Square implements Callable<Integer>{

	int data;
	
	Square(int data){
		this.data = data;
	}
	@Override
	public Integer call() throws Exception {
		return data * data;
	}
	
}

class Qube implements Callable<Integer>{

	int data;
	
	Qube(int data){
		this.data = data;
	}
	@Override
	public Integer call() throws Exception {
		return data * data * data;
	}
	
}

