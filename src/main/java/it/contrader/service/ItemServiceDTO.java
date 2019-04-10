package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.BuildingConverter;
import it.contrader.converter.ItemConverter;
import it.contrader.dao.BuildingDAO;
import it.contrader.dao.ItemDAO;
import it.contrader.dto.BuildingDTO;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Ambiente;
import it.contrader.model.Building;
import it.contrader.model.Item;

public class ItemServiceDTO extends AbstractServiceDTO<Item,ItemDTO> {
	
	public ItemServiceDTO() {
		dao = new ItemDAO();
		converter = new ItemConverter();
	}
}
