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

import com.apirest.apirest.entidades.Evento;
import com.apirest.apirest.repository.EventoRepository;

@RestController
@RequestMapping("/")
public class EventoController {
	
	@Autowired
	private EventoRepository repository;
	
	@GetMapping("/eventos")
	public List<Evento> ListarTodos(){
		return repository.findAll();
	}
	
	@GetMapping("/eventos/{id}")
	Evento ListarPorId(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/eventos")
	public Evento criarEvento(@RequestBody Evento evento) {
		return repository.save(evento);
	}
	
	@PutMapping("/eventos/{id}")
	public ResponseEntity<Object> AtualizaEvento(@PathVariable("id") Long id, @RequestBody Evento evento){
		
		Optional<Evento> EventoOptional = repository.findById(id);
		evento.setIdevento(id);
		repository.save(evento);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/eventos/{id}")
	public void deleteEvento(@PathVariable Long id) {
		System.out.println(id);
		repository.deleteById(id);
	}

}
