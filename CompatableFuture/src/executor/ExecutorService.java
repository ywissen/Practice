package executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorService {

	public static void main(String[] args) {
		
		java.util.concurrent.ExecutorService service = Executors.newFixedThreadPool(10);
		// As we cannot complete the future so we prefer to go to Compatable Future Async methods 
		Future<List<Integer>> future = service.submit(()->{
			//System.out.println(10/0);
			return Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		});
		
		try {
			List<Integer> list = future.get();
			list.forEach(System.out::println);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		CompletableFuture<String> cmf = new CompletableFuture<String>();
		try {
			String string = cmf.get();
			cmf.complete("Yogesh is good Boy");
			System.out.println(string);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

}
