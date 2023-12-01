package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Create class User with fields id, userName, password.

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private Integer id;
	private String userName;
	private String password;

}
