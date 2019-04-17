package it.contrader.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.UserDTO;
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
	public UserDTO login(
			@RequestParam(value="username", required=true) String username, 
			@RequestParam(value="password", required=true) String password)
	{
		UserDTO userDTO = userService.findByUsernameAndPassword(username,password);
		System.out.println(userDTO.getName());
		return userDTO;
	}
}
