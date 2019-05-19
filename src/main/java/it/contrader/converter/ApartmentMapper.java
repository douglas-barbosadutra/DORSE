package it.contrader.converter;

import org.mapstruct.Mapper;

import it.contrader.dto.ApartmentDTO;
import it.contrader.model.Apartment;

@Mapper( componentModel="spring" )
public interface ApartmentMapper extends GenericMapper<Apartment, ApartmentDTO> {

}
