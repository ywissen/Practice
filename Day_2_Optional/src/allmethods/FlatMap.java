package allmethods;

import java.util.List;

public class FlatMap {

	public static void main(String[] args) {

		List<Integer> ls1 = List.of(10, 21, 35, 40, 34, 60, 70, 80, 90);
		List<Integer> ls2 = List.of(11, 22, 36, 41, 35, 601, 72, 84, 92);
		List<Integer> ls3 = List.of(12, 23, 37, 42, 36, 61, 73, 81, 99);
		
		List<List<Integer>> ls4 =List.of(ls1,ls2,ls3);
		//Sored method to sort the elements
		List<Integer> list = ls4.stream().flatMap(ls->ls.stream().filter(a->a%2==0)).sorted().toList();
		System.out.println(list);
		
		
	}

}
