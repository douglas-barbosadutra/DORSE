package it.contrader.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.service.ServiceDTO;

public abstract class AbstractController <Entity, DTO>{

	@Autowired
	private ServiceDTO<Entity, DTO> service;
	
	@GetMapping("/getall")
	public List<DTO> getAll(){
		return service.getAll();		
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam("id") long id) {
		service.delete(id);
	}
	
	@GetMapping("/update")
	public DTO update(DTO dto){
		service.update(dto);
		return dto;
	}
	
	@PostMapping("/insert")
	public DTO insert (@RequestBody DTO dto) {
		service.insert(dto);
		return dto;
	}
	
	@GetMapping("/read")
	public DTO read(long id) {
		return service.read(id);
	}
}