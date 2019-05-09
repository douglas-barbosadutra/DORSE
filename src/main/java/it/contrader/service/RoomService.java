package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import it.contrader.converter.RoomConverter;
import it.contrader.dto.RoomDTO;
import it.contrader.model.Room;

@Service
public class RoomService extends AbstractService<Room, RoomDTO> {

	@Autowired
	public RoomService(CrudRepository<Room,Long> crudRepository) {
		this.crudRepository = crudRepository;
		converter = new RoomConverter();
	}
}
