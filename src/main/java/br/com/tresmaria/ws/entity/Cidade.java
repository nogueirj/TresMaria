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
@Table(name="Cidade")
public class Cidade implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id")
	private Long id;
	@Basic(optional = false)
	@NotNull
	@Column(name = "CodigoMunicipio")
	private long codigoMunicipio;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 300)
	@Column(name = "Nome")
	private String nome;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2)
	@Column(name = "UF")
	private String uf;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCidade")
	private Collection<Endereco> enderecoCollection;
	@JoinColumn(name = "IdEstado", referencedColumnName = "Id")
	@ManyToOne(optional = false)
	private Estado idEstado;

	public Cidade() {
	}

	public Cidade(Long id) {
			this.id = id;
	}

	public Cidade(Long id, long codigoMunicipio, String nome, String uf) {
			this.id = id;
			this.codigoMunicipio = codigoMunicipio;
			this.nome = nome;
			this.uf = uf;
	}

	public Long getId() {
			return id;
	}

	public void setId(Long id) {
			this.id = id;
	}

	public long getCodigoMunicipio() {
			return codigoMunicipio;
	}

	public void setCodigoMunicipio(long codigoMunicipio) {
			this.codigoMunicipio = codigoMunicipio;
	}

	public String getNome() {
			return nome;
	}

	public void setNome(String nome) {
			this.nome = nome;
	}

	public String getUf() {
			return uf;
	}

	public void setUf(String uf) {
			this.uf = uf;
	}

	@XmlTransient
	public Collection<Endereco> getEnderecoCollection() {
			return enderecoCollection;
	}

	public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
			this.enderecoCollection = enderecoCollection;
	}

	public Estado getIdEstado() {
			return idEstado;
	}

	public void setIdEstado(Estado idEstado) {
			this.idEstado = idEstado;
	}

	@Override
	public int hashCode() {
			int hash = 0;
			hash += (id != null ? id.hashCode() : 0);
			return hash;
	}

	@Override
	public boolean equals(Object object) {
			// TODO: Warning - this method won't work in the case the id fields are not set
			if (!(object instanceof Cidade)) {
					return false;
			}
			Cidade other = (Cidade) object;
			if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
					return false;
			}
			return true;
	}

	@Override
	public String toString() {
			return "br.com.tresmaria.entity.Cidade[ id=" + id + " ]";
	}
}
