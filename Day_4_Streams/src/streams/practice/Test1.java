package streams.practice;

import java.util.List;
import java.util.OptionalDouble;

import streams.model.Employee;
import streams.utils.UtilityClass;

public class Test1 {
	
	
	
	/*
	    1. Write a program to print First Name of employees which joined in year 2023. 
		2. Write a program to print count, min, max, sum, and the average of salary of all employees in a perticular department. 
		3. Write a program to print sorted list of employees by firstName in all departments except HR department. 
		4. Write a program to increment salary of employees in particular department by 10%.
		5. Write a program using stream to print 50 odd numbers after 100. 
		6. Write a program to create comma seperated list of First names of employees order by dateOfbirth.
	 */

	public static void main(String[] args) {

		// 1. Write a program to print First Name of employees which joined in year 2023. 
		List<Employee> employee = UtilityClass.getEmployee();
		employee.stream().filter(emp -> emp.getJoineYear().getYear()==2023).forEach(emp ->System.out.println(emp));
		
		System.out.println();
		//2. Write a program to print count, min, max, sum, and the average of salary of all employees in a perticular department.
		//count
		long count = employee.stream().filter(emp -> emp.getDepartment().equals("Finance")).count();
		System.out.println("Number of employee in finace department : "+count);
		
		//min
		Employee employee2 = employee.stream().filter(emp -> emp.getDepartment().equals("Operations")).min((emp1,emp2)->{
			if(emp1.getSalary()<emp2.getSalary())
				return -1;
			else
				return 1;
		}).get();
		
		System.out.println("Lowest salary person in Operations Department is : "+employee2);
		
		//max
		Employee employee3 = employee.stream().filter(emp -> emp.getDepartment().equals("Operations")).min((emp1,emp2)->{
			if(emp1.getSalary()>emp2.getSalary())
				return -1;
			else
				return 1;
		}).get();
		System.out.println("Highest salary person in Operations Department is : "+employee3);
		
		//sum of salary
		double sum = employee.stream().mapToDouble(Employee::getSalary).sum();
		System.out.println("Sum of salary in Operations Department is : "+sum);
		
		// Average of salary
		double asDouble = employee.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
		System.out.println("Average of salary " +asDouble );
	}

}
