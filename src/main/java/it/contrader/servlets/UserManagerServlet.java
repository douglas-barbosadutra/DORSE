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

/**
 * Servlet implementation class UserManagerServlet
 */
public class UserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mode;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManagerServlet() {
        super();
       
    }

    @Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    UserServiceDTO userService = new UserServiceDTO();
	    List<UserDTO> listDTO = userService.getAllUsers();
	    request.setAttribute("userlist", listDTO);
	    getServletContext().getRequestDispatcher("/usermanager.jsp").forward(request, response);
   }
}
