package it.contrader.dto;

import java.util.Date;
import it.contrader.model.User.UserType;
import lombok.Data;

public class UserDTO {

	private long id;
	
	private String username;
	
	private String password;

	private UserType userType;
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private String address;
	
	private String telnumber;
	
	private Date birthdate;
	
	private String ccc;
	
	private boolean paymentStatus;
	
	public UserDTO castTo(Class subClass) {
		switch (userType){
		case SUPERUSER:
			
		}
	}
}
