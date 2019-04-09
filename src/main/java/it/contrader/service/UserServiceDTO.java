package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.UserConverter;
import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;


public class UserServiceDTO {

	private final UserDAO userDAO;

	public  UserServiceDTO() {
		this.userDAO = new UserDAO();
	}

	public List<UserDTO> getAllUsers() {

		List<User> list = userDAO.getAllUser();
		List<UserDTO> listDTO = new ArrayList<>();

		for (User user : list) {
			listDTO.add(UserConverter.toDTO(user));
		}

		return listDTO;
	}
	
	public UserDTO readUser(int id) {
		return UserConverter.toDTO(userDAO.readUser(id));
	}
	
	
	public UserDTO readUser(String username, String password) {
		return UserConverter.toDTO(userDAO.readUser(username, password));
	}

	public boolean updateUser (UserDTO userDTO) {
		return this.userDAO.updateUser(UserConverter.toEntityNoId(userDTO));
		
}
	
	public boolean deleteUser (int id) {
		return this.userDAO.deleteUser(id);
		
}
	
	public boolean insertUser (UserDTO userDTO) {
		return this.userDAO.insertUser(UserConverter.toEntityNoId(userDTO));
	
}
		
	
	
}
