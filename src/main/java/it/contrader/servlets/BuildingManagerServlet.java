package it.contrader.servlets;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.BuildingDTO;
import it.contrader.service.BuildingServiceDTO;


public class BuildingManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BuildingManagerServlet() {
        super();
       

    }

    @Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    BuildingServiceDTO buildingService = new BuildingServiceDTO();
		String mode = request.getParameter("mode");
		int id;
		List<BuildingDTO> listDTO;
		boolean ans;

		int user;
		switch (mode.toUpperCase()) {

		case "BUILDINGLIST":
				listDTO = buildingService.getAllBuildings();
			    request.setAttribute("buildinglist", listDTO);
			    getServletContext().getRequestDispatcher("/building/buildingmanager.jsp").forward(request, response);
			    break;

		case "READ":

			id = Integer.parseInt(request.getParameter("id"));
			BuildingDTO buildingToRead= buildingService.readBuilding(id);
			request.setAttribute("buildingToRead", buildingToRead);
			getServletContext().getRequestDispatcher("/building/readbuilding.jsp").forward(request, response);
			break;

		case "INSERT":
			String indirizzo = request.getParameter("indirizzo").toString();
			user = Integer.parseInt(request.getParameter("user").toString());
			BuildingDTO buildingToInsert = new BuildingDTO (indirizzo,user);
			ans = buildingService.insertBuilding(buildingToInsert);
			request.setAttribute("ans", ans);
			request.setAttribute("mode", "insert");
			listDTO = buildingService.getAllBuildings();
			request.setAttribute("buildinglist", listDTO);
			getServletContext().getRequestDispatcher("/building/buildingmanager.jsp").forward(request, response);
			break;

		case "PREUPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			BuildingDTO building = buildingService.readBuilding(id);
			building.setId(id);
			request.setAttribute("building", building);
			getServletContext().getRequestDispatcher("/building/updatebuilding.jsp").forward(request, response);
			break;

		case "UPDATE":
			indirizzo = request.getParameter("indirizzo");
			user = Integer.parseInt(request.getParameter("user"));
			id = Integer.parseInt(request.getParameter("id"));
			BuildingDTO buildingToUpdate = new BuildingDTO(id,indirizzo, user);
			ans = buildingService.updateBuilding(buildingToUpdate);
			listDTO = buildingService.getAllBuildings();
			request.setAttribute("mode", "update");
			request.setAttribute("ans", ans);
			listDTO = buildingService.getAllBuildings();
			request.setAttribute("buildinglist", listDTO);
			getServletContext().getRequestDispatcher("/building/buildingmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = buildingService.deleteBuilding(id);
			request.setAttribute("ans", ans);
			listDTO = buildingService.getAllBuildings();
			request.setAttribute("buildinglist", listDTO);
			request.setAttribute("mode", "delete");
			getServletContext().getRequestDispatcher("/building/buildingmanager.jsp").forward(request, response);
			break;
		}
   }
}