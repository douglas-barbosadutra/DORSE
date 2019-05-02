package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import it.contrader.converter.ItemConverter;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;

@Service
public class ItemService extends AbstractService<Item,ItemDTO> {
	
	@Autowired
	public ItemService(CrudRepository<Item,Long> crudRepository) {
		this.crudRepository = crudRepository;
		converter = new ItemConverter();
	}
}
