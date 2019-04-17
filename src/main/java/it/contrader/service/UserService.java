package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.UserConverter;
import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

@Service
public class UserService extends AbstractService<User,UserDTO> {
	
	UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		converter = new UserConverter();
	}
	
	public UserDTO findByUsernameAndPassword(String username, String password) {
		//return converter.toDTO(userRepository.findByUsernameAndPassword(username, password));
		User u = userRepository.findByUsernameAndPassword(username, password);
		UserDTO uu = converter.toDTO(u);
		return uu;
	}
}
