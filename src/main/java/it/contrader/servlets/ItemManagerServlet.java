package it.contrader.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.ItemDTO;
import it.contrader.service.ItemServiceDTO;
import it.contrader.service.ServiceDTO;

public class ItemManagerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int ambienteId;
	private HttpSession session;

	public ItemManagerServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		session.getAttribute("ambienteId" );
		ServiceDTO<ItemDTO> service = new ItemServiceDTO();
		List<ItemDTO>listDTO = service.getAllBy(ambienteId);
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceDTO<ItemDTO> service = new ItemServiceDTO();
	    String mode = request.getParameter("mode");
	    
	    if(request.getParameter("ambienteId")!=null) {
	    	ambienteId = Integer.parseInt(request.getParameter("ambienteId").toString());
	    }
	    
		ItemDTO dto;
		int id;
		boolean ans;
		String description, itemType;
		
		session = request.getSession();
		session.setAttribute("ambienteId",ambienteId);
		
		switch (mode.toUpperCase()) {

		case "ITEMLISTBY":
			updateList(request);
			getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
			break;

		case "ITEMLISTOP":
			updateList(request);
			getServletContext().getRequestDispatcher("/homeoperatore.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/item/readItem.jsp").forward(request, response);
			break;

		case "INSERT":
			description= request.getParameter("description");
			itemType= request.getParameter("itemtype");
			int ambientId = Integer.parseInt(request.getParameter("ambientId"));
			dto = new ItemDTO (description, itemType, ambientId);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
			break;

		case "PREUPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			dto.setId(id);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/item/updateItem.jsp").forward(request, response);
			break;

		case "UPDATE":
			description = request.getParameter("descrizione");
			id = Integer.parseInt(request.getParameter("id"));
			itemType= request.getParameter("itemtype");
			ambientId = Integer.parseInt(request.getParameter("ambientId"));
			dto = new ItemDTO(id, description, itemType, ambientId);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			ans = service.delete(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
			break;
		}
	}


}
