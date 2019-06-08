package it.contrader.service.mapper;

import org.mapstruct.Context;

public interface GenericMapper<Entity, DTO> {

	public Entity toEntity(DTO dto, @Context CycleAvoidingMappingContext context);
	
	public DTO toDTO(Entity entity, @Context CycleAvoidingMappingContext context);
	
	public Iterable<DTO> toDTO(Iterable<Entity> iterEntity, @Context CycleAvoidingMappingContext context);
	
	public Iterable<Entity> toEntity(Iterable<DTO> iterDTO, @Context CycleAvoidingMappingContext context);
}
