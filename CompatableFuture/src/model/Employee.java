package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
	Functional Interface
	Common class to use in the example for practice. 
	Create class Employee with fields firstName, lastName, id, dateOfBirth, salary, dept. 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private Double salary;
	private LocalDate dob;
	private String dept;

}
