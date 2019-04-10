package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.BuildingDTO;
import it.contrader.service.BuildingServiceDTO;

/**
 * Servlet implementation class BuildingManagerServlet
 */
public class BuildingManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildingManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    BuildingServiceDTO buildingService = new BuildingServiceDTO();
	    List<BuildingDTO> listDTO = buildingService.getAllBuildings();
	    request.setAttribute("buildinglist", listDTO);
	    getServletContext().getRequestDispatcher("/building/buildingmanager.jsp").forward(request, response);
   }
}
