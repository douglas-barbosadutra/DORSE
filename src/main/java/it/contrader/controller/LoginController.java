package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

@RestController
@RequestMapping("/Home")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public UserDTO getByUsernameandPassword(String username, String password) {
		UserDTO userDTO = userService.findByUsernameAndPassword(username,password);
		return userDTO;
	}
}