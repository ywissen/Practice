package allmethods;

import java.util.List;

public class noneMatch {

	public static void main(String[] args) {

		List<Integer> ls1 = List.of(10, 21, 35, 40, 34, 60, 70, 80, 90);
		
		boolean noneMatch = ls1.stream().noneMatch(a->a>100);
		System.out.println(noneMatch);
		
		boolean noneMatch1 = ls1.stream().noneMatch(a->a<100);
		System.out.println(noneMatch1);
	}

}
