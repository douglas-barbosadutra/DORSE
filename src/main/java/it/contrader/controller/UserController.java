package it.contrader.controller;

import java.util.List;


import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.service.UserService;

public class UserController implements Controller {

	
	private static String sub_package = "user.";
	private UserService userService;

	public UserController() {
		this.userService = new UserService();
	}

	public List<User> getAllUser() {
		return this.userService.getAllUser();
	}

	public boolean deleteUser(Integer usersId) {
		return this.userService.deleteUser(usersId);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		int id;
		String username;
		String password;
		String usertype;
		
		switch (mode) {
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			User user = userService.readUser(id);
			request.put("user", user);
			MainDispatcher.getInstance().callView(sub_package + "UserRead", request);
			break;
		case "INSERT":
			username = request.get("username").toString();
	        password = request.get("password").toString();
	        usertype = request.get("usertype").toString();
			userService.insertUser(username, password, usertype);
			break;
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			userService.deleteUser(id);
			break;
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			username = request.get("username").toString();
	        password = request.get("password").toString();
	        usertype = request.get("usertype").toString();
			userService.updateUser(id, username, password, usertype);
			break;
		case "USERLIST":
			//MainDispatcher.getInstance().callView("User", null);
			List<User> users = userService.getUserList();
			request.put("users", users);
			MainDispatcher.getInstance().callView("User", request);
			break;
		case "GETCHOICE":
			System.out.println("ok");
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "UserRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "UserInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "UserUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "UserDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
