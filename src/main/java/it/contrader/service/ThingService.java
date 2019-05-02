package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import it.contrader.converter.ThingConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.UserRepository;
import it.contrader.dto.ThingDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Thing;
import it.contrader.model.User;

@Service
public class ThingService extends AbstractService<Thing,ThingDTO> {
	
	@Autowired
	public ThingService(CrudRepository<Thing,Long> crudRepository) {
		this.crudRepository = crudRepository;
		converter = new ThingConverter();
	}
	
	
}
