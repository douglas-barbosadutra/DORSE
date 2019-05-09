package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.RoomDTO;
import it.contrader.model.Room;

@RestController
@RequestMapping("/room")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController extends AbstractController<Room, RoomDTO> {

}
