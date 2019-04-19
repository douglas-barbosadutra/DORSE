package it.contrader.dto;

import java.util.Date;
import java.util.List;
import it.contrader.model.Apartment;
import it.contrader.model.Disease;
import it.contrader.model.Tutor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

	private long id;
	
	private String name;
	
	private String surname;
	
	private Date birthdate;
	
	private String telnumber;
	
	private Apartment apartment;
	
	private List<Disease> diseases;
	
	private Tutor tutor;
	
	
}
