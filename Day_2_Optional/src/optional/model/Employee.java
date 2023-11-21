package optional.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
	
	private Long eid;
	
	private String  ename;
	
	private String edesg;
	
	private double esal;

}
