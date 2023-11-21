package streams.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import streams.model.Employee;

public class UtilityClass {
	
	public static List<Employee> getEmployee(){
		
		List<Employee> employees = new ArrayList<>();

        String[] departments = {"IT", "Finance", "HR", "Marketing", "Operations"};

        for (String department : departments) {
            for (int i = 0; i < 10; i++) {
                int id = employees.size() + 1;
                String name = "Employee" + id;
                LocalDate joinYear = LocalDate.now().minusYears(i);
                //System.out.println("joinYear : "+joinYear);
                LocalDate dob = LocalDate.of(1990 + i, i % 12 + 1, (i % 28) + 1);
                Double salary = Double.valueOf(50000 + i * 1000);

                Employee employee = new Employee(id, name, joinYear, department, dob,salary);
                employees.add(employee);
            }
        }
		
		return employees;
	}

}
