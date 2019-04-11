package it.contrader.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.AmbienteDTO;
import it.contrader.dto.ItemDTO;
import it.contrader.service.AmbienteServiceDTO;
import it.contrader.service.ItemServiceDTO;
import it.contrader.service.ServiceDTO;

public class AmbienteManagerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int buildingId;
	private HttpSession session;

	public AmbienteManagerServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		session.getAttribute("buildingId" );
		ServiceDTO<AmbienteDTO> service = new AmbienteServiceDTO();
		List<AmbienteDTO>listDTO = service.getAllBy(buildingId);
		request.setAttribute("list", listDTO);
	
	}
	
	@Override
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceDTO<AmbienteDTO> service = new AmbienteServiceDTO();
	    String mode = request.getParameter("mode");
	    
	    if(request.getParameter("buildingId")!=null) {
	    buildingId = Integer.parseInt(request.getParameter("buildingId").toString());
	    }
	    
		AmbienteDTO dto;
		int id;
		boolean ans;
		
		session = request.getSession();
		session.setAttribute("buildingId",buildingId);
		
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
				
			ServiceDTO<ItemDTO> itemservice = new ItemServiceDTO();
			List<ItemDTO>listDTO = itemservice.getAllBy(id);
			request.setAttribute("list", listDTO);
			
			session.setAttribute("ambientId",id);
			
			dto = service.read(id);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/ambiente/readambiente.jsp").forward(request, response);
			break;

		case "INSERT":
			String descrizione= request.getParameter("descrizione");
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
