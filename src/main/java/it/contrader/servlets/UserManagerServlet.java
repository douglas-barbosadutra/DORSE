package it.contrader.servlets;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.contrader.dto.UserDTO;
import it.contrader.service.UserServiceDTO;

public class UserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mode;



	public UserManagerServlet() {
		super();

	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceDTO userService = new UserServiceDTO();
		String mode = request.getParameter("mode");
		switch (mode.toUpperCase()) {

		case "USERLIST":

			List<UserDTO> listDTO = userService.getAllUsers();
			request.setAttribute("userlist", listDTO);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;


		case "READ":

			int id = Integer.parseInt(request.getParameter("id"));
			UserDTO userToRead= userService.readUser(id);
			request.setAttribute("userToRead", userToRead);
			getServletContext().getRequestDispatcher("/user/readuser.jsp").forward(request, response);
			break;
		}
	}
}
