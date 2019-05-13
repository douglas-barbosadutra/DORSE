package it.contrader.service;

import java.util.List;

import org.springframework.stereotype.Service;
import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

@Service
public class UserService extends AbstractService<User,UserDTO> {

	public UserDTO findByUsernameAndPassword(String username, String password) {
		return converter.toDTO(((UserRepository)myRepository).findByUsernameAndPassword(username, password));
	}
}
