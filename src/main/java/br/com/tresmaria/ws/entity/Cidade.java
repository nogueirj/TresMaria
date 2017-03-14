package br.com.tresmaria.ws.entity;

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
@Table(name="Cidade")
public class Cidade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="Id")
	private Long Id;
	
	@JoinColumn(name="IdEstado", referencedColumnName="Id")
	@ManyToOne(optional=false)
	private Estado IdEstado;
	
	@Basic(optional=false)
	@NotNull
	@Column(name="CodigoMunicipio")
	private Long CodigoMunicipio;
	
	@Basic(optional=false)
	@NotNull
	@Size(min=1, max=300)
	@Column(name="Nome")
	private String Nome;
	
	@Basic(optional=false)
	@NotNull
	@Size(min=1, max=2)
	@Column(name="UF")
	private String UF;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="IdCidade")
	private Collection<Endereco> enderecoCollection;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Estado getIdEstado() {
		return IdEstado;
	}

	public void setIdEstado(Estado idEstado) {
		IdEstado = idEstado;
	}

	public Long getCodigoMunicipio() {
		return CodigoMunicipio;
	}

	public void setCodigoMunicipio(Long codigoMunicipio) {
		CodigoMunicipio = codigoMunicipio;
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

	public Collection<Endereco> getEnderecoCollection() {
		return enderecoCollection;
	}

	public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
		this.enderecoCollection = enderecoCollection;
	}
	public Cidade() {
	}
}
