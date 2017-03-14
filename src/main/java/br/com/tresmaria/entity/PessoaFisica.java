package br.com.tresmaria.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="PessoaFisica")
public class PessoaFisica {

	@Id
	@Basic(optional=false)
	@NotNull
	@Column(name="Id")
	private Long Id;
	
	@Basic(optional=false)
	@NotNull
	@Size(min=1, max=350)
	@Column(name="Nome")
	private String Nome;
	
	@Size(max=10)
	@Column(name="RG")
	private String RG;
	
	@Basic(optional=false)
	@NotNull
	@Size(min=1, max=11)
	@Column(name="CPF")
	private String CPF;
	
	@OneToOne(optional=false)
	@JoinColumn(name="Id", referencedColumnName="Id", insertable=false, updatable=false)
	private Pessoa pessoa;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public PessoaFisica() {
	}
}
