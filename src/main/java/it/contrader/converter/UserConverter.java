package it.contrader.converter;

import it.contrader.dto.UserDTO;
import it.contrader.model.User;

public class UserConverter implements Converter<User,UserDTO> {

	@Override
	public User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			user = new User( userDTO.getUsername(), userDTO.getPassword(), userDTO.getUsertype());
			Integer id = userDTO.getId();
			if(id != null) {
				user.setId(id);
			}

			
		}
		
		return user;
	}

	@Override
	public UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO( user.getId(),user.getUsername(), user.getPassword(), user.getUsertype());
		}
		return userDTO;
	}
}
