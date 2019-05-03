package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.UserDTO;
import it.contrader.model.User;

@Component
public class ConverterUser extends AbstractConverter<User,UserDTO>{

	@Override
	public UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			userDTO.setEmail(user.getEmail());
			userDTO.setType(user.getType());
		}
		return userDTO;
	}

	@Override
	public User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			user = new User();
			user.setId(userDTO.getId());
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			user.setEmail(userDTO.getEmail());
			user.setType(userDTO.getType());
		}
		return user;
	}
}
