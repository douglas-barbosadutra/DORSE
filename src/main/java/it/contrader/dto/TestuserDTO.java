package it.contrader.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.model.User.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class TestuserDTO extends UserDTO {

	public TestuserDTO(long id, String username, String password, UserType userType, String name, String surname, String email, String address, String telnumber, Date birthdate, String ccc, boolean paymentStatus) {
		super(id, username, password, userType, name, surname, email, address, telnumber, birthdate, ccc, paymentStatus);
	}
}
