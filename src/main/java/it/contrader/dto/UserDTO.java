package it.contrader.dto;

import java.util.Date;
import it.contrader.model.User.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
	
	public UserDTO cast() {
		UserDTO userDTO;
		switch (userType){
		case SUPERUSER:
			userDTO = new SuperuserDTO();
			break;
		case OPERATOR:
			userDTO = new OperatorDTO();
			break;
		case TUTOR:
			userDTO = new TutorDTO();
			break;
		default:
			userDTO = null;
		}
		
		userDTO.setId(id);
		userDTO.setUsername(username);
		userDTO.setPassword(password);
		userDTO.setUserType(userType);
		userDTO.setName(name);
		userDTO.setSurname(surname);
		userDTO.setEmail(email);
		userDTO.setAddress(address);
		userDTO.setTelnumber(telnumber);
		userDTO.setBirthdate(birthdate);
		userDTO.setCcc(ccc);
		userDTO.setPaymentStatus(paymentStatus);
		
		return userDTO;
	}
}
