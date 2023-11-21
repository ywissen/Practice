package allmethods;

import java.util.List;
import java.util.stream.Collectors;

public class Distinct {

	public static void main(String[] args) {

		List<Integer> ls = List.of(10, 21, 35, 40, 34, 60, 70, 80, 90,10,35,40);
		System.out.println(ls.stream().count());
	
		
		//Gives the unique elements
		System.out.println(ls.stream().distinct().collect(Collectors.toList()));
	}

}
