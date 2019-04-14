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
	private int ambientId;
	private HttpSession session;
	private int id;
	public ItemManagerServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		session.getAttribute("ambientId" );
		ServiceDTO<ItemDTO> service = new ItemServiceDTO();
		List<ItemDTO> listDTO = service.getAllBy(ambientId);
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceDTO<ItemDTO> service = new ItemServiceDTO();
	    
	    if(request.getParameter("ambientId")!=null) {
	    	ambientId = Integer.parseInt(request.getParameter("ambientId").toString());
	    }

		if(request.getParameter("id")!=null) {
			id = Integer.parseInt(request.getParameter("id"));
	    }
		
		ItemDTO dto;
		boolean ans;
		String description, itemType;
		
		
	    String mode = request.getParameter("mode");
		
		session = request.getSession();
		session.setAttribute("ambientId",ambientId);
		
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
			dto = service.read(id);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/item/readitem.jsp").forward(request, response);
			break;

		case "INSERT":
			description= request.getParameter("description");
			itemType= request.getParameter("itemType");
			int ambientId = Integer.parseInt(request.getParameter("ambientId"));
			dto = new ItemDTO (description, itemType, ambientId);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
			break;

		case "PREUPDATE":
			dto = service.read(id);;
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/item/updateitem.jsp").forward(request, response);
			break;

		case "UPDATE":
			description = request.getParameter("description");
			itemType= request.getParameter("itemType");
			ambientId = Integer.parseInt(request.getParameter("ambientId"));
			int idToUpdate = Integer.parseInt(request.getParameter("idToUpdate"));
			dto = new ItemDTO(idToUpdate,description, itemType, ambientId);
			ans = service.update(dto);
			request.setAttribute("ans", ans);
			System.out.println(ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			dto = service.read(id);
			ans = service.delete(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
			break;
		}
	}


}
