package it.contrader.converter;

import it.contrader.dto.ApartmentDTO;
import it.contrader.model.Apartment;

public class ApartmentConverter implements Converter<Apartment, ApartmentDTO> {

	@Override
	public Apartment toEntity(ApartmentDTO apartmentDTO) {
		Apartment apartment = new Apartment();
		if(apartmentDTO!=null) {
			apartment.setId(apartmentDTO.getId());
			apartment.setAddress(apartmentDTO.getAddress());
			apartment.setTutor(apartmentDTO.getTutor());
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
			apartmentDTO.setTutor(apartment.getTutor());
			apartmentDTO.setRooms(apartment.getRooms());
		}
		return apartmentDTO;
	}

}
