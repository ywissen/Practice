package executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import utils.utilityClass;

public class CompatableFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		//Supply Asnc accept and return the value
		/* CompletableFuture can handle exception, 
		chain the future, it works on unblocking mechanisum ,
		composition methods like thenCompose, 
		thenCombine etc... , It can complete its method */
		CompletableFuture.supplyAsync(() ->{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Iam in run method";
		}).thenAccept(result ->System.out.println(result));
		
		//  Between these two you can observe the non blocking mechanisum
		
		CompletableFuture.supplyAsync(() ->{
			System.out.println(Thread.currentThread().getName());
			return utilityClass.getEmployees();
		}).thenApplyAsync((emp) -> emp.stream().filter((employee)-> employee.getFirstName().startsWith("S")).collect(Collectors.toList()))
		.thenAccept((emp) -> emp.forEach(System.out::println));
		
		// Chain the future
		CompletableFuture<Void> future1 = CompletableFuture.runAsync(()->System.out.println("I am in future 1"));
		CompletableFuture<Void> future2 = CompletableFuture.runAsync(()->System.out.println("I am in future 2"));
		CompletableFuture<Void> future3 = CompletableFuture.runAsync(()->System.out.println("I am in future 3"));
		CompletableFuture<Void> allOf = CompletableFuture.allOf(future1,future2,future3);
		allOf.thenRun(()->{
			System.out.println("Running all the future object");
		});
		
		//Exception handling
		CompletableFuture.supplyAsync(()->{
			System.out.println(10/0);
			return 10;
		}).exceptionally(ex -> {
			System.out.println(ex.getMessage());
			return 0;
		}).handle((a,b) -> b).thenAccept(result -> System.out.println(result));
		
		
		// Giving specific Executor service
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		CompletableFuture.supplyAsync(()->{
			System.out.println(Thread.currentThread().getName());
			return utilityClass.getEmployees();
		}, executor).thenApplyAsync((emp) -> emp.stream().filter((employee)-> employee.getFirstName().startsWith("S")).collect(Collectors.toList()), executor)
		.thenAccept((emp) -> emp.forEach(System.out::println));
		Thread.sleep(3000);
	}

}
