package it.contrader.converter;

import org.mapstruct.Mapper;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;

@Mapper( componentModel="spring" )
public interface ItemMapper extends GenericMapper<Item, ItemDTO> {

}
