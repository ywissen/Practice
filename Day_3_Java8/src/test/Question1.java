package test;

import java.time.LocalDate;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Employee;
import utils.UtilityClass;

public class Question1 {

	public static void main(String[] args) {

		/*
			Question 1: Create list of employees and print list of employess whose salary is above 2000. 
			Write java 8 consumer which will print employee datails. Use this consumer to print results of methods whenever needed. 
			Write java 8 predicate which can tell if employee salary is above 2000. Another option is Write BiPredicate where this 2000 is sent as another argument. 
		 */
		
		
		//Create list of employees and print list of employess whose salary is above 2000.
		List<Employee> employees = UtilityClass.getEmployees();
		List<Employee> collect = employees.stream().filter(emp -> emp.getSalary()>2000).collect(Collectors.toList());
		collect.forEach(System.out::println);
		
		System.out.println();
		
		//Write java 8 consumer which will print employee datails. Use this consumer to print results of methods whenever needed. 
		Consumer<List<Employee>> consumer  = (emp)-> emp.forEach(System.out::println);;
		consumer.accept(collect);
		
		System.out.println();
		
		//Write java 8 predicate which can tell if employee salary is above 2000. Another option is Write BiPredicate where this 2000 is sent as another argument.
		Predicate<Employee> predicate =(emp) -> emp.getSalary()>2000;
		boolean test = predicate.test(new Employee(9, "Dhoni", "M.S", 23434.6786, LocalDate.of(1972, 10, 14), "Keeper"));
		if(test) {
			System.out.println("Employee salary is not less than 2000");
		}
		else {
			System.out.println("Employee salary is less than 2000");			
		}
		
		System.out.println();
		
		BiPredicate<Employee,Double> biPredicate = (emp,sal)->emp.getSalary()==sal; 
		boolean b1 =biPredicate.test(new Employee(9, "Dhoni", "M.S", 23434.6786, LocalDate.of(1972, 10, 14), "Keeper"), 23434.6786);
		if(b1) {
			System.out.println("Employee salary is equal");
		}
		else {
			System.out.println("Employee salary is not equal");			
		}
		
	}

}
