package it.contrader.servlets;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.DTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.ServiceDTO;
import it.contrader.service.UserServiceDTO;

public class UserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserManagerServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		ServiceDTO<UserDTO> service = new UserServiceDTO();
		List<UserDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceDTO<UserDTO> service = new UserServiceDTO();
		String mode = request.getParameter("mode");
		UserDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "USERLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/user/readuser.jsp").forward(request, response);
			break;

		case "INSERT":
			String username = request.getParameter("username").toString();
			String password = request.getParameter("password").toString();
			String usertype = request.getParameter("usertype").toString();
			dto = new UserDTO (username,password,usertype);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "READTOUPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/user/updateuser.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			username = request.getParameter("username");
			password = request.getParameter("password");
			usertype = request.getParameter("usertype");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new UserDTO (id,username, password, usertype);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			ans = service.delete(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;
		}
	}
}