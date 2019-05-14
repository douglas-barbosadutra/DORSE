package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.LoginDTO;
import it.contrader.dto.OperatorDTO;
import it.contrader.dto.SuperuserDTO;
import it.contrader.dto.TestuserDTO;
import it.contrader.dto.TutorDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import it.contrader.model.User.UserType;
import it.contrader.service.OperatorService;
import it.contrader.service.SuperuserService;
import it.contrader.service.TutorService;
import it.contrader.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController extends AbstractController<User, UserDTO>{
	
	@Autowired
	private UserService userService;
	@Autowired
	private SuperuserService superuserService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private TutorService tutorService;
	
	//POST Angular a different DTO depending on UserType
	@PostMapping(value = "/login")
	public UserDTO login( @RequestBody LoginDTO loginDTO ) {
		UserDTO userdto = userService.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
		UserType userType = userdto.getUserType();
		switch(userType){
		case SUPERUSER:
			SuperuserDTO superuser = (SuperuserDTO) userdto.cast();
			return superuser;
		case OPERATOR:
			OperatorDTO operator = (OperatorDTO) userdto.cast();
			return operator;
		case TUTOR:
			TutorDTO tutor = (TutorDTO)  userdto.cast();
			return tutor;
		case TESTUSER:
			TestuserDTO testuser = (TestuserDTO)  userdto.cast();
			return testuser;
		default: break;
		}
	return null;

	}
	
	//INSERT a different DTO depending on UserType
	@Override
	@PostMapping(value = "/insert")
	public UserDTO insert(@RequestBody UserDTO userDTO) {
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