package streams.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import streams.model.Employee;
import streams.utils.UtilityClass;

public class Test2 {

	/*
		3. Write a program to print sorted list of employees by firstName in all departments except HR department. 
		4. Write a program to increment salary of employees in particular department by 10%.
		5. Write a program using stream to print 50 odd numbers after 100. 
		6. Write a program to create comma seperated list of First names of employees order by dateOfbirth.
	 */
	
	
	public static void main(String[] args) {

		//3. Write a program to print sorted list of employees by firstName in all departments except HR department.
		List<Employee> employees = UtilityClass.getEmployee();
		
		employees.sort((emp1,emp2)->{
			if(emp1.getDepartment().equals("HR") || emp2.getDepartment().equals("HR"))
				return 0;
			else if (emp1.getName().compareTo(emp2.getName())<0) {
				return -1;
			}
			else return 1;
		});
		employees.forEach(System.out::println);
		
		System.out.println();
		
		//4. Write a program to increment salary of employees in particular department by 10%.
		List<Employee> collect = employees.stream().map(emp -> {
			if(emp.getDepartment().equals("IT")){
				return new Employee(emp.getId(), emp.getName(), emp.getJoineYear(), emp.getDepartment(), emp.getDob(), emp.getSalary()+emp.getSalary()*0.1);
			}
			return emp;
		}).collect(Collectors.toList());
		collect.forEach(System.out::println);
		
		System.out.println();
		
		//5. Write a program using stream to print 50 odd numbers after 100.
		Integer[] array = IntStream.range(100, 200).filter(a->a%2==0).boxed().toArray(Integer[]::new);
		System.out.println(Arrays.toString(array));
		
		//6. Write a program to create comma seperated list of First names of employees order by dateOfbirth.
		List<String> collect2 = employees.stream().sorted((emp1,emp2)->emp1.getDob().compareTo(emp2.getDob())).map(Employee::getName).collect(Collectors.toList());
		
		collect2.forEach(System.out::println);		
		
	}

}
