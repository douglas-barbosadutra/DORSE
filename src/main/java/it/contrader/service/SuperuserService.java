package it.contrader.service;

import java.util.List;

import org.springframework.stereotype.Service;
import it.contrader.dto.SuperuserDTO;
import it.contrader.model.Superuser;

@Service
public class SuperuserService extends AbstractService<Superuser,SuperuserDTO> {
	
	@Override
	public List<SuperuserDTO> getAllBy(Object o) {
		return null;
	}
}
