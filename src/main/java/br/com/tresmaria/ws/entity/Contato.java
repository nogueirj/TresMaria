package br.com.tresmaria.ws.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="Contato")
public class Contato implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id")
	private Long id;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DataHoraContato")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraContato;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idContato")
	private Collection<ContatoXServico> contatoXServicoCollection;
	@JoinColumn(name = "IdTelefoneContato", referencedColumnName = "Id")
	@ManyToOne(optional = false)
	private TelefoneContato idTelefoneContato;
	@JoinColumn(name="IdPessoa", referencedColumnName= "Id")
	@ManyToOne(optional=false)
	private Pessoa idPessoa;

	public Contato() {
	}

	public Contato(Long id) {
			this.id = id;
	}

	public Contato(Long id, Date dataHoraContato) {
			this.id = id;
			this.dataHoraContato = dataHoraContato;
	}

	public Long getId() {
			return id;
	}

	public void setId(Long id) {
			this.id = id;
	}

	public Date getDataHoraContato() {
			return dataHoraContato;
	}

	public void setDataHoraContato(Date dataHoraContato) {
			this.dataHoraContato = dataHoraContato;
	}

	@XmlTransient
	public Collection<ContatoXServico> getContatoXServicoCollection() {
			return contatoXServicoCollection;
	}

	public void setContatoXServicoCollection(Collection<ContatoXServico> contatoXServicoCollection) {
			this.contatoXServicoCollection = contatoXServicoCollection;
	}

	public TelefoneContato getIdTelefoneContato() {
			return idTelefoneContato;
	}

	public void setIdTelefoneContato(TelefoneContato idTelefoneContato) {
			this.idTelefoneContato = idTelefoneContato;
	}

	public Pessoa getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Pessoa idPessoa) {
		this.idPessoa = idPessoa;
	}

	@Override
	public int hashCode() {
			int hash = 0;
			hash += (id != null ? id.hashCode() : 0);
			return hash;
	}

	@Override
	public boolean equals(Object object) {
			if (!(object instanceof Contato)) {
					return false;
			}
			Contato other = (Contato) object;
			if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
					return false;
			}
			return true;
	}

	@Override
	public String toString() {
			return "br.com.tresmaria.entity.Contato[ id=" + id + " ]";
	}
}
