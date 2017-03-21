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
@Table(name="PessoaFisica")
public class PessoaFisica implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "Id")
	private Long id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 350)
	@Column(name = "Nome")
	private String nome;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 11)
	@Column(name = "CPF")
	private String cpf;
	@Size(max = 10)
	@Column(name = "RG")
	private String rg;
	@JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
	@OneToOne(optional = false)
	private Pessoa pessoa;

	public PessoaFisica() {
	}

	public PessoaFisica(Long id) {
			this.id = id;
	}

	public PessoaFisica(Long id, String nome, String cpf) {
			this.id = id;
			this.nome = nome;
			this.cpf = cpf;
	}

	public Long getId() {
			return id;
	}

	public void setId(Long id) {
			this.id = id;
	}

	public String getNome() {
			return nome;
	}

	public void setNome(String nome) {
			this.nome = nome;
	}

	public String getCpf() {
			return cpf;
	}

	public void setCpf(String cpf) {
			this.cpf = cpf;
	}

	public String getRg() {
			return rg;
	}

	public void setRg(String rg) {
			this.rg = rg;
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
			if (!(object instanceof PessoaFisica)) {
					return false;
			}
			PessoaFisica other = (PessoaFisica) object;
			if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
					return false;
			}
			return true;
	}

	@Override
	public String toString() {
			return "br.com.tresmaria.entity.PessoaFisica[ id=" + id + " ]";
	}
}
