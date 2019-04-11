package it.contrader.service;

import it.contrader.converter.ItemConverter;
import it.contrader.dao.ItemDAO;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;

public class ItemServiceDTO extends AbstractServiceDTO<Item,ItemDTO> {
	
	public ItemServiceDTO() {
		dao = new ItemDAO();
		converter = new ItemConverter();
	}
}
