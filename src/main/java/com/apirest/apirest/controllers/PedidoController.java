package com.apirest.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.apirest.entidades.Evento;
import com.apirest.apirest.entidades.Pedido;
import com.apirest.apirest.repository.EventoRepository;
import com.apirest.apirest.repository.PedidoRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class PedidoController {
	
	@Autowired
	private PedidoRepository repository;
	@Autowired
	private EventoRepository repositoryEvento;
	
	@GetMapping("/pedidos")
	public List<Pedido> ListarTodos(){
		return repository.findAll();
	}
	
	@GetMapping("/pedidos/{id}")
	Pedido ListarPorId(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/pedidos")
	public Pedido criarPedido(@RequestBody Pedido pedido, Evento evento) throws Exception {
		System.out.println(pedido);
		if(pedido.getQuantidade() <= 4 && pedido.getQuantidade() > 0) {
			evento = repositoryEvento.findById(pedido.getEvento().getIdevento()).get();
			evento.setIngressos(evento.getIngressos() - pedido.getQuantidade());
			return repository.save(pedido);
		}
		else {
			throw new Exception("Quantidade limitada até 4 ingressos");
		}
		
	}
	
	@PutMapping("/pedidos/{id}")
	public ResponseEntity<Object> AtualizaPedidos(@PathVariable("id") Long id, @RequestBody Pedido pedido){
		
		Optional<Pedido> PedidoOptional = repository.findById(id);
		pedido.setIdpedido(id);
		repository.save(pedido);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/pedidos/{id}")
	public void deletePedidos(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
