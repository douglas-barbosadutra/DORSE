package it.contrader.controller;

import org.modelmapper.ModelMapper;
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
//	@Autowired
//	protected ModelMapper modelMapper;
//	
//	//POST Angular a different DTO depending on UserType
//	@PostMapping(value = "/login")
//	public UserDTO login( @RequestBody LoginDTO loginDTO ) {
//		UserDTO userdto = userService.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
//		UserType userType = userdto.getUserType();
//		switch(userType){
//		case SUPERUSER:
//			return modelMapper.map(userdto, SuperuserDTO.class);
//		case OPERATOR:
//			return modelMapper.map(userdto, OperatorDTO.class);
//		case TUTOR:
//			return modelMapper.map(userdto, TutorDTO.class);
//		case TESTUSER:
//			return modelMapper.map(userdto, TestuserDTO.class);
//		default:
//			return null;
//		}
//	}
//	
//	//INSERT a different DTO depending on UserType
//	@Override
//	@PostMapping(value = "/insert")
//	public UserDTO insert(@RequestBody UserDTO userDTO) {
//		UserType userType = userDTO.getUserType();
//		
//		switch(userType) {
//		case SUPERUSER:
//			superuserService.insert(modelMapper.map(userDTO, SuperuserDTO.class));
//			break;
//		case OPERATOR:
//			operatorService.insert(modelMapper.map(userDTO, OperatorDTO.class));
//			break;
//		case TUTOR:
//			tutorService.insert(modelMapper.map(userDTO, TutorDTO.class));
//			break;
//		default:
//			break;
//		}
//		
//		return userDTO;
//	}
}