package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

@RestController
@CrossOrigin(origins="*")
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/login")
	public UserDTO login(
			@RequestParam (value = "username") String username,
			@RequestParam (value = "password") String password
			) {
		UserDTO userdto = userService.findByUsernameAndPassword(username, password);
		System.out.println(userdto.getUserType());
		return userdto;

	}

}
