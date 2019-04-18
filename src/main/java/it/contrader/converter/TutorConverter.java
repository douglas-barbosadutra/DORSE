package it.contrader.converter;

import it.contrader.dto.TutorDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Tutor;
import it.contrader.model.User;
import it.contrader.model.User.UserType;

public class TutorConverter implements Converter<Tutor,TutorDTO> {

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
		}
		return tutorDTO;
	}
}