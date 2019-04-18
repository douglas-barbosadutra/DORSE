package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import it.contrader.converter.TutorConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.UserRepository;
import it.contrader.dto.TutorDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Tutor;
import it.contrader.model.User;

@Service
public class TutorService extends AbstractService<Tutor,TutorDTO> {
	
	@Autowired
	public TutorService(CrudRepository<Tutor,Long> crudRepository) {
		this.crudRepository = crudRepository;
		converter = new TutorConverter();
	}
	
}
