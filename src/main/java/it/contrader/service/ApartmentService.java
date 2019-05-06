package it.contrader.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import it.contrader.converter.ApartmentConverter;
import it.contrader.dao.ApartmentRepository;
import it.contrader.dto.ApartmentDTO;
import it.contrader.model.Apartment;

@Service
public class ApartmentService extends AbstractService<Apartment, ApartmentDTO> {
	
	private ApartmentConverter apartmentConverter = new ApartmentConverter();

	@Autowired
	public ApartmentService(CrudRepository<Apartment,Long> crudRepository) {
		this.crudRepository = crudRepository;
		converter = new ApartmentConverter();
	}
	
	public List<ApartmentDTO> findAllBytutor_id(long id) {
		return apartmentConverter.toDTOList(((ApartmentRepository)crudRepository).findByTutor_id(id));
	}
}
