package it.contrader.dto;

public class BuildingDTO implements DTO {

	private Integer id;
	private String indirizzo;
	private int userId;
	private int operatorId;
	
	public BuildingDTO( String indirizzo, int userId, int operatorId) {
		super();
		this.indirizzo = indirizzo;
		this.userId = userId;
		this.operatorId = operatorId;
	}
	
	public BuildingDTO( String indirizzo, int userId) {
		super();
		this.indirizzo = indirizzo;
		this.userId = userId;
	}

	public BuildingDTO(int id, String indirizzo, int userId, int operatorId) {
		super();
		this.id = id;
		this.indirizzo = indirizzo;
		this.userId = userId;
		this.operatorId = operatorId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}
}