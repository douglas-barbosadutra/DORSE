package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController{

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<UserDTO> getUsers() {
        return userService.getAll();
    }
}