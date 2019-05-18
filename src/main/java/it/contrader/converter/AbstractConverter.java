package it.contrader.converter;

import java.lang.reflect.Type;
import java.util.List;

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
	
	@SuppressWarnings("unchecked")
	public Entity toEntity(DTO dto) {
		Entity entity = (Entity) modelMapper.map(dto, ReflectionUtils.getClassDeclaredInSuperClassGeneric(this, 0));
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public DTO toDTO(Entity entity) {
		DTO dto = (DTO) modelMapper.map(entity, ReflectionUtils.getClassDeclaredInSuperClassGeneric(this, 1));
		return dto;
	}
	
	@Override
	public List<DTO> toDTOList(List<Entity> listEntity) {
		Type listType = new TypeToken<List<DTO>>(){}.getType();
		List<DTO> listDTO = modelMapper.map(listEntity, listType);
		return listDTO;
	}

	@Override
	public List<Entity> toEntityList(List<DTO> listDTO) {
		Type listType = new TypeToken<List<Entity>>(){}.getType();
		List<Entity> listEntity = modelMapper.map(listDTO, listType);
		return listEntity;
	}
}
