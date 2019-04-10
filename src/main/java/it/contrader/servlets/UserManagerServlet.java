package it.contrader.servlets;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.UserDTO;
import it.contrader.service.ServiceDTO;
import it.contrader.service.UserServiceDTO;

public class UserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	public UserManagerServlet() {
		super();

	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceDTO<UserDTO> userService = new UserServiceDTO();
		String mode = request.getParameter("mode");
		int id;
		List<UserDTO> listDTO;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "USERLIST":

			listDTO = userService.getAll();
			request.setAttribute("userlist", listDTO);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "READ":

			id = Integer.parseInt(request.getParameter("id"));
			UserDTO userToRead= userService.read(id);
			request.setAttribute("userToRead", userToRead);
			getServletContext().getRequestDispatcher("/user/readuser.jsp").forward(request, response);
			break;

		case "INSERT":
			String username = request.getParameter("username").toString();
			String password = request.getParameter("password").toString();
			String usertype = request.getParameter("usertype").toString();
			UserDTO userToInsert = new UserDTO (username,password,usertype);

			ans = userService.insert(userToInsert);
			request.setAttribute("ans", ans);
			request.setAttribute("mode", "insert");
			listDTO = userService.getAll();
			request.setAttribute("userlist", listDTO);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "READTOUPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			UserDTO userReadToUpdate= userService.read(id);
			request.setAttribute("userReadToUpdate", userReadToUpdate);
			getServletContext().getRequestDispatcher("/user/updateuser.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			username = request.getParameter("username");
			password = request.getParameter("password");
			usertype = request.getParameter("usertype");
			id = Integer.parseInt(request.getParameter("id"));
			UserDTO userToUpdate = new UserDTO (id,username, password, usertype);
			ans = userService.update(userToUpdate);
			request.setAttribute("ans", ans);
			listDTO = userService.getAll();
			request.setAttribute("userlist", listDTO);
			request.setAttribute("mode", "update");
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;


		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			UserDTO dto = userService.read(id);
			ans = userService.delete(dto);
			request.setAttribute("ans", ans);
			listDTO = userService.getAll();
			request.setAttribute("userlist", listDTO);
			request.setAttribute("mode", "delete");
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;
		}
	}
}
