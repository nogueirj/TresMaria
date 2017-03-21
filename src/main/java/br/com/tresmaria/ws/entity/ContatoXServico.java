package br.com.tresmaria.ws.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ContatoXServico")
public class ContatoXServico {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id")
	private Long id;
	@JoinColumn(name = "IdContato", referencedColumnName = "Id")
	@ManyToOne(optional = false)
	private Contato idContato;
	@JoinColumn(name = "IdServico", referencedColumnName = "Id")
	@ManyToOne(optional = false)
	private Servico idServico;

	public ContatoXServico() {
	}

	public ContatoXServico(Long id) {
			this.id = id;
	}

	public Long getId() {
			return id;
	}

	public void setId(Long id) {
			this.id = id;
	}

	public Contato getIdContato() {
			return idContato;
	}

	public void setIdContato(Contato idContato) {
			this.idContato = idContato;
	}

	public Servico getIdServico() {
			return idServico;
	}

	public void setIdServico(Servico idServico) {
			this.idServico = idServico;
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
			if (!(object instanceof ContatoXServico)) {
					return false;
			}
			ContatoXServico other = (ContatoXServico) object;
			if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
					return false;
			}
			return true;
	}

	@Override
	public String toString() {
			return "br.com.tresmaria.entity.ContatoXServico[ id=" + id + " ]";
	}
}
