package com.apirest.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.apirest.entidades.CasaDeShow;
import com.apirest.apirest.repository.CasaDeShowRepository;

@RestController
@RequestMapping("/")
public class CasaDeShowController {
	
	@Autowired
	private CasaDeShowRepository repository;
	
	@GetMapping("/casasdeshow")
	public List<CasaDeShow> ListarTodos(){
		return repository.findAll();
	}
	
	@GetMapping("/casasdeshow/{id}")
	CasaDeShow ListarPorId(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/casasdeshow")
	public CasaDeShow criarCasaDeShow(@RequestBody CasaDeShow casadeshow) {
		return repository.save(casadeshow);
	}
	
	
	@PutMapping("/casasdeshow/{id}")
	public ResponseEntity<Object> AtualizaCasaDeShow(@PathVariable("id") Long id, @RequestBody CasaDeShow casadeshow){
		
		Optional<CasaDeShow> CasaDeShowOptional = repository.findById(id);
		casadeshow.setIdcasashow(id);
		repository.save(casadeshow);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/casasdeshow/{id}")
	public void deleteCasaDeShow(@PathVariable Long id) {
		repository.deleteById(id);
	}
	

}
