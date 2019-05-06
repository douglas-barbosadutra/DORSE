package it.contrader.dto;

import java.util.Date;

import it.contrader.model.User.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

	private long id;
	
	private String username;
	
	private String password;
<<<<<<< Updated upstream

	private String type;
=======
	
	private UserType userType;
	
	private String name;
	
	private String surname;
>>>>>>> Stashed changes
	
	private String email;
	
	private String address;
	
	private String telnumber;
	
	private Date birthdate;
	
	private String ccc;
	
	private boolean paymentStatus;
}
