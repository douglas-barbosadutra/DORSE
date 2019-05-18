package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ApartmentDTO;
import it.contrader.model.Apartment;

@Component
public class ApartmentConverter extends AbstractConverter<Apartment, ApartmentDTO> {

}
