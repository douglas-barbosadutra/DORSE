package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import it.contrader.converter.UserConverter;
import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

@Service
public class UserService extends AbstractService<User,UserDTO> {
	
	@Autowired
	public UserService(CrudRepository<User,Long> crudRepository) {
		this.crudRepository = crudRepository;
		converter = new UserConverter();
	}
	
	public UserDTO findByUsernameAndPassword(String username, String password) {
		return converter.toDTO(((UserRepository)crudRepository).findByUsernameAndPassword(username, password));
	}
}
