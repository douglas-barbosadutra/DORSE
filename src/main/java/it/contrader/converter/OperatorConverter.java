package it.contrader.converter;

import it.contrader.dto.OperatorDTO;
import it.contrader.model.Operator;


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
			operator.setSurname(operatorDTO.getSurname());
			operator.setBirthdate(operatorDTO.getBirthdate());
			operator.setAddress(operatorDTO.getAddress());
			operator.setEmail(operatorDTO.getEmail());
			operator.setTelnumber(operatorDTO.getTelnumber());
			operator.setCcc(operatorDTO.getCcc());
			operator.setPaymentStatus(operatorDTO.isPaymentStatus());
			
			operator.setAvailability(operatorDTO.isAvailability());
			operator.setCategory(operatorDTO.getCategory());
			
		}
		return operator;
	}

	@Override
	public OperatorDTO toDTO(Operator operator) {
		OperatorDTO operatorDTO = null;
		if (operator != null) {
			operatorDTO.setId(operator.getId());
			operatorDTO.setUsername(operator.getUsername());
			operatorDTO.setPassword(operator.getPassword());
			operatorDTO.setUserType(operator.getUserType());
			operatorDTO.setName(operator.getName());
			operatorDTO.setSurname(operator.getSurname());
			operatorDTO.setBirthdate(operator.getBirthdate());
			operatorDTO.setAddress(operator.getAddress());
			operatorDTO.setEmail(operator.getEmail());
			operatorDTO.setTelnumber(operator.getTelnumber());
			operatorDTO.setCcc(operator.getCcc());
			operatorDTO.setPaymentStatus(operator.isPaymentStatus());
			
			operatorDTO.setAvailability(operator.isAvailability());
			operatorDTO.setCategory(operator.getCategory());
		}
		return operatorDTO;
	}
}

