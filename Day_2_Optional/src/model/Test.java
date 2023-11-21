package model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		Employee emp1 = new Employee(10, "Sachin", "Mumbai", "CEO",9999.0);
		Employee emp2 = new Employee(9, "Dhoni", "Pune", "Chairman",8888.0);
		Employee emp3 = new Employee(18, "Kohli", "Delhi", "Board Member",7777.0);
		Employee emp4 = new Employee(1, "Yogesh", "Andhra", "Head of board",6666.0);
		
		List<Employee> ls1 = List.of(emp1,emp2,emp3,emp4);
		
		
		// Filter and collectors
		List<Employee> collect = ls1.stream().filter(a->a.getSal()>7777.0).collect(Collectors.toList());
		System.out.println(collect);
		
		
		// Limit
		List<Employee>  collect1=ls1.stream().limit(3).collect(Collectors.toList());
		System.out.println(collect1);
		
		// Converting to Array
		Employee[] array = ls1.stream().toArray(Employee[]::new);
		Arrays.stream(array).forEach(System.out::println);
		
		System.out.println();
		
		//sorted Employee
		List<Employee> collect2 = ls1.stream().sorted((a,b)->{
			if(a.getEid()>b.getEid())
				return 1;
			else
				return -1;
		}).collect(Collectors.toList());
		System.out.println(collect2);
		
		//All Match
		boolean allMatch = ls1.stream().allMatch(a-> a.sal>5555.0);
		System.out.println(allMatch);
		
		//Any Match
		boolean anyMatch = ls1.stream().anyMatch(a->a.ename=="Yogesh");
		System.out.println(anyMatch);
		
		//count
		long count = ls1.stream().count();
		System.out.println("Count if employee is : "+count);
		
		//Find Any
		Employee employee = ls1.stream().findAny().get();
		System.out.println(employee);
		
		//Find First
		Employee employee2 = ls1.stream().findFirst().get();
		System.out.println(employee2);
		
		//skip
		Employee employee3 = ls1.stream().skip(1).findFirst().get();
		System.out.println(employee3);
		
		
		//PartionBy
		Map<Boolean, List<Employee>> collect3 = ls1.stream().collect(Collectors.partitioningBy(a->a.sal>6666.0));
		collect3.entrySet().forEach(System.out::println);
		
		//Map Increase the salary
		List<Employee> collect4 = ls1.stream().map(a->new Employee(a.getEid(), a.getEname(), a.getEaddress(), a.getDesg(), a.getSal()+1000)).collect(Collectors.toList());
		System.out.println(collect4);
		
		Employee employee4 = ls1.stream().reduce((a,b)->new Employee(null, null, null, null, a.sal+b.sal)).get();
		System.out.println("Total salary : "+ employee4.sal);
		
		
		
		
	}

}
