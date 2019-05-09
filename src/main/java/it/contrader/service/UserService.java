package it.contrader.service;

import org.springframework.stereotype.Service;
import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

@Service
public class UserService extends AbstractService<User,UserDTO> {

	public UserDTO findByUsernameAndPassword(String username, String password) {
		return converter.toDTO(((UserRepository)crudRepository).findByUsernameAndPassword(username, password));
	}
}
