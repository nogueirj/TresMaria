package br.com.tresmaria.ws.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity(name="Sexo")
public class Sexo {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id")
	private Long id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "Descricao")
	private String descricao;
	@Basic(optional = false)
	@NotNull
	@Column(name = "Sigla")
	private Character sigla;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idSexo")
	private Collection<Pessoa> pessoaCollection;

	public Sexo() {
	}

	public Sexo(Long id) {
			this.id = id;
	}

	public Sexo(Long id, String descricao, Character sigla) {
			this.id = id;
			this.descricao = descricao;
			this.sigla = sigla;
	}

	public Long getId() {
			return id;
	}

	public void setId(Long id) {
			this.id = id;
	}

	public String getDescricao() {
			return descricao;
	}

	public void setDescricao(String descricao) {
			this.descricao = descricao;
	}

	public Character getSigla() {
			return sigla;
	}

	public void setSigla(Character sigla) {
			this.sigla = sigla;
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
			// TODO: Warning - this method won't work in the case the id fields are not set
			if (!(object instanceof Sexo)) {
					return false;
			}
			Sexo other = (Sexo) object;
			if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
					return false;
			}
			return true;
	}

	@Override
	public String toString() {
			return "br.com.tresmaria.entity.Sexo[ id=" + id + " ]";
	}
}
