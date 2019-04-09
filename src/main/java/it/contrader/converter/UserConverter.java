package it.contrader.converter;

import it.contrader.dto.UserDTO;
import it.contrader.model.User;


/**
 * Il converter si occupa di "convertire" un model in un dto e viceversa
 *
 */
public class UserConverter {


	/**
	 * Converte un NodesDTO in Nodes
	 */
	public static User toEntity(UserDTO userDTO) {

		User user = null;
		if (userDTO != null) {
			user = new User(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword(), userDTO.getUsertype());
		}

		return user;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */
	public static UserDTO toDTO(User user) {

		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO(user.getUserId(), user.getUsername(), user.getPassword(), user.getUsertype());
		}

		return userDTO;
	}
	

}
