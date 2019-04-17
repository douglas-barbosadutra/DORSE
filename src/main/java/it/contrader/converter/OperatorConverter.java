package it.contrader.converter;

import it.contrader.dto.OperatorDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Operator;
import it.contrader.model.User;

public class OperatorConverter implements Converter<Operator,OperatorDTO> {

	@Override
	public Operator toEntity(OperatorDTO operatorDTO) {
		Operator operator = null;
		if (operatorDTO != null) {
			operator = new Operator();
			operator.setId(operatorDTO.getId());
			operator.setUsername(operatorDTO.getUsername());
			operator.setPassword(operatorDTO.getPassword());
			operator.setUserType(operatorDTO.getUserType());
			operator.setName(operatorDTO.getName());
			operator.setAvailability(operatorDTO.isAvailability());
			operator.setBirthdate(operatorDTO.getBirthdate());
		}
		return operator;
	}

	@Override
	public OperatorDTO toDTO(Operator operator) {
		OperatorDTO operatorDTO = null;
		if (operator != null) {
			operatorDTO = new OperatorDTO();
			operatorDTO.setId(operator.getId());
			operatorDTO.setUsername(operator.getUsername());
			operatorDTO.setPassword(operator.getPassword());
			operatorDTO.setUserType(operator.getUserType());
			operatorDTO.setName(operator.getName());
			operatorDTO.setAvailability(operator.isAvailability());
			operatorDTO.setBirthdate(operator.getBirthdate());
		}
		return operatorDTO;
	}
}
