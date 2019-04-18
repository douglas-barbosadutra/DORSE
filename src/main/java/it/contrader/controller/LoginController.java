package it.contrader.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.OperatorDTO;
import it.contrader.dto.SuperuserDTO;
import it.contrader.dto.TutorDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User.UserType;
import it.contrader.service.OperatorService;
import it.contrader.service.SuperuserService;
import it.contrader.service.TutorService;
import it.contrader.service.UserService;

@Controller
@RequestMapping("/user")
public class LoginController {

	private UserService userService;
	private SuperuserService superuserService;
	private OperatorService operatorService;
	private TutorService tutorService;

	private HttpSession session;
	
	@Autowired
	public LoginController(UserService userService, SuperuserService superuserService, OperatorService operatorService, TutorService tutorService) {
		this.userService = userService;
		this.superuserService = superuserService;
		this.operatorService = operatorService;
		this.tutorService = tutorService;
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
	public String register(
			
			@RequestParam(value = "name") String name,
			@RequestParam(value = "surname") String surname,
			@RequestParam(value = "birthdate") String birthdate,
			@RequestParam(value = "telnumber") String telnumber,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "ccc") String ccc,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "usertype") String userType) {
		
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-mm-dd").parse(birthdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		UserType userType1 = UserType.valueOf(userType);
		
		//UserDTO userDTO = new UserDTO(3, username, password, UserType.TUTOR, name, surname, email, address, telnumber, d, ccc, false);
		
		switch(userType1) {
		case SUPERUSER:
			SuperuserDTO superuserDTO = new SuperuserDTO(0, username, password, userType1, name, surname, email, address, telnumber, date, ccc, false);
			superuserService.insert(superuserDTO);
			return "homesuperuser";
		case OPERATOR:
			OperatorDTO operatorDTO = new OperatorDTO(0, username, password, userType1, name, surname, email, address, telnumber, date, ccc, false, null, true);
			operatorService.insert(operatorDTO);
			return "homeoperator";
		case TUTOR:
			TutorDTO tutorDTO = new TutorDTO(0, username, password, userType1, name, surname, email, address, telnumber, date, ccc, false, null);
			tutorService.insert(tutorDTO);
			return "hometutor";
		default:
			return null;
		}
	}
}
