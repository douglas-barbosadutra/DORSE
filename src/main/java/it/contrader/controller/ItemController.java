package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ItemDTO;
import it.contrader.dto.ThingDTO;
import it.contrader.service.ItemService;
import it.contrader.service.ThingService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	private ItemService itemService;
	private ThingService thingService;
	
	@Autowired
	public ItemController(ItemService itemService, ThingService thingService) {
		this.itemService = itemService;
		this.thingService = thingService;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(
			@RequestParam(value = "description") String description,
			@RequestParam(value = "itemtype") String type,
			@RequestParam(value = "thing_id") String thing_id,
			@RequestParam(value = "status") String status
			)
	{
		ItemDTO itemDTO = new ItemDTO();
		ThingDTO thingDTO = thingService.read(Long.parseLong(thing_id));
		
		itemDTO.setDescription(description);
		itemDTO.setType(type);
		itemDTO.setThingDTO(thingDTO);
		itemDTO.setStatus(Boolean.parseBoolean(status));
		
		itemService.insert(itemDTO);
		return "hometutor";
	}
}
