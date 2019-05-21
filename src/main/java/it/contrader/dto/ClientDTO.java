package it.contrader.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class ClientDTO {

	private long id;
	
	private String name;
	
	private String surname;
	
	private Date birthdate;
	
	private String telnumber;
	
	private ApartmentDTO apartment;
	
	private TutorDTO tutorDTO;
	
//	private List<DiseaseDTO> diseases;	
	
}
