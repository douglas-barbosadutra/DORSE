package it.contrader.service;

import java.util.*;


import it.contrader.dao.UserDAO;

import it.contrader.model.User;

public class UserService {

	private UserDAO userDAO;

	public UserService() {
		this.userDAO = new UserDAO();
	}

	public List<User> getAllUser() {
		return this.userDAO.getAllUser();
	}


	
	public boolean deleteUser(int userId) {
		return this.userDAO.deleteUser(userId);
	}

	public boolean updateUser(User user, int idtoupdate) {
		return this.userDAO.updateUser(user,idtoupdate);
	}
	
	
}
