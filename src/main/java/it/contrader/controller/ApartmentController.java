package it.contrader.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.ApartmentDTO;
import it.contrader.dto.TutorDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.ApartmentService;
import it.contrader.service.TutorService;

@RestController
@RequestMapping("/apartment")
@CrossOrigin(origins = "http://localhost:4200")
public class ApartmentController {
	
	@Autowired
	private ApartmentService apartmentService;
	@Autowired
	private TutorService tutorService;
	private UserDTO userDTO;

	public ApartmentController() {
	}

	@PostMapping("/register")
	public String register(HttpServletRequest request,
			@RequestParam(value = "tutor_id") String tutor_idstr,
			@RequestParam(value = "address") String address
			) 
	{
		ApartmentDTO apartmentDTO = new ApartmentDTO();
		long tutor_id = Long.parseLong(tutor_idstr);
		apartmentDTO.setAddress(address);
		TutorDTO tutorDTO = tutorService.read(tutor_id);
		apartmentDTO.setTutorDTO(tutorDTO);
		apartmentService.insert(apartmentDTO);
		List<ApartmentDTO> apartmentlist;
		userDTO = (UserDTO) request.getSession().getAttribute("user");
		apartmentlist = apartmentService.findAllBytutor_id(userDTO.getId());
		request.getSession().setAttribute("apartmentlist", apartmentlist);
		
		return "hometutor";
	}
}
