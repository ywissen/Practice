package allmethods;

import java.util.List;
import java.util.stream.Collectors;

public class MapFunction {

	public static void main(String[] args) {

		List<String> ls = List.of("10", "21", "35", "40", "34", "60", "70", "80", "90");
		
		List<Integer> collect = ls.stream().map(Integer::valueOf).collect(Collectors.toList());
		System.out.println(collect);
	
		//Finding the max element
		Integer integer = ls.stream().map(Integer::valueOf).max((a,b)->{
			if(a>b)
				return 1;
			else
				return -1;
		}).get();
		System.out.println(integer);
		
		//Finding the min element
		
		Integer integer2 = ls.stream().map(Integer::valueOf).min((a,b)->{
			if(a>b)
				return 1;
			else
				return -1;
		}).get();
		System.out.println(integer2);
	}

}
