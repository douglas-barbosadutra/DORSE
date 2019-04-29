package it.contrader.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import it.contrader.dto.*;
import it.contrader.model.User.UserType;
import it.contrader.service.ApartmentService;
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
	private ApartmentService apartmentService;

	@Autowired
	public LoginController(UserService userService, SuperuserService superuserService, OperatorService operatorService, TutorService tutorService, ApartmentService apartmentService) {
		this.userService = userService;
		this.superuserService = superuserService;
		this.operatorService = operatorService;
		this.tutorService = tutorService;
		this.apartmentService = apartmentService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			@RequestParam(value="username", required=true) String username, 
			@RequestParam(value="password", required=true) String password)
	{
		UserDTO userDTO = userService.findByUsernameAndPassword(username,password);
		UserType userType = userDTO.getUserType();
		request.getSession().setAttribute("user", userDTO);
		switch(userType) {
		case SUPERUSER:
			return "homesuperuser";

		case OPERATOR:
			return "homeoperator";
			
		case TUTOR:
			List<ApartmentDTO> apartmentlist;
			apartmentlist = apartmentService.findAllBytutor_id(userDTO.getId());
			
			request.getSession().setAttribute("apartmentlist", apartmentlist);
			return "hometutor";

		default:
			return "index";
		}	

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
			@RequestParam(value = "usertype") String userTypestr
			) 
	{

		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-mm-dd").parse(birthdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		UserType userType = UserType.valueOf(userTypestr);


		switch(userType) {
		
		case SUPERUSER:
			SuperuserDTO superuserDTO = new SuperuserDTO();
			superuserDTO.setUsername(username);
			superuserDTO.setPassword(password);
			superuserDTO.setUserType(userType);
			superuserDTO.setName(name);
			superuserDTO.setSurname(surname);
			superuserDTO.setEmail(email);
			superuserDTO.setAddress(address);
			superuserDTO.setTelnumber(telnumber);
			superuserDTO.setBirthdate(date);
			superuserDTO.setCcc(ccc);
			
			superuserService.insert(superuserDTO);
			
			return "index";
			
		case OPERATOR:
			OperatorDTO operatorDTO = new OperatorDTO();
			operatorDTO.setUsername(username);
			operatorDTO.setPassword(password);
			operatorDTO.setUserType(userType);
			operatorDTO.setName(name);
			operatorDTO.setSurname(surname);
			operatorDTO.setEmail(email);
			operatorDTO.setAddress(address);
			operatorDTO.setTelnumber(telnumber);
			operatorDTO.setBirthdate(date);
			operatorDTO.setCcc(ccc);

			operatorService.insert(operatorDTO);

			return "index";
			
		case TUTOR:
			TutorDTO tutorDTO = new TutorDTO();
			tutorDTO.setUsername(username);
			tutorDTO.setPassword(password);
			tutorDTO.setUserType(userType);
			tutorDTO.setName(name);
			tutorDTO.setSurname(surname);
			tutorDTO.setEmail(email);
			tutorDTO.setAddress(address);
			tutorDTO.setTelnumber(telnumber);
			tutorDTO.setBirthdate(date);
			tutorDTO.setCcc(ccc);
			tutorService.insert(tutorDTO);
			
			return "index";
			
		default:
			return "index";
		}
	}
}
