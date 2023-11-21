package allmethods;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingBy {

	public static void main(String[] args) {

		List<Integer> ls = List.of(10, 21, 35, 40, 34, 60, 70, 80, 90,10,35,40,10,40,60,70);
		
		Map<Integer, Long> collect = ls.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		collect.entrySet().forEach(System.out::println);
	}

}
