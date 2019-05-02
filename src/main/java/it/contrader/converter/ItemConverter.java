package it.contrader.converter;

import java.util.List;

import it.contrader.dto.ClientDTO;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Client;
import it.contrader.model.Item;

public class ItemConverter extends AbstractConverter<Item, ItemDTO> {
	
	private ThingConverter thingConverter;
	
	public ItemConverter() {
		thingConverter = new ThingConverter();
	}

	@Override
	public Item toEntity(ItemDTO itemDTO) {
		Item item = new Item();
		if (itemDTO != null) {
			item.setId(itemDTO.getId());
			item.setDescription(itemDTO.getDescription());
			item.setType(itemDTO.getType());
			item.setStatus(itemDTO.isStatus());
			item.setThing(thingConverter.toEntity(itemDTO.getThingDTO()));
		}
		return item;
	}

	@Override
	public ItemDTO toDTO(Item item) {
		ItemDTO itemDTO = new ItemDTO();
		if (item != null) {
			itemDTO.setId(item.getId());
			itemDTO.setDescription(item.getDescription());
			itemDTO.setType(item.getType());
			itemDTO.setStatus(item.isStatus());
			itemDTO.setThing(thingConverter.toDTO(itemDTO.getThingDTO()));
		}
		return itemDTO;
	}
}
