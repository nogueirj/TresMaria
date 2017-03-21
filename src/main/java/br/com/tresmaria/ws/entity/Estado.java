package br.com.tresmaria.ws.entity;

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

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id")
	private Long id;
	@Basic(optional = false)
	@NotNull
	@Column(name = "CodigoUF")
	private long codigoUF;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "Nome")
	private String nome;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2)
	@Column(name = "UF")
	private String uf;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "Regiao")
	private String regiao;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
	private Collection<Cidade> cidadeCollection;

	public Estado() {
	}

	public Estado(Long id) {
			this.id = id;
	}

	public Estado(Long id, long codigoUF, String nome, String uf, String regiao) {
			this.id = id;
			this.codigoUF = codigoUF;
			this.nome = nome;
			this.uf = uf;
			this.regiao = regiao;
	}

	public Long getId() {
			return id;
	}

	public void setId(Long id) {
			this.id = id;
	}

	public long getCodigoUF() {
			return codigoUF;
	}

	public void setCodigoUF(long codigoUF) {
			this.codigoUF = codigoUF;
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

	public String getRegiao() {
			return regiao;
	}

	public void setRegiao(String regiao) {
			this.regiao = regiao;
	}

	@XmlTransient
	public Collection<Cidade> getCidadeCollection() {
			return cidadeCollection;
	}

	public void setCidadeCollection(Collection<Cidade> cidadeCollection) {
			this.cidadeCollection = cidadeCollection;
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
			if (!(object instanceof Estado)) {
					return false;
			}
			Estado other = (Estado) object;
			if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
					return false;
			}
			return true;
	}

	@Override
	public String toString() {
			return "br.com.tresmaria.entity.Estado[ id=" + id + " ]";
	}
}
