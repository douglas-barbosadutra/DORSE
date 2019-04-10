package it.contrader.converter;

import it.contrader.dto.UserDTO;
import it.contrader.model.User;

public class UserConverter implements Converter<User,UserDTO> {

	@Override
	public User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			user = new User(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword(), userDTO.getUsertype());
		}
		return user;
	}

	@Override
	public UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO(user.getUserId(), user.getUsername(), user.getPassword(), user.getUsertype());
		}
		return userDTO;
	}
}
