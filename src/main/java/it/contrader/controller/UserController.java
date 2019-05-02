package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;

@RestController
@RequestMapping("/Home")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public UserDTO getByUsernameandPassword(String username, String password) {
		UserDTO userDTO = userService.findByUsernameAndPassword(username,password);
		return userDTO;
	}
}