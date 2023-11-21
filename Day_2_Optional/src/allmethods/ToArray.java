 package allmethods;

import java.util.Arrays;
import java.util.List;

public class ToArray {

	public static void main(String[] args) {

		List<Integer> ls1 = List.of(10, 21, 35, 40, 34, 60, 70, 80, 90);
		Object[] arr =ls1.stream().toArray();
		System.out.println(Arrays.toString(arr));
		
		List<Integer> ls2 = List.of(10, 21, 35, 40, 34, 60, 70, 80, 90);
		Integer[] arr1 =ls2.stream().toArray(Integer[]::new);
		System.out.println(Arrays.toString(arr1));
	}

}
