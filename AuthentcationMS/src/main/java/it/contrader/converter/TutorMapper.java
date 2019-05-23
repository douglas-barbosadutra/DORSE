package it.contrader.converter;

import org.mapstruct.Mapper;

import it.contrader.dto.TutorDTO;
import it.contrader.model.Tutor;

@Mapper( componentModel="spring" )
public interface TutorMapper extends GenericMapper<Tutor,TutorDTO> {

}