package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;

@Component
public class ItemConverter extends AbstractConverter<Item, ItemDTO> {

}
