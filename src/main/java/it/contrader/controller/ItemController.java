package it.contrader.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.ItemDTO;
import it.contrader.dto.ThingDTO;
import it.contrader.service.ItemService;
import it.contrader.service.ThingService;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private ThingService thingService;
	
	

	@PostMapping("/create")
	public String create(
			@RequestParam(value = "description") String description,
			@RequestParam(value = "itemtype") String type,
			@RequestParam(value = "thing_id") String thing_id
			)
	{
		ItemDTO itemDTO = new ItemDTO();
		ThingDTO thingDTO = thingService.read(Long.parseLong(thing_id));
		itemDTO.setDescription(description);
		itemDTO.setType(type);
		itemDTO.setThingDTO(thingDTO);
		itemDTO.setStatus(false);
		itemService.insert(itemDTO);
		return "hometutor";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request,
			@RequestParam(value = "thing_id") String thing_id
			) 
	{	
		request.getSession().setAttribute("thing_id",thing_id);
		List<ItemDTO> itemlist = itemService.findAllBything_id(Long.parseLong(thing_id));
		request.getSession().setAttribute("itemlist",itemlist);
		
		return "homeitem";	
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request,
			@RequestParam(value = "item_id") String item_id
			) 
	{
		ItemDTO itemDTO = new ItemDTO();
		itemDTO = itemService.read(Long.parseLong(item_id));
		itemService.delete(itemDTO);
		String thing_id = (String) request.getSession().getAttribute("thing_id");
		List<ItemDTO> itemlist = itemService.findAllBything_id(Long.parseLong(thing_id));
		request.getSession().setAttribute("itemlist",itemlist);
		
		return "homeitem";
	
	}
}
