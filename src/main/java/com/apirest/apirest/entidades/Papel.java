package com.apirest.apirest.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Papel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idpapel;
	
	@Column(nullable = false, length = 50)
	private String nome;
	
	@ManyToMany(mappedBy = "papeis", cascade = CascadeType.ALL)
	private List<Usuario> usuarios = new ArrayList<>();
	
	

	public Papel() {
	}

	public Long getIdpapel() {
		return idpapel;
	}

	public void setIdpapel(Long idpapel) {
		this.idpapel = idpapel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Papel [idpapel=" + idpapel + ", nome=" + nome + "]";
	}

	
	

}