package allmethods;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartionBy {

	public static void main(String[] args) {

		List<Integer> ls = List.of(10, 21, 35, 40, 34, 60, 70, 80, 90,10,35,40);
		
		Map<Boolean, List<Integer>> collect = ls.stream().collect(Collectors.partitioningBy(a->a%2==0));
		collect.entrySet().forEach(System.out::println);
	}

}
