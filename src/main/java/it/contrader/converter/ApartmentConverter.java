package it.contrader.converter;


import java.util.ArrayList;

import java.util.List;
import it.contrader.dto.ApartmentDTO;
import it.contrader.model.Apartment;


public class ApartmentConverter extends AbstractConverter<Apartment, ApartmentDTO> {

	TutorConverter tutorConverter;
	//ClientConverter clientConverter;
	
	public ApartmentConverter() {
		tutorConverter = new TutorConverter();
		//clientConverter = new ClientConverter();
	}

	@Override
	public Apartment toEntity(ApartmentDTO apartmentDTO) {
		Apartment apartment = new Apartment();
		if(apartmentDTO!=null) {
			apartment.setId(apartmentDTO.getId());
			apartment.setAddress(apartmentDTO.getAddress());
			apartment.setTutor(tutorConverter.toEntity(apartmentDTO.getTutorDTO()));
			//apartment.setClients(clientConverter.toEntityList(apartmentDTO.getClientsDTO()));
			apartment.setRooms(apartmentDTO.getRooms());
			
		}
		return apartment;
	}

	
	@Override
	public ApartmentDTO toDTO(Apartment apartment) {
		ApartmentDTO apartmentDTO = new ApartmentDTO();
		if(apartment!=null) {
			apartmentDTO.setId(apartment.getId());
			apartmentDTO.setAddress(apartment.getAddress());
			apartmentDTO.setTutorDTO(tutorConverter.toDTO(apartment.getTutor()));
			//apartmentDTO.setClientsDTO(clientConverter.toDTOList(apartment.getClients()));
			apartmentDTO.setRooms(apartment.getRooms());
		}
		return apartmentDTO;
	}
}
