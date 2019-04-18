package it.contrader.dto;

import java.util.Date;
import java.util.List;

import it.contrader.model.Client;
import it.contrader.model.User.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TutorDTO extends UserDTO {
	
	private List<Client> clients;
	
	public TutorDTO(long id, String username, String password, UserType userType, String name, String surname, String email, String address, String telnumber, Date birthdate, String ccc, boolean paymentStatus, List<Client> clients) {
		super(id, username, password, userType, name, surname, email, address, telnumber, birthdate, ccc, paymentStatus);
		this.clients = clients;
	}
}
