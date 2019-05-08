package it.contrader.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.ThingDTO;
import it.contrader.service.ThingService;


@RestController
@RequestMapping("/thing")
@CrossOrigin(origins = "http://localhost:4200")
public class ThingController {
	
 private ThingService thingService;
 
 	@Autowired
	public ThingController(){
	}
		

	
	@PostMapping("/create")
	public String register(HttpServletRequest request,
			@RequestParam(value = "description") String description) 
	{
		ThingDTO thingDTO = new ThingDTO();
		thingDTO.setDescription(description);
		thingService.insert(thingDTO);		
		
		List<ThingDTO> thinglist;
		thinglist=thingService.getAll();
		request.getSession().setAttribute("thinglist", thinglist);
		
		
		return "hometutor";
	}

	
	
	
}
