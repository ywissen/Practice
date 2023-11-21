package streams.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	private Integer id;
	
	private String name;
	
	private LocalDate joineYear;
	
	private String department;
	
	private LocalDate dob;
	
	private Double salary;

}
