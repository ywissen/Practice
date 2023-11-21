package optional.practice;

import java.util.Optional;

import optional.model.Employee;

public class OptionalDemo {

	public static void main(String[] args) {
		
		Employee emp = new Employee(12L, "Sachin", "Batsman",123.67);

		//Optional class used to avoid NullPointer Exception.
		//Creating an optional class with our object
		Optional<Employee> optional = Optional.ofNullable(emp);
		
		if(optional.isPresent()) {
			Employee emp1 = optional.get();
			System.out.println(emp1);
		}
		else {
			System.out.println("Employee is not Present");
		}
		System.out.println();
		
		//Passing an empty employee
		Employee emp2 = new Employee();
		Optional<Employee> optional1 = Optional.ofNullable(emp2);
		
		if(optional.isPresent()) {
			Employee emp3 = optional1.get();
			System.out.println(emp3);
		}
		else {
			System.out.println("Employee is not present");
		}
		System.out.println();
		
		//Passing an Null object
		Optional<Employee> optional2 = Optional.ofNullable(null);
		
		if(optional2.isPresent()) {
			Employee emp4 = optional2.get();
			System.out.println(emp4);
		}
		else {
			System.out.println("Employee is not present");
		}
		
		
		
	}

}
