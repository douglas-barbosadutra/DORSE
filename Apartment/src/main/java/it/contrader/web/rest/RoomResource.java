package it.contrader.web.rest;

import org.springframework.web.bind.annotation.*;

import it.contrader.service.dto.RoomDTO;


/**
 * REST controller for managing Room.
 */
@RestController
@RequestMapping("/api/room")
public class RoomResource extends AbstractResource<RoomDTO> {

}
