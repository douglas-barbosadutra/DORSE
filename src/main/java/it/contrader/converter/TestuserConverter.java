package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.SuperuserDTO;
import it.contrader.dto.TestuserDTO;
import it.contrader.model.Superuser;
import it.contrader.model.Testuser;

@Component
public class TestuserConverter extends AbstractConverter<Testuser,TestuserDTO> {

	@Override
	public Testuser toEntity(TestuserDTO testuserDTO) {
		Testuser testuser = null;
		if (testuserDTO != null) {
			testuser = new Testuser();
			testuser.setId(testuserDTO.getId());
			testuser.setUsername(testuserDTO.getUsername());
			testuser.setPassword(testuserDTO.getPassword());
			testuser.setUserType(testuserDTO.getUserType());
			testuser.setName(testuserDTO.getName());
			testuser.setSurname(testuserDTO.getSurname());
			testuser.setAddress(testuserDTO.getAddress());
			testuser.setBirthdate(testuserDTO.getBirthdate());
			testuser.setCcc(testuserDTO.getCcc());
			testuser.setEmail(testuserDTO.getEmail());
			testuser.setTelnumber(testuserDTO.getTelnumber());
			testuser.setPaymentStatus(testuserDTO.isPaymentStatus());
			
		}
		return testuser;
	}

	@Override
	public TestuserDTO toDTO(Testuser testuser) {
		TestuserDTO testuserDTO = null;
		if (testuser != null) {
			testuserDTO = new TestuserDTO();
			testuserDTO.setId(testuser.getId());
			testuserDTO.setUsername(testuser.getUsername());
			testuserDTO.setPassword(testuser.getPassword());
			testuserDTO.setUserType(testuser.getUserType());
			testuserDTO.setName(testuser.getName());
			testuserDTO.setSurname(testuser.getSurname());
			testuserDTO.setAddress(testuser.getAddress());
			testuserDTO.setBirthdate(testuser.getBirthdate());
			testuserDTO.setCcc(testuser.getCcc());
			testuserDTO.setEmail(testuser.getEmail());
			testuserDTO.setTelnumber(testuser.getTelnumber());
			testuserDTO.setPaymentStatus(testuser.isPaymentStatus());
		}
		return testuserDTO;
	}

}
