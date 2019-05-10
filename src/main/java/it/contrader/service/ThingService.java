package it.contrader.service;

import java.util.List;

import org.springframework.stereotype.Service;
import it.contrader.dao.ThingRepository;
import it.contrader.dto.ThingDTO;
import it.contrader.model.Room;
import it.contrader.model.Thing;


@Service
public class ThingService extends AbstractService<Thing,ThingDTO> {
	
	@Override
	public List<ThingDTO> getAllBy(Object o) {
		return converter.toDTOList(((ThingRepository)crudRepository).findByRoom_id(((Room)o).getId()));
	}
}
