package it.contrader.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import it.contrader.converter.ItemConverter;
import it.contrader.dao.ItemRepository;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;

@Service
public class ItemService extends AbstractService<Item,ItemDTO> {
	
	private ItemConverter itemConverter = new ItemConverter();

	@Autowired
	public ItemService(CrudRepository<Item,Long> crudRepository) {
		this.crudRepository = crudRepository;
		converter = new ItemConverter();
	}
	
	public List<ItemDTO> findAllBything_id(long id) {
		return itemConverter.toDTOList(((ItemRepository) crudRepository).findByThing_id(id));
	}
}
