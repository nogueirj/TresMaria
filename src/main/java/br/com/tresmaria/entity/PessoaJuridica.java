package br.com.tresmaria.entity;

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
public class PessoaJuridica {

	@Id
	@Basic(optional=false)
	@NotNull
	@Column(name="Id")
	private Long Id;
	
	@Basic(optional=false)
	@NotNull
	@Size(min=1, max=300)
	@Column(name="NomeFantasia")
	private String NomeFantasia;
	
	@Basic(optional=false)
	@NotNull
	@Size(min=1, max=14)
	private String CNPJ;
	
	@Size(max=19)
	@Column(name="IncricaoEstadual")
	private String IncricaoEstadual;
	
	@OneToOne(optional=false)
	@JoinColumn(name="Id", referencedColumnName="Id", insertable=false, updatable=false)
	private Pessoa pessoa;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNomeFantasia() {
		return NomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		NomeFantasia = nomeFantasia;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getIncricaoEstadual() {
		return IncricaoEstadual;
	}
	public void setIncricaoEstadual(String incricaoEstadual) {
		IncricaoEstadual = incricaoEstadual;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public PessoaJuridica() {
	}
}
