package it.contrader.dto;

import java.util.Date;

import java.util.List;
import it.contrader.model.User.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TutorDTO extends UserDTO {
	
	private List<ApartmentDTO> apartmentsDTO;
	
	public TutorDTO(long id, String username, String password, UserType userType, String name, String surname, String email, String address, String telnumber, Date birthdate, String ccc, boolean paymentStatus, List<ApartmentDTO> apartmentsDTO) {
		super(id, username, password, userType, name, surname, email, address, telnumber, birthdate, ccc, paymentStatus);
		this.apartmentsDTO = apartmentsDTO;
	}
}
