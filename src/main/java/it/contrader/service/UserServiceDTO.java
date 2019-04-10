package it.contrader.service;

import it.contrader.converter.UserConverter;
import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

public class UserServiceDTO extends AbstractServiceDTO<User,UserDTO> {
	
	public UserServiceDTO() {
		dao = new UserDAO();
		converter = new UserConverter();
	}
}
