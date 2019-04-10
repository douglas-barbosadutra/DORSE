package it.contrader.dto;
import java.util.List;

import it.contrader.model.Item;
public class AmbienteDTO {
	
		private int id;
		private String descrizione;
		private List<Item> items;
		private int buildingid;

		public AmbienteDTO() {

		}

		public AmbienteDTO(String descrizione, int buildingid) {
			super ();
			this.setDescrizione(descrizione);
			this.setBuildingid(buildingid);

		}
		public AmbienteDTO(int id, String descrizione, int buildingid) {
			super ();
			this.id = id;
			this.descrizione = descrizione;
			this.buildingid = buildingid;

		}
		public int getBuildingid() {
			return buildingid;
		}

		public void setBuildingid(int buildingid) {
			this.buildingid = buildingid;
		}

		public List<Item> getItems() {
			return items;
		}

		public void setItems(List<Item> items) {
			this.items = items;
		}

		public String getDescrizione() {
			return descrizione;
		}

		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	
	
}
