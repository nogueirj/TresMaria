package br.com.tresmaria.entity;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="Id")
	private Long Id;
	
	@Basic(optional=false)
	@NotNull
	@Size(min=1, max=300)
	@Column(name="Logradouro")
	private String Logradouro;
	
	@Basic(optional=false)
	@NotNull
	@Size(min=1, max=10)
	@Column(name="Numero")
	private String Numero;
	
	@Size(max=100)
	@Column(name="Complemento")
	private String Complemento;
	
	@JoinColumn(name="IdCidade", referencedColumnName="Id")
	@ManyToOne(optional=false)
	private Cidade IdCidade;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="IdEndereco")
	private Collection<Pessoa> pessoaCollection;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	public String getComplemento() {
		return Complemento;
	}

	public void setComplemento(String complemento) {
		Complemento = complemento;
	}

	public Cidade getIdCidade() {
		return IdCidade;
	}

	public void setIdCidade(Cidade idCidade) {
		IdCidade = idCidade;
	}

	public Collection<Pessoa> getPessoaCollection() {
		return pessoaCollection;
	}

	public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
		this.pessoaCollection = pessoaCollection;
	}
	
	public Endereco() {
	}
}
