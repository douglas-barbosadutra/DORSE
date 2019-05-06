package it.contrader.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController{

	@Autowired
	private UserService userService;
	
	@GetMapping("/getall")
	public List<UserDTO> getUsers() {
        return userService.getAll();
    }
	
	@GetMapping("/read")
	public UserDTO readUser(
			@RequestParam (value = "id") long id
			) {
		 UserDTO userdto= userService.read(id);
		return userdto;
	}
}