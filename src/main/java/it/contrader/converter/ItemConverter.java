package it.contrader.converter;

import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;

public class ItemConverter implements Converter<Item,ItemDTO> {

	public Item toEntity(ItemDTO itemDTO) {

		Item item = null;
		if (itemDTO != null) {
			item = new Item(itemDTO.getId(), itemDTO.getDescription(), itemDTO.getItemType());
		}

		return item;
	}

	public ItemDTO toDTO(Item item) {

		ItemDTO itemDTO = null;
		if (item != null) {
			itemDTO = new ItemDTO(item.getId(), item.getDescription(), item.getItemType());
		}

		return itemDTO;
	}
}
