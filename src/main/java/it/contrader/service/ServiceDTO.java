package it.contrader.service;

public interface ServiceDTO<Entity,DTO> {
	
	public Iterable<DTO> getAll();
	
	public Iterable<DTO> getAllBy(long id);

	public DTO read(long id);
	
	public Entity insert (DTO dto);
	
	public Entity update (DTO dto);
	
	public void delete (long id);
}