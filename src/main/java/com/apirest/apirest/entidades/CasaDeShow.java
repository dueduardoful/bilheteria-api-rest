package com.apirest.apirest.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CasaDeShow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idcasashow;
	
	@SuppressWarnings("deprecation")
	@NotBlank(message = "Campo nome Obrigatório")
	@Column(nullable = false, length = 45)
	private String nome;
	
	@Column(nullable = false, length = 100)
	private String endereco;
	
	@Column(nullable = false)
	private int capacidade;
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "casadeshow")
	private List<Evento> listEventos = new ArrayList<>();
	
	public CasaDeShow() {
	}
	public CasaDeShow(Long idcasashow, @NotBlank(message = "Campo nome Obrigatório") String nome, String endereco,
			int capacidade) {
		this.idcasashow = idcasashow;
		this.nome = nome;
		this.endereco = endereco;
		this.capacidade = capacidade;
	}



	public Long getIdcasashow() {
		return idcasashow;
	}

	public void setIdcasashow(Long idcasashow) {
		this.idcasashow = idcasashow;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Evento> getListEventos() {
		return listEventos;
	}

	public void setListEventos(List<Evento> listEventos) {
		this.listEventos = listEventos;
	}

	@Override
	public String toString() {
		return "CasaDeShow [idcasashow=" + idcasashow + ", nome=" + nome + ", endereco=" + endereco + ", capacidade="
				+ capacidade + "]";
	}
	
	
	
}
