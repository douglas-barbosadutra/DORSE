package it.contrader.dto;

import java.util.Date;
import it.contrader.model.Category;
import it.contrader.model.User.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class OperatorDTO extends UserDTO {
	
	public OperatorDTO(long id, String username, String password, UserType userType, String name, String surname, String email, String address, String telnumber, Date birthdate, String ccc, boolean paymentStatus, Category category, boolean availability) {
		super(id, username, password, userType, name, surname, email, address, telnumber, birthdate, ccc, paymentStatus);
		this.category = category;
		this.availability = availability;
	}

	private Category category;
	
	private boolean availability;
}
