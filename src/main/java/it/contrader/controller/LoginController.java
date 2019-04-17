package it.contrader.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.UserDTO;
import it.contrader.model.User.UserType;
import it.contrader.service.UserService;

@Controller
@RequestMapping("/user")
public class LoginController {

	private UserService userService;
	private HttpSession session;
	
	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(
			@RequestParam(value="username", required=true) String username, 
			@RequestParam(value="password", required=true) String password)
	{
		UserDTO userDTO = userService.findByUsernameAndPassword(username,password);
		return "home";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public UserDTO register(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "surname") String surname,
			@RequestParam(value = "birthdate") Date birthdate,
			@RequestParam(value = "telnumber") String telnumber,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "ccc") String ccc,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "userType") UserType userType) {
		
		UserDTO userDTO = new UserDTO(Long.parseLong(id), username, password, userType, name, surname, email, address, telnumber, birthdate, ccc, false);
		
		userService.insert(userDTO);
		
		return userDTO;
	}
}
