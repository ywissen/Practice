package utils;

import java.time.LocalDate;
import java.util.List;

import model.Employee;


public class utilityClass {

	public static List<Employee> getEmployees(){
		return List.of(new Employee(10, "Sachin", "Tendulkar", 12345.6789, LocalDate.of(1967, 11, 13), "Batsman"),
				new Employee(9, "Dhoni", "M.S", 23434.6786, LocalDate.of(1972, 10, 14), "Keeper"),
				new Employee(18, "Kohli", "Virat", 324.234, LocalDate.of(1979, 9, 2), "All Rounder"),
				new Employee(23, "Shami", "Mahumud", 456.231, LocalDate.of(1973, 8, 10), "Bowler"),
				new Employee(31, "Siraj", "Mahumadh", 45454.234, LocalDate.of(1979, 8, 12), "Bowler"),
				new Employee(53, "Surya Kumar", "Yadhav", 987.21, LocalDate.of(1982, 5, 13), "Batsman"),
				new Employee(21, "Gill", "Subham", 9087.321, LocalDate.of(1999, 11, 02), "All Rounder"));
	}
}
