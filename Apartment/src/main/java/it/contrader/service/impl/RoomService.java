package it.contrader.service.impl;

import it.contrader.domain.Room;
import it.contrader.service.AbstractService;
import it.contrader.service.dto.RoomDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing Room.
 */
@Service
@Transactional
public class RoomService extends AbstractService<Room,RoomDTO> {


}
