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

import com.apirest.apirest.entidades.Usuario;
import com.apirest.apirest.repository.UsuarioRepository;

@RestController
@RequestMapping("/")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping("/usuarios")
	public List<Usuario> ListarTodos(){
		return repository.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	Usuario ListarPorId(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/usuarios")
	public Usuario criarUsuario(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Object> AtualizaUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario){
		
		Optional<Usuario> UsuarioOptional = repository.findById(id);
		usuario.setIdcliente(id);
		repository.save(usuario);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/usuarios/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
