package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
	
	Integer eid;
	
	String ename;
	
	String eaddress;
	
	String desg;
	
	Double sal;
	
	

}
