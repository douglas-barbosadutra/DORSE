package it.contrader.controller;

import it.contrader.main.MainDispatcher;
import it.contrader.service.LoginService;

public class HomeController implements Controller {

	private LoginService loginService;

	public HomeController() {
		loginService = new LoginService();
	}

	public void doControl(Request request) {
		if (request != null) {
			String username = request.get("username").toString();
			String password = request.get("password").toString();


			//Change view according userType
			String userType= loginService.login(username, password);
			if(userType==null)
				MainDispatcher.getInstance().callAction("Login", "doControl", request);

			if (userType.equals("admin"))
				MainDispatcher.getInstance().callView("HomeAdmin", request);

			if (userType.equals("operatore"))
				MainDispatcher.getInstance().callView("HomeOperatore", request);

		}
		else MainDispatcher.getInstance().callView("Login", null);

	}
}
