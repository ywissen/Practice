package optional.practice;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import optional.model.Employee;

public class OptionalAllMethodsDemo {

	public static void main(String[] args) throws Exception {

		
		Optional<Employee> optional = Optional.ofNullable(new Employee(10L, "Sachin", "All ROunder", 123456.7890));
		
		Optional<Employee> filter = optional.filter(a->a.getEid()==11);
		//checking object and getting default Employee
		//OrElese Method all accept the type T
		Employee orElse = filter.orElse(new Employee());
		System.out.println(orElse);
		
		System.out.println();
		
		
		Optional<Employee> optional1 = Optional.ofNullable(null);
		//OrElseGet method accept a supplier of same type and get it.
		Employee orElseGet = optional1.orElseGet(() -> new Employee(18L, "Kohli", "Batsman", 9876.12345));
		System.out.println(orElseGet);
		System.out.println();
		
		// ifPresent method only accept the consumer
		optional.ifPresent(System.out::println);
		
		System.out.println();
		
		List<Employee> empList = List.of(new Employee(10L, "Sachin", "Batsman", 1234.567),new Employee(18L, "Kohli", "All ROunder", 34522.4322), new Employee(9L, "Dhoni", "Keeper", 212121.23332));
		//Filtering the Employees by using map
		Optional<List<Employee>> optional3 = Optional.ofNullable(empList).map(a->a.stream().filter(a1->a1.getEsal()<212121).collect(Collectors.toList()));
		System.out.println(optional3.get());
		
		System.out.println();
		
		//If object is not there it will throw No such element exception
	/*	
	    Employee orElseThrow = filter.orElseThrow();
		System.out.println(orElseThrow);
	*/
		// To throw a specific Exception
		Employee orElseThrow = filter.orElseThrow(() -> new Exception());
		System.out.println(orElseThrow);
	}

}
