package allmethods;

import java.util.List;

public class AnyMatch {

	public static void main(String[] args) {

		List<Integer> ls = List.of(10, 21, 35, 40, 34, 60, 70, 80, 90);

		boolean allMatch = ls.stream().anyMatch(a -> a % 2 == 0);
		System.out.println(allMatch);

		List<Integer> ls1 = List.of(11, 21, 35, 47, 39, 63, 77, 82, 91);
		boolean allMatch1 = ls1.stream().allMatch(a -> a % 2 == 0);
		System.out.println(allMatch1);

	}

}
