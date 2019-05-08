package it.contrader.dto;

import java.util.Date;
import java.util.List;
import it.contrader.model.Disease;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

	private long id;
	
	private String name;
	
	private String surname;
	
	private Date birthdate;
	
	private String telnumber;
	
	private ApartmentDTO apartmentDTO;
	
	private TutorDTO tutorDTO;
	
	private List<Disease> diseases;	
	
}
