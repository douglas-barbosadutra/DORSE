package it.contrader.converter;

import java.lang.reflect.Type;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import it.contrader.utils.ReflectionUtils;

public abstract class AbstractConverter<Entity,DTO> implements Converter<Entity,DTO> {
	
	@Bean
	public ModelMapper modelMapper() {
	    ModelMapper modelMapper = new ModelMapper();
	    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	    return modelMapper;
	}

	@Autowired
	protected ModelMapper modelMapper;
	
	@Override
	@SuppressWarnings("unchecked")
	public Entity toEntity(DTO dto) {
		Entity entity = (Entity) modelMapper.map(dto, ReflectionUtils.getClassDeclaredInSuperClassGeneric(this, 0));
		return entity;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public DTO toDTO(Entity entity) {
		DTO dto = (DTO) modelMapper.map(entity, ReflectionUtils.getClassDeclaredInSuperClassGeneric(this, 1));
		return dto;
	}
	
	@Override
	public Iterable<DTO> toDTOList(Iterable<Entity> iterEntity) {
		Type listType = new TypeToken<Iterable<DTO>>(){}.getType();
		Iterable<DTO> iterDTO = modelMapper.map(iterEntity, listType);
		return iterDTO;
	}

	@Override
	public Iterable<Entity> toEntityList(Iterable<DTO> iterDTO) {
		Type listType = new TypeToken<Iterable<Entity>>(){}.getType();
		Iterable<Entity> iterEntity = modelMapper.map(iterDTO, listType);
		return iterEntity;
	}
}
