package allmethods;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collect {

	public static void main(String[] args) {

		List<Integer> ls = List.of(10, 21, 35, 40, 34, 60, 70, 80, 90);

		//Filtered the collection and collected the data
		List<Integer> collect = ls.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
		System.out.println(collect);
		
		Stream<String> s = Stream.of("a","b","c");
	    
	    List<String> names = s
	        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

	    System.out.println(names);
	}

}
