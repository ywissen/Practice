package allmethods;

import java.util.List;

public class Count {

	public static void main(String[] args) {

		List<Integer> ls = List.of(10, 21, 35, 40, 34, 60, 70, 80, 90);
		System.out.println(ls.stream().count());
		System.out.println(ls.stream().filter(a->a%2==0).count());
	}

}
