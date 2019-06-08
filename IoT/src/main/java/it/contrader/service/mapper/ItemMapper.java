package it.contrader.service.mapper;

import it.contrader.domain.*;
import it.contrader.service.dto.ItemDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Item and its DTO ItemDTO.
 */
@Mapper(componentModel = "spring", uses = {ThingMapper.class})
public interface ItemMapper extends EntityMapper<ItemDTO, Item> {

    @Mapping(source = "thing.id", target = "thingId")
    ItemDTO toDto(Item item);

    @Mapping(source = "thingId", target = "thing")
    @Mapping(target = "events", ignore = true)
    Item toEntity(ItemDTO itemDTO);

    default Item fromId(Long id) {
        if (id == null) {
            return null;
        }
        Item item = new Item();
        item.setId(id);
        return item;
    }
}
