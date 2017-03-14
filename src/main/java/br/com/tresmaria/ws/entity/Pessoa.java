package br.com.tresmaria.ws.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="Id")
	private long Id;
	
	@JoinColumn(name="IdSexo", referencedColumnName="Id")
	@ManyToOne(optional=false)
	private Sexo IdSexo;
	
	@JoinColumn(name="IdEndereco", referencedColumnName="Id")
	@ManyToOne(optional=false)
	private Endereco IdEndereco;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pessoa")
	private PessoaFisica pessoaFisica;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pessoa")
	private PessoaJuridica pessoaJuridica;
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Sexo getIdSexo() {
		return IdSexo;
	}

	public void setIdSexo(Sexo idSexo) {
		IdSexo = idSexo;
	}

	public Endereco getIdEndereco() {
		return IdEndereco;
	}

	public void setIdEndereco(Endereco idEndereco) {
		IdEndereco = idEndereco;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
	public Pessoa() {
	}
}
