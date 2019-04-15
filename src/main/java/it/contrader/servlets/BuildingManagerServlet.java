package it.contrader.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.BuildingDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.BuildingServiceDTO;
import it.contrader.service.ServiceDTO;
import it.contrader.service.UserServiceDTO;

public class BuildingManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BuildingManagerServlet() {
    }
    
    public void updateList(HttpServletRequest request) {
		ServiceDTO<BuildingDTO> service = new BuildingServiceDTO();
		List<BuildingDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

    @Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ServiceDTO<BuildingDTO> service = new BuildingServiceDTO();
	    ServiceDTO<UserDTO> userService = new UserServiceDTO();
	    List<UserDTO> clientList = userService.getAllBy("client");
	    List<UserDTO> operatorList = userService.getAllBy("operatore");
	    
	    request.setAttribute("operatorList", operatorList);
	    request.setAttribute("clientList", clientList);
	    
	    String mode = request.getParameter("mode");
		BuildingDTO dto;
		int id, userId, operatorId;
		boolean ans;
		
		switch (mode.toUpperCase()) {

		case "BUILDINGLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/building/buildingmanager.jsp").forward(request, response);
			break;
			    
		case "BUILDINGLISTOP":
			updateList(request);
			getServletContext().getRequestDispatcher("/building/buildingmanagerop.jsp").forward(request, response);
		    break;
		    
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/building/readbuilding.jsp").forward(request, response);
			break;

		case "INSERT":
			String indirizzo = request.getParameter("indirizzo");
			userId = Integer.parseInt(request.getParameter("userId"));
			operatorId = Integer.parseInt(request.getParameter("operatorId"));
			dto = new BuildingDTO (indirizzo,userId,operatorId);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/building/buildingmanager.jsp").forward(request, response);
			break;

		case "PREUPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			dto.setId(id);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/building/updatebuilding.jsp").forward(request, response);
			break;

		case "UPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			indirizzo = request.getParameter("indirizzo");
			int clientId = Integer.parseInt(request.getParameter("clientId"));
			operatorId = Integer.parseInt(request.getParameter("operatorId"));
			dto = new BuildingDTO(id, indirizzo, clientId, operatorId);
			ans = service.update(dto);
			System.out.println(ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/building/buildingmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			ans = service.delete(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/building/buildingmanager.jsp").forward(request, response);
			break;
		}
   }
}