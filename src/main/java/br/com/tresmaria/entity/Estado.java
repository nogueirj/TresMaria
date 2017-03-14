package br.com.tresmaria.entity;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Estado")
public class Estado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="Id")
	private Long Id;
	
	@Basic(optional=false)
	@NotNull
	@Column(name="CodigoUF")
	private Long CodigoUF;
	
	@Basic(optional=false)
	@NotNull
	@Size(min=1, max=200)
	@Column(name="Nome")
	private String Nome;
	
	@Basic(optional=false)
	@NotNull
	@Size(min=1, max=2)
	@Column(name="UF")
	private String UF;
	
	@Basic(optional=false)
	@NotNull
	@Size(min=1, max=100)
	private String Regiao;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="IdEstado")
	private Collection<Cidade> cidadeCollection;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getCodigoUF() {
		return CodigoUF;
	}

	public void setCodigoUF(Long codigoUF) {
		CodigoUF = codigoUF;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getRegiao() {
		return Regiao;
	}

	public void setRegiao(String regiao) {
		Regiao = regiao;
	}

	public Collection<Cidade> getCidadeCollection() {
		return cidadeCollection;
	}

	public void setCidadeCollection(Collection<Cidade> cidadeCollection) {
		this.cidadeCollection = cidadeCollection;
	}
	
	public Estado() {
	}
}
