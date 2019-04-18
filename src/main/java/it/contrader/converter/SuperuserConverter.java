package it.contrader.converter;

import it.contrader.dto.OperatorDTO;
import it.contrader.dto.SuperuserDTO;
import it.contrader.model.Operator;
import it.contrader.model.Superuser;

public class SuperuserConverter implements Converter<Superuser,SuperuserDTO> {

	@Override
	public Superuser toEntity(SuperuserDTO superuserDTO) {
		Superuser superuser = null;
		if (superuserDTO != null) {
			superuser = new Superuser();
		}
		return superuser;
	}

	@Override
	public SuperuserDTO toDTO(Superuser superuser) {
		SuperuserDTO superuserDTO = null;
		if (superuser != null) {
			
		}
		return superuserDTO;
	}

}
