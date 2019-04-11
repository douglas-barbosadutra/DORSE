package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.AmbienteDTO;
import it.contrader.dto.BuildingDTO;
import it.contrader.dto.DTO;
import it.contrader.dto.ItemDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.AmbienteServiceDTO;
import it.contrader.service.BuildingServiceDTO;
import it.contrader.service.ItemServiceDTO;
import it.contrader.service.ServiceDTO;
import it.contrader.service.UserServiceDTO;


public class AmbienteManagerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public AmbienteManagerServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		int buildingId = Integer.parseInt(request.getParameter("id"));
		ServiceDTO<UserDTO> service = new UserServiceDTO();
		List<UserDTO>listDTO = service.getAllBy(buildingId);
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceDTO<AmbienteDTO> service = new AmbienteServiceDTO();
	    String mode = request.getParameter("mode");
		AmbienteDTO dto;
		int id, buildingId;
		boolean ans;
		
		switch (mode.toUpperCase()) {

		case "AMBIENTELISTBY":
			updateList(request);
			getServletContext().getRequestDispatcher("/ambiente/ambientemanager.jsp").forward(request, response);
			break;

		case "BUILDINGLISTOP":
			updateList(request);
			getServletContext().getRequestDispatcher("/homeoperatore.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/ambiente/readambiente.jsp").forward(request, response);
			break;

		case "INSERT":
			String descrizione= request.getParameter("descrizione");
			buildingId = Integer.parseInt(request.getParameter("buildingid"));
			dto = new AmbienteDTO (descrizione, buildingId);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/ambiente/ambientemanager.jsp").forward(request, response);
			break;

		case "PREUPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			dto.setId(id);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/ambiente/updateambiente.jsp").forward(request, response);
			break;

		case "UPDATE":
			descrizione = request.getParameter("descrizione");
			buildingId = Integer.parseInt(request.getParameter("buildingId"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new AmbienteDTO(id, descrizione, buildingId);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/ambiente/ambientemanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			ans = service.delete(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/ambiente/ambientemanager.jsp").forward(request, response);
			break;
		}
	}


}
