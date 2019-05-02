package it.contrader.converter;

import it.contrader.dto.TutorDTO;
import it.contrader.model.Tutor;

public class TutorConverter extends AbstractConverter<Tutor,TutorDTO> {

//	private ApartmentConverter apartmentConverter;
//	
//	public TutorConverter() {
//		apartmentConverter = new ApartmentConverter();
//	}
	
	@Override
	public Tutor toEntity(TutorDTO tutorDTO) {
		Tutor tutor = null;
		if (tutorDTO != null) {
			tutor = new Tutor();
			
			tutor.setId(tutorDTO.getId());
			tutor.setUsername(tutorDTO.getUsername());
			tutor.setPassword(tutorDTO.getPassword());
			tutor.setUserType(tutorDTO.getUserType());
			tutor.setName(tutorDTO.getName());
			tutor.setSurname(tutorDTO.getSurname());
			tutor.setBirthdate(tutorDTO.getBirthdate());
			tutor.setAddress(tutorDTO.getAddress());
			tutor.setEmail(tutorDTO.getEmail());
			tutor.setTelnumber(tutorDTO.getTelnumber());
			tutor.setCcc(tutorDTO.getCcc());
			tutor.setPaymentStatus(tutorDTO.isPaymentStatus());
			
			//tutor.setApartments(apartmentConverter.toEntityList(tutorDTO.getApartmentsDTO()));
		}
		return tutor;
	}

	@Override
	public TutorDTO toDTO(Tutor tutor) {
		TutorDTO tutorDTO = null;
		if (tutor != null) {
			tutorDTO = new TutorDTO();
			tutorDTO.setId(tutor.getId());
			tutorDTO.setUsername(tutor.getUsername());
			tutorDTO.setPassword(tutor.getPassword());
			tutorDTO.setUserType(tutor.getUserType());
			tutorDTO.setName(tutor.getName());
			tutorDTO.setSurname(tutor.getSurname());
			tutorDTO.setBirthdate(tutor.getBirthdate());
			tutorDTO.setAddress(tutor.getAddress());
			tutorDTO.setEmail(tutor.getEmail());
			tutorDTO.setTelnumber(tutor.getTelnumber());
			tutorDTO.setCcc(tutor.getCcc());
			tutorDTO.setPaymentStatus(tutor.isPaymentStatus());
			
			
			//tutorDTO.setApartmentsDTO(apartmentConverter.toDTOList(tutor.getApartments()));

		}
		return tutorDTO;
	}


}