package it.contrader.converter;

import it.contrader.dto.UserDTO;

import it.contrader.model.User;

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
			user.setSurname(userDTO.getSurname());
			user.setAddress(userDTO.getAddress());
			user.setBirthdate(userDTO.getBirthdate());
			user.setCcc(userDTO.getCcc());
			user.setEmail(userDTO.getEmail());
			user.setTelnumber(userDTO.getTelnumber());
			user.setPaymentStatus(userDTO.isPaymentStatus());
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
			userDTO.setSurname(user.getSurname());
			userDTO.setAddress(user.getAddress());
			userDTO.setBirthdate(user.getBirthdate());
			userDTO.setCcc(user.getCcc());
			userDTO.setEmail(user.getEmail());
			userDTO.setTelnumber(user.getTelnumber());
			userDTO.setPaymentStatus(user.isPaymentStatus());
		}
		return userDTO;
	}
}