package it.contrader.converter;

import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import it.contrader.model.User.UserType;

public class UserConverter implements Converter<User,UserDTO> {

	@Override
	public User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			user = new User();
			user.setId(userDTO.getId());
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			user.setUserType(userDTO.getUserType());
			user.setName(userDTO.getName());
		}
		return user;
	}

	@Override
	public UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			userDTO.setUserType(user.getUserType());
			userDTO.setName(user.getName());
		}
		return userDTO;
	}
}