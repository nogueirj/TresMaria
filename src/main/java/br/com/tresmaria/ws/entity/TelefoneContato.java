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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="TelefoneContato")
public class TelefoneContato implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id")
	private Long id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 4)
	@Column(name = "DDD")
	private String ddd;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 9)
	@Column(name = "Numero")
	private String numero;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idTelefoneContato")
	private Collection<Contato> contatoCollection;

	public TelefoneContato() {
	}

	public TelefoneContato(Long id) {
			this.id = id;
	}

	public TelefoneContato(Long id, String ddd, String numero) {
			this.id = id;
			this.ddd = ddd;
			this.numero = numero;
	}

	public Long getId() {
			return id;
	}

	public void setId(Long id) {
			this.id = id;
	}

	public String getDdd() {
			return ddd;
	}

	public void setDdd(String ddd) {
			this.ddd = ddd;
	}

	public String getNumero() {
			return numero;
	}

	public void setNumero(String numero) {
			this.numero = numero;
	}

	@XmlTransient
	public Collection<Contato> getContatoCollection() {
			return contatoCollection;
	}

	public void setContatoCollection(Collection<Contato> contatoCollection) {
			this.contatoCollection = contatoCollection;
	}

	@Override
	public int hashCode() {
			int hash = 0;
			hash += (id != null ? id.hashCode() : 0);
			return hash;
	}

	@Override
	public boolean equals(Object object) {
			if (!(object instanceof TelefoneContato)) {
					return false;
			}
			TelefoneContato other = (TelefoneContato) object;
			if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
					return false;
			}
			return true;
	}

	@Override
	public String toString() {
			return "br.com.tresmaria.entity.TelefoneContato[ id=" + id + " ]";
	}
}
