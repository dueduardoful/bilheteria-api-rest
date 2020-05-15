package com.apirest.apirest.entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;


@Entity
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idevento;
	
	@SuppressWarnings("deprecation")
	@NotBlank(message = "Campo nome Obrigatório")
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = false)
	private String descricao;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate dt_inicio;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate dt_fim;
	
	@Column(nullable = false)
	private int ingressos;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private Double preco;
	
	@NotNull(message = "Selecione a Casa de Show relativa ao evento")
	@ManyToOne
	@JoinColumn(name = "id_casadeshow")
	private CasaDeShow casadeshow;

	
	public Evento() {
	}

	public Evento(Long idevento, @NotBlank(message = "Campo nome Obrigatório") String nome, String descricao,
			LocalDate dt_inicio, LocalDate dt_fim, int ingressos, Double preco) {
		this.idevento = idevento;
		this.nome = nome;
		this.descricao = descricao;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
		this.ingressos = ingressos;
		this.preco = preco;
	}

	public Long getIdevento() {
		return idevento;
	}

	public void setIdevento(Long idevento) {
		this.idevento = idevento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(LocalDate dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

	public LocalDate getDt_fim() {
		return dt_fim;
	}

	public void setDt_fim(LocalDate dt_fim) {
		this.dt_fim = dt_fim;
	}

	public int getIngressos() {
		return ingressos;
	}

	public void setIngressos(int ingressos) {
		this.ingressos = ingressos;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public CasaDeShow getCasadeshow() {
		return casadeshow;
	}

	public void setCasadeshow(CasaDeShow casadeshow) {
		this.casadeshow = casadeshow;
	}



	@Override
	public String toString() {
		return "Evento [idevento=" + idevento + ", nome=" + nome + ", descricao=" + descricao + ", dt_inicio="
				+ dt_inicio + ", dt_fim=" + dt_fim + ", ingressos=" + ingressos + ", preco=" + preco + ", casadeshow="
				+ casadeshow + ", listIngressos=" + "]";
	}
	
	
}
