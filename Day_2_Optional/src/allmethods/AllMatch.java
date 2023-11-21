package allmethods;

import java.util.List;

public class AllMatch {

	public static void main(String[] args) {

		List<Integer> ls = List.of(10,20,30,40,50,60,70,80,90);
		
		boolean allMatch = ls.stream().allMatch(a-> a%2 == 0);
		System.out.println(allMatch);
		
		List<Integer> ls1 = List.of(10,20,30,40,50,60,25,70,80,90);
		boolean allMatch1 = ls1.stream().allMatch(a-> a%2 == 0);
		System.out.println(allMatch1);
	}

}
