package it.contrader.service;

import java.util.List;
import org.springframework.stereotype.Service;
import it.contrader.dao.ApartmentRepository;
import it.contrader.dto.ApartmentDTO;
import it.contrader.model.Apartment;
import it.contrader.model.Tutor;

@Service
public class ApartmentService extends AbstractService<Apartment, ApartmentDTO> {
	
	@Override
	public List<ApartmentDTO> getAllBy(Object o) {
		return converter.toDTOList(((ApartmentRepository)crudRepository).findByTutor_id(((Tutor)o).getId()));
	}
}
