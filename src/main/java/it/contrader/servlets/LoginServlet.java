package it.contrader.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.DTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.ServiceDTO;
import it.contrader.service.UserServiceDTO;

public class LoginServlet extends HttpServlet {

	private final ServiceDTO<UserDTO> userServiceDTO = new UserServiceDTO();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final HttpSession session = request.getSession();
		session.setAttribute("utente", null);

		if (request != null) {
			final String username = request.getParameter("username").toString();
			final String password = request.getParameter("password").toString();
			// recuperiamo l'utente
			final UserDTO userDTO = userServiceDTO.read(username, password);

			if (userDTO != null)
				session.setAttribute("utente", userDTO);

			// verifichiamo che tipo di ruolo ha all'interno dell'applicazione
			// e lo reindirizziamo nella jsp opportuna
			
			switch (userDTO.getUsertype().toUpperCase()) {
			case "ADMIN":
				getServletContext().getRequestDispatcher("/homeadmin.jsp").forward(request, response);
				break;
			case "OPERATORE":
				getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
				break;
			default:
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			}
		}
	}

}
