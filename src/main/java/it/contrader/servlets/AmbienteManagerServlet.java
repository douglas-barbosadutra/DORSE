package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.AmbienteDTO;
import it.contrader.service.AmbienteServiceDTO;


public class AmbienteManagerServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AmbienteManagerServlet() {
		super();

	}
	
	@Override
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AmbienteServiceDTO ambienteService = new AmbienteServiceDTO();
		String mode = request.getParameter("mode");
		
		List<AmbienteDTO> listDTO;
		boolean ans;
		int id;
		int building;
		String descrizione;
		
		switch (mode.toUpperCase()) {

		case "AMBIENTELISTBY":
			id = Integer.parseInt(request.getParameter("id"));
			listDTO = ambienteService.getAllBy(id);
			request.setAttribute("ambientelist", listDTO);
			request.setAttribute("building", id);
			getServletContext().getRequestDispatcher("/ambiente/ambientemanager.jsp").forward(request, response);
			break;

		case "BUILDINGLISTOP":
			listDTO = ambienteService.getAll();
			request.setAttribute("buildinglistOP", listDTO);
			request.setAttribute("view", "buildings");
			getServletContext().getRequestDispatcher("/homeoperatore.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			AmbienteDTO ambienteToRead = ambienteService.read(id);
			ambienteToRead.toString();
			request.setAttribute("ambienteToRead", ambienteToRead);
			getServletContext().getRequestDispatcher("/ambiente/readambiente.jsp").forward(request, response);
			break;

		case "INSERT":
			descrizione= request.getParameter("descrizione");
			building = (Integer) request.getAttribute("buildingid");
			AmbienteDTO ambienteToInsert = new AmbienteDTO (descrizione,building);
			ans = ambienteService.insert(ambienteToInsert);
			request.setAttribute("ans", ans);
			request.setAttribute("mode", "insert");
			listDTO = ambienteService.getAllBy(building);
			request.setAttribute("ambientelist", listDTO);
			getServletContext().getRequestDispatcher("/ambiente/ambientemanager.jsp").forward(request, response);
			break;

		case "PREUPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			AmbienteDTO ambiente = ambienteService.read(id);
			ambiente.setId(id);
			request.setAttribute("ambiente", ambiente);
			getServletContext().getRequestDispatcher("/ambiente/updateambiente.jsp").forward(request, response);
			break;

		case "UPDATE":
			descrizione = request.getParameter("descrizione");
			building = Integer.parseInt(request.getParameter("building"));
			id = Integer.parseInt(request.getParameter("id"));
			AmbienteDTO buildingToUpdate = new AmbienteDTO(id,descrizione, building);
			ans = ambienteService.update(buildingToUpdate);
			request.setAttribute("ans", ans);
			request.setAttribute("mode", "update");
			listDTO = ambienteService.getAllBy(building);
			request.setAttribute("ambientelist", listDTO);
			getServletContext().getRequestDispatcher("/ambiente/ambientemanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			AmbienteDTO dto = ambienteService.read(id);
			building= dto.getBuildingid();
			ans = ambienteService.delete(dto);
			request.setAttribute("ans", ans);
			listDTO = ambienteService.getAllBy(building);
			request.setAttribute("ambientelist", listDTO);
			request.setAttribute("mode", "delete");
			getServletContext().getRequestDispatcher("/ambiente/ambientemanager.jsp").forward(request, response);
			break;
		}
	}


}
