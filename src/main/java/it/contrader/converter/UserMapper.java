package it.contrader.converter;

import org.mapstruct.Mapper;

import it.contrader.dto.UserDTO;

import it.contrader.model.User;

@Mapper( componentModel="spring" )
public interface UserMapper extends GenericMapper<User,UserDTO> {

}