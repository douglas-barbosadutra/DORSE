package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.UserDTO;

import it.contrader.model.User;

@Component
public class UserConverter extends AbstractConverter<User,UserDTO> {

}