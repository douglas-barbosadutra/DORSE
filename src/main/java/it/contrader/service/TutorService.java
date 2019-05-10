package it.contrader.service;

import java.util.List;

import org.springframework.stereotype.Service;
import it.contrader.dto.TutorDTO;
import it.contrader.model.Tutor;

@Service
public class TutorService extends AbstractService<Tutor,TutorDTO> {
	
	@Override
	public List<TutorDTO> getAllBy(Object o) {
		return null;
	}
}
