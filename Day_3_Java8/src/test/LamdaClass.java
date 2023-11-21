package test;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import model.Employee;
import model.User;
import utils.UtilityClass;

@FunctionalInterface
interface UserNameGenerator{
	User generate(Integer id,String firstname, String Lastname, LocalDate dob);
}


public class LamdaClass {

	public static void main(String[] args) throws InterruptedException {

		/*
			Lambda: 
			1. Write a program to Sort the list of employees by month in dateOfBirth. in Sort method use Lamda in comparator. 
			2. Write a program to Create 2 threads using lambda. One thread will print list of employees another will print list of users. 
			3. Write own functional interface UserNameGenerator which has generate method which accepts 4 parameters firstName,LastName,YearOfBirth,id. Write logic to implement generate() method using lamda and use it to generate User in question 2 above. 
		 */
		
		//1. Write a program to Sort the list of employees by month in dateOfBirth. in Sort method use Lamda in comparator.
		List<Employee> empList = new ArrayList<>(UtilityClass.getEmployees());
		empList.sort((emp1,emp2)->{
			if(emp1.getDob().getMonthValue()<emp2.getDob().getMonthValue())
				return -1;
			else
				return 1;
		});
		empList.forEach(System.out::println);
		
		System.out.println();
		
		//2. Write a program to Create 2 threads using lambda. One thread will print list of employees another will print list of users.
		//Printing Employees
		new Thread(() -> empList.forEach(System.out::println)).start();
		
		System.out.println();
		
		Supplier<String> supplier = ()->{
			SecureRandom random = new SecureRandom();
			return new BigInteger(64, random).toString(16);
		};
		
		List<User> users = new ArrayList<>();
		
		for(Employee emp : empList ) {
			users.add(new User(emp.getId(),emp.getFirstName()+"_"+emp.getLastName()+"_"+emp.getDob().toString(), supplier.get()));
		}
		//Printing Users
		new Thread(() -> users.forEach(System.out::println)).start();
		
		Thread.sleep(1000);
		
		System.out.println();
		//Generating the User
		UserNameGenerator user = (id, firstName,lastName,dob) -> new User(id,firstName+" "+lastName,supplier.get());
		System.out.println(user.generate(155, "Yogesh", "Burada", LocalDate.of(1999, 12, 02)));
		
		
	}

}
