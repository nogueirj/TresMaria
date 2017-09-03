package br.com.tresmaria.ws.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Servico implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id")
	private Long id;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 300)
	@Column(name = "Descricao")
	private String descricao;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idServico", fetch=FetchType.EAGER)
	private Collection<ContatoXServico> contatoXServicoCollection;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idServico", fetch=FetchType.EAGER)
	private Collection<Preco> precoCollection;

	public Servico() {
	}

	public Servico(Long id) {
			this.id = id;
	}

	public Servico(Long id, String descricao) {
			this.id = id;
			this.descricao = descricao;
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

	@XmlTransient
	public Collection<ContatoXServico> getContatoXServicoCollection() {
			return contatoXServicoCollection;
	}

	public void setContatoXServicoCollection(Collection<ContatoXServico> contatoXServicoCollection) {
			this.contatoXServicoCollection = contatoXServicoCollection;
	}

	@XmlTransient
	public Collection<Preco> getPrecoCollection() {
			return precoCollection;
	}

	public void setPrecoCollection(Collection<Preco> precoCollection) {
			this.precoCollection = precoCollection;
	}

	@Override
	public int hashCode() {
			int hash = 0;
			hash += (id != null ? id.hashCode() : 0);
			return hash;
	}

	@Override
	public boolean equals(Object object) {
			if (!(object instanceof Servico)) {
					return false;
			}
			Servico other = (Servico) object;
			if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
					return false;
			}
			return true;
	}

	@Override
	public String toString() {
			return "br.com.tresmaria.entity.Servico[ id=" + id + " ]";
	}
}
