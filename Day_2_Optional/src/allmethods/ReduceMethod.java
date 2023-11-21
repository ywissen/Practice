package allmethods;

import java.util.List;

public class ReduceMethod {

	public static void main(String[] args) {

		List<Integer> ls = List.of(10, 21, 35, 40, 34, 60, 70, 80, 90);
		
		Integer integer = ls.stream().reduce((a,b)->a+b).get();
		System.out.println(integer);
	}

}
