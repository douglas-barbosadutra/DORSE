package it.contrader.service;

import java.util.List;
import org.springframework.stereotype.Service;
import it.contrader.dao.ItemRepository;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;

@Service
public class ItemService extends AbstractService<Item,ItemDTO> {
	
	public List<ItemDTO> findAllBything_id(long id) {
		return converter.toDTOList(((ItemRepository) crudRepository).findByThing_id(id));
	}
}
