package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import it.contrader.converter.OperatorConverter;
import it.contrader.converter.SuperuserConverter;
import it.contrader.dto.OperatorDTO;
import it.contrader.dto.SuperuserDTO;
import it.contrader.model.Operator;
import it.contrader.model.Superuser;

@Service
public class SuperuserService extends AbstractService<Superuser,SuperuserDTO> {

	@Autowired
	public SuperuserService(CrudRepository<Superuser,Long> crudRepository) {
		this.crudRepository = crudRepository;
		converter = new SuperuserConverter();
	}
}
