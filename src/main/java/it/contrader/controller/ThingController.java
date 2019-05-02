package it.contrader.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import it.contrader.dto.ThingDTO;
import it.contrader.service.ThingService;


@Controller
@RequestMapping("/thing")
public class ThingController {
	
 private ThingService thingService;

	public ThingController(ThingService thingService) {
		this.thingService = thingService;
	}
		
	@RequestMapping(value = "/create", method = RequestMethod.POST)
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
