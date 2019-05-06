package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ThingDTO;
import it.contrader.model.Thing;

@Component
public class ThingConverter implements Converter<Thing,ThingDTO> {

	@Override
	public Thing toEntity(ThingDTO thingDTO) {
		Thing thing = null;
		if (thingDTO != null) {
			thing = new Thing();
			thing.setId(thingDTO.getId());
			thing.setDescription(thingDTO.getDescription());
		}
		return thing;
	}

	@Override
	public ThingDTO toDTO(Thing thing) {
		ThingDTO thingDTO = null;
		if (thing != null) {
			thingDTO = new ThingDTO();
			thingDTO.setId(thing.getId());
			thingDTO.setDescription(thing.getDescription());
		}
		return thingDTO;
	}
	
	
}