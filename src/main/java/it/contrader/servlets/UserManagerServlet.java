package it.contrader.servlets;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		int id;
		List<UserDTO> listDTO;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "USERLIST":

			listDTO = userService.getAllUsers();
			request.setAttribute("userlist", listDTO);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "READ":

			id = Integer.parseInt(request.getParameter("id"));
			UserDTO userToRead= userService.readUser(id);
			request.setAttribute("userToRead", userToRead);
			getServletContext().getRequestDispatcher("/user/readuser.jsp").forward(request, response);
			break;

		case "INSERT":
			String username = request.getParameter("username").toString();
			String password = request.getParameter("password").toString();
			String usertype = request.getParameter("usertype").toString();
			UserDTO userToInsert = new UserDTO (username,password,usertype);

			ans = userService.insertUser(userToInsert);
			request.setAttribute("ans", ans);
			request.setAttribute("mode", "insert");
			listDTO = userService.getAllUsers();
			request.setAttribute("userlist", listDTO);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "UPDATE":


			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = userService.deleteUser(id);
			request.setAttribute("ans", ans);
			listDTO = userService.getAllUsers();
			request.setAttribute("userlist", listDTO);
			request.setAttribute("mode", "delete");
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;
		}
	}
}
