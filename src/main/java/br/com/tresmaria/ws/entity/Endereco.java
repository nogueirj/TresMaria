package br.com.tresmaria.ws.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="Endereco")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id")
	private Long id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 300)
	@Column(name = "Logradouro")
	private String logradouro;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "Numero")
	private String numero;
	@Size(max = 100)
	@Column(name = "Complemento")
	private String complemento;
	@JoinColumn(name = "IdCidade", referencedColumnName = "Id")
	@ManyToOne(optional = false)
	private Cidade idCidade;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idEndereco")
	private Collection<Pessoa> pessoaCollection;

	public Endereco() {
	}

	public Endereco(Long id) {
			this.id = id;
	}

	public Endereco(Long id, String logradouro, String numero) {
			this.id = id;
			this.logradouro = logradouro;
			this.numero = numero;
	}

	public Long getId() {
			return id;
	}

	public void setId(Long id) {
			this.id = id;
	}

	public String getLogradouro() {
			return logradouro;
	}

	public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
	}

	public String getNumero() {
			return numero;
	}

	public void setNumero(String numero) {
			this.numero = numero;
	}

	public String getComplemento() {
			return complemento;
	}

	public void setComplemento(String complemento) {
			this.complemento = complemento;
	}

	public Cidade getIdCidade() {
			return idCidade;
	}

	public void setIdCidade(Cidade idCidade) {
			this.idCidade = idCidade;
	}

	@XmlTransient
	public Collection<Pessoa> getPessoaCollection() {
			return pessoaCollection;
	}

	public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
			this.pessoaCollection = pessoaCollection;
	}

	@Override
	public int hashCode() {
			int hash = 0;
			hash += (id != null ? id.hashCode() : 0);
			return hash;
	}

	@Override
	public boolean equals(Object object) {
			if (!(object instanceof Endereco)) {
					return false;
			}
			Endereco other = (Endereco) object;
			if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
					return false;
			}
			return true;
	}

	@Override
	public String toString() {
			return "br.com.tresmaria.entity.Endereco[ id=" + id + " ]";
	}
}
