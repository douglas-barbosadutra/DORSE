package it.contrader.converter;

import it.contrader.dto.SuperuserDTO;
import it.contrader.model.Superuser;

public class SuperuserConverter extends AbstractConverter<Superuser,SuperuserDTO> {

	@Override
	public Superuser toEntity(SuperuserDTO superuserDTO) {
		Superuser superuser = null;
		if (superuserDTO != null) {
			superuser = new Superuser();
			superuser.setId(superuserDTO.getId());
			superuser.setUsername(superuserDTO.getUsername());
			superuser.setPassword(superuserDTO.getPassword());
			superuser.setUserType(superuserDTO.getUserType());
			superuser.setName(superuserDTO.getName());
			superuser.setSurname(superuserDTO.getSurname());
			superuser.setAddress(superuserDTO.getAddress());
			superuser.setBirthdate(superuserDTO.getBirthdate());
			superuser.setCcc(superuserDTO.getCcc());
			superuser.setEmail(superuserDTO.getEmail());
			superuser.setTelnumber(superuserDTO.getTelnumber());
			superuser.setPaymentStatus(superuserDTO.isPaymentStatus());
			
		}
		return superuser;
	}

	@Override
	public SuperuserDTO toDTO(Superuser superuser) {
		SuperuserDTO superuserDTO = null;
		if (superuser != null) {
			superuserDTO = new SuperuserDTO();
			superuserDTO.setId(superuser.getId());
			superuserDTO.setUsername(superuser.getUsername());
			superuserDTO.setPassword(superuser.getPassword());
			superuserDTO.setUserType(superuser.getUserType());
			superuserDTO.setName(superuser.getName());
			superuserDTO.setSurname(superuser.getSurname());
			superuserDTO.setAddress(superuser.getAddress());
			superuserDTO.setBirthdate(superuser.getBirthdate());
			superuserDTO.setCcc(superuser.getCcc());
			superuserDTO.setEmail(superuser.getEmail());
			superuserDTO.setTelnumber(superuser.getTelnumber());
			superuserDTO.setPaymentStatus(superuser.isPaymentStatus());
		}
		return superuserDTO;
	}

}
