package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.ApartmentDTO;
import it.contrader.model.Apartment;

@Component
public class ApartmentConverter extends AbstractConverter<Apartment, ApartmentDTO> {

	@Autowired
	private TutorConverter tutorConverter;
	
	public ApartmentConverter() {
	}

	@Override
	public Apartment toEntity(ApartmentDTO apartmentDTO) {
		Apartment apartment = new Apartment();
		if(apartmentDTO!=null) {
			apartment.setId(apartmentDTO.getId());
			apartment.setAddress(apartmentDTO.getAddress());
			apartment.setTutor(tutorConverter.toEntity(apartmentDTO.getTutorDTO()));
			
		}
		return apartment;
	}

	
	@Override
	public ApartmentDTO toDTO(Apartment apartment) {
		ApartmentDTO apartmentDTO = new ApartmentDTO();
		if(apartment!=null) {
			apartmentDTO.setId(apartment.getId());
			apartmentDTO.setAddress(apartment.getAddress());
			//TOFIX
			//apartmentDTO.setTutorDTO(tutorConverter.toDTO(apartment.getTutor()));
		}
		return apartmentDTO;
	}
}
