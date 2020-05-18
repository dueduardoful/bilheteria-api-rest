package com.apirest.apirest.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idcliente;
	
	@Column(nullable = false, length = 45)
	private String nome;
	
	@Column(nullable = false, length = 70)
	private String sobrenome;
	
	@Column(nullable = false, length = 100)
	private String email;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dt_nasc;
	

	@Column(nullable = false, length = 15)
	private String telefone;
	
	@Column(nullable = false, length = 100)
	private String senha;
	@JsonIgnore
	@OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER)
	private List<CasaDeShow> listCasaDeShow = new ArrayList<>();
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "papel_usuario",
			joinColumns=@JoinColumn(name="id_usuario"),
			inverseJoinColumns =@JoinColumn(name="id_papel"))
	private List<Papel> papeis = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "usuario")
	private List<Pedido> listPedidos = new ArrayList<>();
	
	
	public Usuario() {
	}

	public Usuario(Long idcliente, String nome, String sobrenome, String email, Date dt_nasc, String telefone,
			String senha) {
		this.idcliente = idcliente;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.dt_nasc = dt_nasc;
		this.telefone = telefone;
		this.senha = senha;
	}
	

	public List<Pedido> getListPedidos() {
		return listPedidos;
	}

	public void setListPedidos(List<Pedido> listPedidos) {
		this.listPedidos = listPedidos;
	}

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

	public List<CasaDeShow> getListCasaDeShow() {
		return listCasaDeShow;
	}

	public void setListCasaDeShow(List<CasaDeShow> listCasaDeShow) {
		this.listCasaDeShow = listCasaDeShow;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}

	@Override
	public String toString() {
		return "Usuario [idcliente=" + idcliente + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email
				+ ", dt_nasc=" + dt_nasc + ", telefone=" + telefone + ", senha=" + senha + "]";
	}


	
}
