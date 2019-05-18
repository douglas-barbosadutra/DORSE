package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ThingDTO;
import it.contrader.model.Thing;

@Component
public class ThingConverter extends AbstractConverter<Thing,ThingDTO> {

}