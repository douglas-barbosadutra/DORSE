package it.contrader.service;

import java.util.List;

import org.springframework.stereotype.Service;
import it.contrader.dao.RoomRepository;
import it.contrader.dto.RoomDTO;
import it.contrader.model.Apartment;
import it.contrader.model.Room;

@Service
public class RoomService extends AbstractService<Room, RoomDTO> {

	@Override
	public List<RoomDTO> getAllBy(Object o) {
		return converter.toDTOList(((RoomRepository)crudRepository).findByApartment_id(((Apartment)o).getId()));
	}
}
