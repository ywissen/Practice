package allmethods;

import java.util.List;

public class FindFirstAndSkip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> ls = List.of(10, 21, 35, 40, 34, 60, 70, 80, 90);
		
		Integer integer = ls.stream().findFirst().get();
		System.out.println(integer);
		
		Integer integer2 = ls.stream().skip(2).findFirst().get();
		System.out.println(integer2);
	}

}
