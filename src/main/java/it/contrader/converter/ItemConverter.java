package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;

@Component
public class ItemConverter extends AbstractConverter<Item, ItemDTO> {
	
	@Autowired
	private ThingConverter thingConverter;
	
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
			itemDTO.setThingDTO(thingConverter.toDTO(item.getThing()));
		}
		return itemDTO;
	}
}
