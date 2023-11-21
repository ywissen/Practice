package allmethods;

import java.util.ArrayList;
import java.util.List;

public class FlatMaptoFunctions {

	public static void main(String[] args) {

	List<String> ls = List.of("10", "21", "35", "40", "34", "60", "70", "80", "90");
	
	ArrayList<Object> collect = ls.stream().mapToInt(Integer::valueOf).filter(a->a%2==0).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	System.out.println(collect);
	
	//limited the output
	ArrayList<Object> collect1 = ls.stream().mapToDouble(Double::valueOf).limit(5).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	System.out.println(collect1);
	}

}
