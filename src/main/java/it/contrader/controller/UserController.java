package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

@Controller
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
	

	
	@DeleteMapping("/delete")
	public void delete(@RequestParam(value = "id") long id) {
	
		System.out.println("mappatura ok");
		System.out.println(id);
		this.userService.delete(id);;
}
	
	
}