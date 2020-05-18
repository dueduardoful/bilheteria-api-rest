package com.apirest.apirest.entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idpedido;

	@Column(nullable = false, length = 10, scale = 2)
	private Double total;
	
	@Column(nullable = false)
	private LocalDate data_compra;
	
	@Column(nullable = false)
	private int quantidade;
	
	@ManyToOne()
	@JoinColumn(name = "id_usuario")
	@JsonIgnore
	private Usuario usuario;
	
	@ManyToOne()
	@JoinColumn(name= "id_evento")
	private Evento evento;

	public Pedido() {
	}

	public Pedido(Long idpedido, Double total, LocalDate data_compra) {
		this.idpedido = idpedido;
		this.total = total;
		this.data_compra = data_compra;
	}

	public Long getIdpedido() {
		return idpedido;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public void setIdpedido(Long idpedido) {
		this.idpedido = idpedido;
	}

	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDate getData_compra() {
		return data_compra;
	}

	public void setData_compra(LocalDate data_compra) {
		this.data_compra = data_compra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Pedido [idpedido=" + idpedido + ", total=" + total + ", data_compra=" + data_compra + ", quantidade="
				+ quantidade + ", usuario=" + usuario + ", evento=" + evento + "]";
	}


	
	
}
