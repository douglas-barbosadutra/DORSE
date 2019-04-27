package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import it.contrader.dto.ApartmentDTO;
import it.contrader.dto.TutorDTO;
import it.contrader.service.ApartmentService;
import it.contrader.service.TutorService;


@Controller
@RequestMapping("/apartment")
public class ApartmentController {

	private ApartmentService apartmentService;
	private TutorService tutorService;

	@Autowired
	public ApartmentController(ApartmentService apartmentService,TutorService tutorService) {
		this.apartmentService = apartmentService;
		this.tutorService = tutorService;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
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

		return "hometutor";
	}
}
