package br.com.tresmaria.ws.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="PessoaJuridica")
public class PessoaJuridica implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "Id")
	private Long id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 300)
	@Column(name = "NomeFantasia")
	private String nomeFantasia;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 14)
	@Column(name = "CNPJ")
	private String cnpj;
	@Size(max = 19)
	@Column(name = "IncricaoEstadual")
	private String incricaoEstadual;
	@JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
	@OneToOne(optional = false)
	private Pessoa pessoa;

	public PessoaJuridica() {
	}

	public PessoaJuridica(Long id) {
			this.id = id;
	}

	public PessoaJuridica(Long id, String nomeFantasia, String cnpj) {
			this.id = id;
			this.nomeFantasia = nomeFantasia;
			this.cnpj = cnpj;
	}

	public Long getId() {
			return id;
	}

	public void setId(Long id) {
			this.id = id;
	}

	public String getNomeFantasia() {
			return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
			this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
			return cnpj;
	}

	public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
	}

	public String getIncricaoEstadual() {
			return incricaoEstadual;
	}

	public void setIncricaoEstadual(String incricaoEstadual) {
			this.incricaoEstadual = incricaoEstadual;
	}

	public Pessoa getPessoa() {
			return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
			this.pessoa = pessoa;
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
			if (!(object instanceof PessoaJuridica)) {
					return false;
			}
			PessoaJuridica other = (PessoaJuridica) object;
			if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
					return false;
			}
			return true;
	}

	@Override
	public String toString() {
			return "br.com.tresmaria.entity.PessoaJuridica[ id=" + id + " ]";
	}
}
