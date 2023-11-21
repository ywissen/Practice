package allmethods;

import java.util.List;

public class FindAny {

	public static void main(String[] args) {

		List<Integer> ls = List.of(10, 21, 35, 40, 34, 60, 70, 80, 90);
		
		//Get a random integer
		Integer integer = ls.stream().findAny().get();
		System.out.println(integer);
	}

}
