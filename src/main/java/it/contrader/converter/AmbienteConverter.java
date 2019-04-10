package it.contrader.converter;

import it.contrader.dto.AmbienteDTO;
import it.contrader.model.Ambiente;

public class AmbienteConverter implements Converter<Ambiente,AmbienteDTO> {

	
	public Ambiente toEntity(AmbienteDTO ambienteDTO) {

		Ambiente ambiente = null;
		if (ambienteDTO != null) {
			ambiente = new Ambiente(ambienteDTO.getDescrizione(), ambienteDTO.getBuildingid());
		}

		return ambiente;
	}


	public AmbienteDTO toDTO(Ambiente ambiente) {

		AmbienteDTO ambienteDTO = null;
		if (ambiente != null) {
			ambienteDTO = new AmbienteDTO(ambiente.getDescrizione(), ambiente.getBuildingid());
		}

		return ambienteDTO;
	}
}
