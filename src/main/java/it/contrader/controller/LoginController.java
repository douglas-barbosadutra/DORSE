package it.contrader.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.OperatorDTO;
import it.contrader.dto.SuperuserDTO;
import it.contrader.dto.TutorDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User.UserType;
import it.contrader.service.OperatorService;
import it.contrader.service.SuperuserService;
import it.contrader.service.TutorService;
import it.contrader.service.UserService;

@RestController
@CrossOrigin(origins="*")
public class LoginController {

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
		System.out.println(userdto.getUserType());
		return userdto;

	}
	
	@PostMapping(value = "/register")
	public UserDTO register(

//			@RequestParam(value = "name") String name,
//			@RequestParam(value = "surname") String surname,
//			@RequestParam(value = "birthdate") String birthdate,
//			@RequestParam(value = "telnumber") String telnumber,
//			@RequestParam(value = "email") String email,
//			@RequestParam(value = "address") String address,
//			@RequestParam(value = "ccc") String ccc,
//			@RequestParam(value = "username") String username,
//			@RequestParam(value = "password") String password,
//			@RequestParam(value = "usertype") String userTypestr
			@RequestBody UserDTO userDTO
			) 
	{
		UserType userType = userDTO.getUserType();
		
		switch(userType) {
		case SUPERUSER:
			superuserService.insert((SuperuserDTO)userDTO);
			break;
		case OPERATOR:
			operatorService.insert((OperatorDTO)userDTO);
			break;
		case TUTOR:
			tutorService.insert((TutorDTO)userDTO);
			break;
		default:
		}

//		Date date = null;
//		try {
//			date = new SimpleDateFormat("yyyy-mm-dd").parse(birthdate);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		UserType userType = UserType.valueOf(userTypestr);
//
//
//		switch(userType) {
//		
//		case SUPERUSER:
//			SuperuserDTO superuserDTO = new SuperuserDTO();
//			superuserDTO.setUsername(username);
//			superuserDTO.setPassword(password);
//			superuserDTO.setUserType(userType);
//			superuserDTO.setName(name);
//			superuserDTO.setSurname(surname);
//			superuserDTO.setEmail(email);
//			superuserDTO.setAddress(address);
//			superuserDTO.setTelnumber(telnumber);
//			superuserDTO.setBirthdate(date);
//			superuserDTO.setCcc(ccc);
//			
//			superuserService.insert(superuserDTO);
//			return superuserDTO;
//			
//		case OPERATOR:
//			OperatorDTO operatorDTO = new OperatorDTO();
//			operatorDTO.setUsername(username);
//			operatorDTO.setPassword(password);
//			operatorDTO.setUserType(userType);
//			operatorDTO.setName(name);
//			operatorDTO.setSurname(surname);
//			operatorDTO.setEmail(email);
//			operatorDTO.setAddress(address);
//			operatorDTO.setTelnumber(telnumber);
//			operatorDTO.setBirthdate(date);
//			operatorDTO.setCcc(ccc);
//
//			operatorService.insert(operatorDTO);
//			return operatorDTO;
//			
//		case TUTOR:
//			TutorDTO tutorDTO = new TutorDTO();
//			tutorDTO.setUsername(username);
//			tutorDTO.setPassword(password);
//			tutorDTO.setUserType(userType);
//			tutorDTO.setName(name);
//			tutorDTO.setSurname(surname);
//			tutorDTO.setEmail(email);
//			tutorDTO.setAddress(address);
//			tutorDTO.setTelnumber(telnumber);
//			tutorDTO.setBirthdate(date);
//			tutorDTO.setCcc(ccc);
//			tutorService.insert(tutorDTO);
//			return tutorDTO;
//			
//		default:
//			return null;
//		}
		
		return userDTO;
}

}
