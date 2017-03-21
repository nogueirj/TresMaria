package br.com.tresmaria.ws.entity;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Pessoa")
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id")
	private Long id;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DataHoraCadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraCadastro;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa")
	private PessoaJuridica pessoaJuridica;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa")
	private PessoaFisica pessoaFisica;
	@JoinColumn(name = "IdEndereco", referencedColumnName = "Id")
	@ManyToOne(optional = false)
	private Endereco idEndereco;
	@JoinColumn(name = "IdSexo", referencedColumnName = "Id")
	@ManyToOne(optional = false)
	private Sexo idSexo;

	public Pessoa() {
	}

	public Pessoa(Long id) {
			this.id = id;
	}

	public Pessoa(Long id, Date dataHoraCadastro) {
			this.id = id;
			this.dataHoraCadastro = dataHoraCadastro;
	}

	public Long getId() {
			return id;
	}

	public void setId(Long id) {
			this.id = id;
	}

	public Date getDataHoraCadastro() {
			return dataHoraCadastro;
	}

	public void setDataHoraCadastro(Date dataHoraCadastro) {
			this.dataHoraCadastro = dataHoraCadastro;
	}

	public PessoaJuridica getPessoaJuridica() {
			return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
			this.pessoaJuridica = pessoaJuridica;
	}

	public PessoaFisica getPessoaFisica() {
			return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
			this.pessoaFisica = pessoaFisica;
	}

	public Endereco getIdEndereco() {
			return idEndereco;
	}

	public void setIdEndereco(Endereco idEndereco) {
			this.idEndereco = idEndereco;
	}

	public Sexo getIdSexo() {
			return idSexo;
	}

	public void setIdSexo(Sexo idSexo) {
			this.idSexo = idSexo;
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
			if (!(object instanceof Pessoa)) {
					return false;
			}
			Pessoa other = (Pessoa) object;
			if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
					return false;
			}
			return true;
	}

	@Override
	public String toString() {
			return "br.com.tresmaria.entity.Pessoa[ id=" + id + " ]";
	}
}
