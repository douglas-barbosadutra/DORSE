package it.contrader.converter;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.contrader.dto.ApartmentDTO;
import it.contrader.model.Apartment;


public class ApartmentConverter implements Converter<Apartment, ApartmentDTO> {

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

	
	public List<Apartment> toEntityList (List<ApartmentDTO> listDTO){
		List<Apartment> list = new ArrayList<Apartment>();
		for (ApartmentDTO cDTO:listDTO) {
			Apartment c = toEntity(cDTO);
			list.add(c);
		}
		return list;
	}

	public List<ApartmentDTO> toDTOList(List<Apartment> list){

		List<ApartmentDTO> listDTO = new ArrayList<ApartmentDTO>();
		for (Apartment c:list) {
			ApartmentDTO cDTO = toDTO(c);
			listDTO.add(cDTO);
		}
		return listDTO;
	}
	
}
