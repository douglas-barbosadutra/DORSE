package it.contrader.service;

import java.util.List;
import org.springframework.stereotype.Service;
import it.contrader.dao.ItemRepository;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;
import it.contrader.model.Thing;

@Service
public class ItemService extends AbstractService<Item,ItemDTO> {
	
	@Override
	public List<ItemDTO> getAllBy(Object o) {
		return converter.toDTOList(((ItemRepository)crudRepository).findByThing_id(((Thing)o).getId()));
	}
}
