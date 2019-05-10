package it.contrader.service;

import java.util.List;

import org.springframework.stereotype.Service;
import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

@Service
public class UserService extends AbstractService<User,UserDTO> {
	
	@Override
	public List<UserDTO> getAllBy(Object o) {
		return null;
	}

	public UserDTO findByUsernameAndPassword(String username, String password) {
		return converter.toDTO(((UserRepository)crudRepository).findByUsernameAndPassword(username, password));
	}
}
