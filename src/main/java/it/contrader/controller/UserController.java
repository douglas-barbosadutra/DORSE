package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.OperatorDTO;
import it.contrader.dto.SuperuserDTO;
import it.contrader.dto.TutorDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import it.contrader.model.User.UserType;
import it.contrader.service.OperatorService;
import it.contrader.service.SuperuserService;
import it.contrader.service.TutorService;
import it.contrader.service.UserService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController extends AbstractController<User, UserDTO>{
	
	@Autowired
	private UserService userService;
	@Autowired
	private SuperuserService superuserService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private TutorService tutorService;
	
	@PostMapping(value = "/login")
	public UserDTO login(
			@RequestParam (value = "username") String username,
			@RequestParam (value = "password") String password
			) {
		UserDTO userdto = userService.findByUsernameAndPassword(username, password);
		return userdto;

	}
	
	@PostMapping(value = "/register")
	public UserDTO register(@RequestBody UserDTO userDTO) {
		UserType userType = userDTO.getUserType();
		
		switch(userType) {
		case SUPERUSER:
			superuserService.insert((SuperuserDTO)userDTO.cast());
			break;
		case OPERATOR:
			operatorService.insert((OperatorDTO)userDTO.cast());
			break;
		case TUTOR:
			tutorService.insert((TutorDTO)userDTO.cast());
			break;
		default:
		}
		
		return userDTO;
	}
}