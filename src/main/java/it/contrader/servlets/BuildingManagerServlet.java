package it.contrader.servlets;

import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.BuildingDTO;
import it.contrader.dto.DTO;
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
	    List<UserDTO> operatorList = userService.getAllBy("operatore");
	    
	    request.setAttribute("operatorList", operatorList);
	    
	    String mode = request.getParameter("mode");
		BuildingDTO dto;
		int id, userId, operatorId;
		boolean ans;
		
		switch (mode.toUpperCase()) {

		case "BUILDINGLIST":
			request.setAttribute("operatorList", operatorList);
			
			updateList(request);
			getServletContext().getRequestDispatcher("/building/buildingmanager.jsp").forward(request, response);
			break;
			    
		case "BUILDINGLISTOP":
			request.setAttribute("operatorList", operatorList);
			
			updateList(request);
			request.setAttribute("view", "buildings");
			getServletContext().getRequestDispatcher("/homeoperatore.jsp").forward(request, response);
		    break;
		    
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/building/readbuilding.jsp").forward(request, response);
			break;

		case "INSERT":
			request.setAttribute("operatorList", operatorList);
			
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
			
			request.setAttribute("operatorList", operatorList);
			
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/building/updatebuilding.jsp").forward(request, response);
			break;

		case "UPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			indirizzo = request.getParameter("indirizzo");
			userId = Integer.parseInt(request.getParameter("userId"));
			operatorId = Integer.parseInt(request.getParameter("operatorId"));
			dto = new BuildingDTO(id, indirizzo, userId, operatorId);
			ans = service.update(dto);
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